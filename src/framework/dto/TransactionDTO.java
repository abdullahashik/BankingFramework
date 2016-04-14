package framework.dto;

import java.time.LocalDate;

//Transaction represent an action happened on an account (e.g. withdraw from an account)

public class TransactionDTO implements IDTO{
	
	private int number; //transaction number
	private LocalDate date;//transaction date
	private double ammount;
	private String type;

	public int getNumber() {
		return number;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
