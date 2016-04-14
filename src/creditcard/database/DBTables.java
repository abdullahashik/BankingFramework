package creditcard.database;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import framework.entities.Account;
import framework.entities.Address;
import framework.entities.Party;
import framework.entities.Transaction;
import creditcard.entities.ChargeTransaction;
import creditcard.entities.Company;
import creditcard.entities.CreditCardAccount;
import creditcard.entities.PaymentTransaction;
import creditcard.entities.Person;
//This class represents a database. Each list represent a table

public class DBTables {
	
	
	public static List<Account> ACCOUNT_TABLE = new ArrayList<Account>(); //TODO: make it as List<Account> and add default accounts
	
	public static List<Party> Party_TABLE = new ArrayList<Party>(); 
	
	static {
		//String name, Address address, String email, int numberOfEmployees
		//String street, String city, String state, String zip
		//Checking String accountNumber, double interest, Party party, double balance
		//Saving String accountNumber, double interest, Party party, double balanc
		Party c1 = new Company("Google", new Address("43 E Whashinton","Mountain View","CA","89745"),"google@google.com",10000);
		c1.setId("101");
		Party c2 = new Company("Netflix", new Address("67 W Meridi","Los Gatos","CA","89745"),"netflix@netflix.com",10000);
		c2.setId("102");
		Party c3 = new Company("Microsoft", new Address("Mond W 56","Seattle","CA","89745"),"microsoft@microsoft.com",10000);
		c3.setId("103");
		Party c4 = new Company("Facebook", new Address("NA","Facebookland","CA","89745"),"facebook@facebook.com",10000);
		c4.setId("104");
		
		Party p1 = new Person("Larry Page",new Address("455 E Street 1","Chicago","IL","56899"),"larry@gmail.com", LocalDate.of(1990, 2, 27));
		p1.setId("201");
		Party p2 = new Person("Andrew Smith",new Address("658 W Avenue","Miami","FL","56899"),"andrew@netflix.com", LocalDate.of(1980, 10, 14));
		p2.setId("202");
		Party p3 = new Person("Bill Gates",new Address("8791 E Ttee","Sillicon Valley","NA","56899"),"bill@microsoft.com", LocalDate.of(1990, 2, 27));
		p3.setId("301");
		Party p4 = new Person("Mark Zuckerber",new Address("32450 Trer 8","Facebookland","NA","56899"),"mark@f.com", LocalDate.of(1990, 2, 27));
		p4.setId("204");
		
		Party_TABLE.add(c1);
		Party_TABLE.add(c2);
		Party_TABLE.add(c3);
		Party_TABLE.add(c4);
		
		Party_TABLE.add(p1);
		Party_TABLE.add(p2);
		Party_TABLE.add(p3);
		Party_TABLE.add(p4);
		
		Account ac1 = new CreditCardAccount("1001",0,c1,5000,CreditCardAccount.Type.BRONZE);
		Transaction t1 = new ChargeTransaction(LocalDate.of(2015, 12, 30),1000);
		t1.setNumber("1");
		ac1.addTransaction(t1);
		Transaction t2 = new PaymentTransaction(LocalDate.now(),500);
		t2.setNumber("2");
		ac1.addTransaction(t2);
//		
		ACCOUNT_TABLE.add(ac1);
		ACCOUNT_TABLE.add(new CreditCardAccount("1002",0,c1,800000,CreditCardAccount.Type.BRONZE));
		ACCOUNT_TABLE.add(new CreditCardAccount("2001",0,c2,4000,CreditCardAccount.Type.GOLD));
		ACCOUNT_TABLE.add(new CreditCardAccount("2002",0,c2,900000,CreditCardAccount.Type.SILVER));
		ACCOUNT_TABLE.add(new CreditCardAccount("3001",0,c3,6000,CreditCardAccount.Type.BRONZE));
		ACCOUNT_TABLE.add(new CreditCardAccount("3002",0,c3,100000,CreditCardAccount.Type.GOLD));
		ACCOUNT_TABLE.add(new CreditCardAccount("4001",0,c4,66000,CreditCardAccount.Type.SILVER));
//
		Account ac2 = new CreditCardAccount("5002",0,p1,800000,CreditCardAccount.Type.BRONZE);
		 t2 = new  ChargeTransaction(LocalDate.of(2015, 11, 30),15000);
		t2.setNumber("3");
		ac2.addTransaction(t2);
		t2 = new PaymentTransaction(LocalDate.now(),50000);
	    t2.setNumber("4");
		ac2.addTransaction(t2);
//		
		ACCOUNT_TABLE.add(new CreditCardAccount("5001",0,p1,5000,CreditCardAccount.Type.BRONZE));
		ACCOUNT_TABLE.add(ac2);
		ACCOUNT_TABLE.add(new CreditCardAccount("6001",0,p2,4000,CreditCardAccount.Type.GOLD));
		ACCOUNT_TABLE.add(new CreditCardAccount("6002",0,p2,900000,CreditCardAccount.Type.SILVER));
		ACCOUNT_TABLE.add(new CreditCardAccount("7001",0,p3,6000,CreditCardAccount.Type.BRONZE));
		ACCOUNT_TABLE.add(new CreditCardAccount("7002",0,p3,100000,CreditCardAccount.Type.GOLD));
		ACCOUNT_TABLE.add(new CreditCardAccount("8001",0,p4,66000,CreditCardAccount.Type.SILVER));
	}
	
	private DBTables(){	}
	
	

}
