package creditcard.dal;

import java.util.List;
import java.util.stream.Collectors;

import framework.dal.PartyDAO;
import framework.entities.Party;
import framework.util.GeneratorUtil;
import framework.util.SystemConstant;
import creditcard.database.DBTables;

public class PartyDAOImp implements PartyDAO {

	@Override
	public boolean add(Party party) {
		party.setId(GeneratorUtil.randomString(SystemConstant.RAND_LOWER, SystemConstant.RAND_HIGHER));
		DBTables.Party_TABLE.add(party);
		return true;
	}

	@Override
	public List<Party> getAll() {
		return DBTables.Party_TABLE;
	}

	@Override
	public Party find(String id) {
		List<Party> list = 
				DBTables.Party_TABLE.stream().
				filter(party -> party.getId().equals(id))
				.collect(Collectors.toList()); //should get one object
		
		if (list.size() > 0)
			return list.get(0);
		return null;
	}

	
}
