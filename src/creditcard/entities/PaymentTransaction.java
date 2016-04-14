package creditcard.entities;

import java.time.LocalDate;

import framework.entities.Transaction;

public class PaymentTransaction extends Transaction {

	public PaymentTransaction(LocalDate date, double amount) {
		super(date, amount);
	}

	@Override
	public String getType() {
		return "Payment";
	}

}
