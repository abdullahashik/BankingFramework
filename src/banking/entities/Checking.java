package banking.entities;

import framework.entities.Account;
import framework.entities.Party;

public class Checking extends Account {

	public Checking(String accountNumber, double interest, Party party, double balance) {
		super(accountNumber, interest, party, balance);
		
	}

}
