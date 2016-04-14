package framework.services;

import framework.dal.AccountDAO;
import framework.dto.AccountDTO;
import framework.entities.Account;
import framework.factories.IAccountFactory;

public abstract class AbstractAccountService implements AccountService {
	protected AccountDAO accountDAO;
	private IAccountFactory factory;
	
	public AbstractAccountService(AccountDAO accountDAO, IAccountFactory factory){
		if(accountDAO!=null && factory!= null){
			this.accountDAO = accountDAO;
			this.factory = factory;
		}else{
			throw new RuntimeException("Provided argument is null");
		}
	}

	@Override
	public boolean saveAccount(AccountDTO dto) {
		Account account = factory.create(dto);
		System.out.println(
				"Framework Service Layer: AbstractAccountService: Inputs to saveAccount");
		if(accountDAO.add(account))
				return true;
		return false;
	}

	@Override
	public boolean deposit(String accountNumber, double amount) {
		System.out.println("Framework Service Layer: AbstractAccountService: Inputs to deposit method " + "accountNumber ="
				+ accountNumber + ", amount= " + amount);
		if(accountDAO.depositToAccount(accountNumber, amount)) //do the deposite
			return true;
		return false;
	}

	@Override
	public boolean wihdraw(String accountNumber, double amount) {
		System.out.println("Framework Service Layer: AbstractAccountService: Inputs to withdraw method " + "accountNumber ="
				+ accountNumber + ", amount= " + amount);
		if(accountDAO.wihdrawFromAccount(accountNumber, amount)) //do the withdraw
			return true;
		return false;
	}
	
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public void setFactory(IAccountFactory factory) {
		this.factory = factory;
	}

}
