package creditcard.entities;

import framework.entities.Account;
import framework.entities.Party;

public class CreditCardAccount extends Account {
	
	public enum Type{
		GOLD(0.06,0.1),SILVER(0.08,0.12),BRONZE(0.1,0.14);
		public final double monthlyInterest;
	    public final double minimumPayment; 
	    
		Type(double monthlyInterest, double minimumPayment){
			this.monthlyInterest = monthlyInterest;
			this.minimumPayment = minimumPayment;
		}
	}
	
	private Type type;

	public CreditCardAccount(String accountNumber, double interest, Party party, double balance, Type type) {
		super(accountNumber, interest, party, balance);
		this.type = type;
	}

	public double getMonthlyInterest() {
		return type.monthlyInterest;
	}

	public double getMinimumPayment() {
		return type.minimumPayment;
	}

	public Type getType() {
		return type;
	}

}
