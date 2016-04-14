package banking.entities;

import framework.entities.Address;
import framework.entities.Party;

public class Company extends Party {

	private int numberOfEmployees;
	
	public Company(String name, Address address, String email, int numberOfEmployees) {
		super(name, address, email);
		this.numberOfEmployees = numberOfEmployees;
	}

	
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	
}
