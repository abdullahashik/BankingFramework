package banking.entities;

import java.time.LocalDate;

import framework.entities.Transaction;

public class DepositTransaction extends Transaction {

	public DepositTransaction(LocalDate date, double amount) {
		super(date, amount);
	}

	@Override
	public String getType() {
		return "Deposit";
	}
	
	@Override
	public String toString(){
		return super.toString()+String.format("%15s|\n", getType());
	}

}
