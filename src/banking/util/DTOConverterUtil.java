package banking.util;

import framework.dto.AccountDTO;
import framework.dto.PartyDTO;
import framework.entities.Account;
import framework.entities.Address;
import framework.entities.Party;
import banking.entities.Checking;
import banking.entities.Company;
import banking.entities.Person;

public class DTOConverterUtil {
	public static PartyDTO getPojoFromParty(Party party) {
		PartyDTO pp = new PartyDTO();
		pp.setId(party.getId());
		pp.setName(party.getName());
		Address address = party.getAddress();
		if (address != null) {
			pp.setStreet(address.getStreet());
			pp.setCity(address.getCity());
			pp.setState(address.getState());
			pp.setZip(address.getZip());
		}
		pp.setEmail(party.getEmail());
		if (party instanceof Person) {
			pp.setType("P");
			pp.setBirthDate(((Person) party).getBirthDate());
		} else {
			pp.setType("C");
			pp.setNumberOfEmployees(((Company) party).getNumberOfEmployees());
		}
		return pp;
	}

	public static AccountDTO getPojoFromAccount(Account acc) {
		AccountDTO pp = new AccountDTO();
		pp.setAccountNumber(acc.getAccountNumber());
		pp.setBalance(acc.getBalance());
		pp.setInterest(acc.getInterest());
		pp.setInterestRate(0);
		pp.setParty(acc.getParty());
		if (acc instanceof Checking) {
			pp.setType("Ch");
		} else {
			pp.setType("S");
		}
		return pp;
	}
}
