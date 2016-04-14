package banking.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import framework.dto.PartyDTO;
import framework.entities.Party;
import framework.services.AbstractPartyService;
import banking.dal.PartyDAOImp;
import banking.factories.PartyFactory;
import banking.util.DTOConverterUtil;

public class PartyServiceImp extends AbstractPartyService {


	private static PartyServiceImp instance;
	
	private PartyServiceImp(){
		super(new PartyDAOImp(), new PartyFactory());
	}
	
	public static PartyServiceImp getInstance() {
		if (instance == null) {
			synchronized (PartyServiceImp.class) {
				if (instance == null)
					instance = new PartyServiceImp();
			}
		}
		return instance;
	}

	@Override
	public List<PartyDTO> getAllParties() {
		List<PartyDTO> resList = new ArrayList<PartyDTO>();
		List<Party> accounts = partyDAO.getAll();
		Iterator<Party> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Party cust = iterator.next();
			PartyDTO pp = DTOConverterUtil.getPojoFromParty(cust);
			resList.add(pp);
		}
		return resList;
	}

}
