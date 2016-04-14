package banking.dal;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import framework.dal.AccountDAO;
import framework.entities.Account;
import framework.entities.Transaction;
import framework.util.GeneratorUtil;
import framework.util.SystemConstant;
import banking.database.DBTables;
import banking.entities.DepositTransaction;
import banking.entities.WithdrawTransaction;

public class AccountDAOImp implements AccountDAO {

	@Override
	public boolean add(Account account) {
		account.setAccountNumber(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
		DBTables.ACCOUNT_TABLE.add(account);
		return true;
	}

	@Override
	public boolean depositToAccount(String accountNumber, double amount) {
		
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.setBalance(accountToUpdate.getBalance() + amount); // TODO: test it	
			DepositTransaction depositTransaction = new DepositTransaction(LocalDate.now(), amount);
			depositTransaction.setNumber(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
			addTransacionToAccount(accountNumber, depositTransaction);
			return true;
		}

		return false;
	}

	@Override
	public boolean wihdrawFromAccount(String accountNumber, double amount) {
		
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.setBalance(accountToUpdate.getBalance() - amount); // TODO: test it
			WithdrawTransaction withdrawTransaction = new WithdrawTransaction(LocalDate.now(), amount);
			withdrawTransaction.setNumber(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
			addTransacionToAccount(accountNumber, withdrawTransaction);
			return true;
		}

		return false;
	}

	@Override
	public boolean addInterest(String accountNumber, double interest) {
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.setInterest(interest); // TODO: test it																				 
			return true;
		}

		return false;
	}
	
	//Return Account object if found, null if not
	@Override
	public Account find(String accountNumber){
		List<Account> list = 
				DBTables.ACCOUNT_TABLE.stream().
				filter(account -> account.getAccountNumber() == accountNumber)
				.collect(Collectors.toList()); //should get one object
		
		if (list.size() > 0)
			return list.get(0);
		
		return null;
		
	}

	@Override
	public List<Account> getAll() {
		return DBTables.ACCOUNT_TABLE;
	}

	@Override
	public boolean addTransacionToAccount(String accountNumber,	Transaction transaction) {
		Account accountToUpdate = find(accountNumber);
		if (accountToUpdate != null) {
			accountToUpdate.addTransaction(transaction); // TODO: test it																				 
			return true;
		}

		return false;
	}

	@Override
	public boolean addInterestToAllAccounts(double interest) {
		List<Account> accounts = getAll();
		Iterator<Account> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Account account = iterator.next();
			account.setInterest(interest);// TODO: what about the intrest
			// If we have data base, then we should updae the interest and save
			// for each account
		}
		return true;
	}

}
