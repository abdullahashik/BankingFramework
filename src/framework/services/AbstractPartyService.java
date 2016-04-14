package framework.services;

import framework.dal.PartyDAO;
import framework.dto.PartyDTO;
import framework.entities.Party;
import framework.factories.IPartyFactory;

public abstract class AbstractPartyService implements PartyService {

	protected PartyDAO partyDAO;
	private IPartyFactory factory;
	
	public AbstractPartyService(PartyDAO partyDAO, IPartyFactory factory){
		if(partyDAO!=null && factory!=null){
			this.partyDAO = partyDAO;
			this.factory = factory;
		}else{
			throw new RuntimeException("Provided DAO is null");
		}
	}
	
	@Override
	public boolean saveParty(PartyDTO dto) {
		Party party = factory.create(dto);
		System.out.println(
				"Framework Service Layer: AbstractPartyService: Inputs to saveParty");
		if (partyDAO.add(party))
			return true;
		return false;
	}

	@Override
	public Party findParty(String id) {
			return partyDAO.find(id);
	}

	

}
