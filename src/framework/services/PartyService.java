package framework.services;

import java.util.List;

import framework.dto.PartyDTO;
import framework.entities.Party;

public interface PartyService {

	public boolean saveParty(PartyDTO dto); // add party to database (Person or
											// Company)

	Party findParty(String email);

	public List<PartyDTO> getAllParties();
}
