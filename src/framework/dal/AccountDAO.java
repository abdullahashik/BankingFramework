package framework.dal;

import framework.entities.Account;
import framework.entities.Transaction;

public interface AccountDAO extends IDAO<Account>{
	
	boolean depositToAccount(String accountNumber, double amount);
	
	boolean wihdrawFromAccount(String accountNumber, double amount);
	
	boolean addInterest(String accountNumber, double interest);//add interest to specific account. TODO: is the signature is correct
	
	boolean addTransacionToAccount(String accountNumber, Transaction transaction);
	
	boolean addInterestToAllAccounts(double interest);

}
