package framework.factories;

import framework.dto.PartyDTO;
import framework.entities.Party;

/**
 * 
 * @author AFL
 * @param <T>
 *
 */
public interface IPartyFactory extends IFactory<PartyDTO, Party>{
	@Override
	public Party create(PartyDTO dto);
}