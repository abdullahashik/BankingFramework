package framework.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
	
	private String accountNumber;//account number
	private double interest;
	private Party party;//Account owned only by one party
	private double balance;
	private List<Transaction> transactions;
	
	public Account(){
		
	}
	
	public Account(String accountNumber, double interest, Party party, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.interest = interest;
		this.party = party;
		this.balance = balance;
		this.transactions = new ArrayList<Transaction>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getInterest() {
		return interest;
	}

	public Party getParty() {
		return party;
	}

	public double getBalance() {
		return balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	} 
	
	
	public void addTransaction(Transaction transaction){
		transactions.add(transaction);
	}
	
	@Override
	public String toString(){
		return String.format("|%12s|",this.accountNumber+"")+
				String.format("%25s|",party.getName())+
				String.format("%15s|",party.getAddress()!=null?party.getAddress().getCity():"")+ 
				String.format("%15s|",party.getClass().getSimpleName().equals("Person")?"Personal":"Company")+
				String.format("%15s|",this.getClass().getSimpleName())+
				String.format("%15s|\n", this.balance);
	}

}
