package creditcard.services;

import java.time.LocalDate;

import framework.services.Report;
import creditcard.dal.AccountDAOImp;
import creditcard.entities.CreditCardAccount;

public class MonthlyBillingReport extends Report {

	public MonthlyBillingReport(String filter) {
		super(new AccountDAOImp(), filter);
	}

	@Override
	public String getReport() {
		
		CreditCardAccount account = (CreditCardAccount) accountDAO.find(this.getFilter());
		
		double totalCreditsMonth = 
				account.getTransactions()
				.stream().filter(t->t.getDate().getMonth()==LocalDate.now().getMonth())
				.filter(y->y.getType().equals("Payment"))
				.mapToDouble(x->x.getAmmount()).sum();
		
		double totalChargesMonth = 
				account.getTransactions()
				.stream().filter(t->t.getDate().getMonth()==LocalDate.now().getMonth())
				.filter(y->y.getType().equals("Charge"))
				.mapToDouble(x->x.getAmmount()).sum();
		
		double previousBalance = account.getBalance() - totalCreditsMonth + totalChargesMonth;
		
		double newbalance = previousBalance - totalCreditsMonth + totalChargesMonth + account.getMonthlyInterest()*(previousBalance-totalCreditsMonth);
		
		double totaldue = account.getMinimumPayment() * newbalance;
		
		StringBuilder reportResult = new StringBuilder();
		reportResult.append("--Monthly Billing Report--\n");
		reportResult.append("---------------------------------------------------------------------------------------------------------------------------------\n");
		reportResult.append(String.format("|%12s|","Account")+
		String.format("%20s|","Previous Balance")+
		String.format("%15s|","Total Charges")+ 
		String.format("%15s|","Total Credits")+
		String.format("%15s|","New Balance")+
		String.format("%15s|\n", "Total Due"));
        reportResult.append("---------------------------------------------------------------------------------------------------------------------------------\n");
        reportResult.append(String.format("|%12s|",account.getAccountNumber())+
        		String.format("%20s|",previousBalance)+
        		String.format("%15s|",totalChargesMonth)+ 
        		String.format("%15s|",totalCreditsMonth)+
        		String.format("%15s|",newbalance)+
        		String.format("%15s|\n", totaldue));
        
		return reportResult.toString();
	}

}
