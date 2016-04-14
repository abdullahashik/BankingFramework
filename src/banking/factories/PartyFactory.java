package banking.factories;

import framework.dto.PartyDTO;
import framework.entities.Address;
import framework.entities.Party;
import framework.factories.IPartyFactory;
import banking.entities.Company;
import banking.entities.Person;

public class PartyFactory implements IPartyFactory {

	@Override
	public Party create(PartyDTO dto) {
		Party client = null;
		Address address = new Address(dto.getStreet(), dto.getCity(), dto.getState(), dto.getZip());
		switch (dto.getType()) {
		case "P":
			client = new Person(dto.getName(), address, dto.getEmail(), dto.getBirthDate());
			break;
		case "C":
			 client = new Company(dto.getName(), address, dto.getEmail(), dto.getNumberOfEmployees());
			break;
		}
		return client;
	}

}
