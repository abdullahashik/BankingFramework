package framework.entities;

import java.time.LocalDate;

//Transaction represent an action happened on an account (e.g. withdraw from an account)

public abstract class Transaction {
	
	private String number; //transaction number
	private LocalDate date;//transaction date
	private double ammount;
	
	public Transaction(LocalDate date, double amount) {
		super();
		this.date = date;
		this.ammount = amount;
	}

	public String getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getAmmount() {
		return ammount;
	}

	public abstract String getType();

	public void setNumber(String number) {
		this.number = number;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}
	
	@Override
	public String toString(){
		return String.format("|%12s|",number)+
				String.format("%15s|",date)+
				String.format("%15s|",ammount);
	}
	
	
	

}
