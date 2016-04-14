package framework.factories;

import framework.dto.AccountDTO;
import framework.entities.Account;
/**
 * 
 * @author AFL
 * @param <T>
 *
 */

public interface IAccountFactory extends IFactory<AccountDTO, Account>{
	@Override
	public Account create(AccountDTO dto);
}