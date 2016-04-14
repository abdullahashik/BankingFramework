package framework.services;

import java.util.List;

import framework.dto.AccountDTO;

public interface AccountService {
	
	boolean saveAccount(AccountDTO dto);//add account to database
	
	//Account createAccount(String type); //create an instance of the an specific type of account
	
	boolean addInterest(double interest);
	
	boolean deposit(String accountNumbr, double amount);
	
	boolean wihdraw(String accountNumbr, double amount);
	
	public List<AccountDTO> getAllAccounts();

}
