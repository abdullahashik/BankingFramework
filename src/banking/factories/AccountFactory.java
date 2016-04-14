package banking.factories;

import framework.dto.AccountDTO;
import framework.entities.Account;
import framework.factories.IAccountFactory;
import banking.entities.Checking;
import banking.entities.Saving;

public class AccountFactory implements IAccountFactory {

	@Override
	public Account create(AccountDTO dto) {
		Account account = null;
		switch (dto.getType()) {
		case "Ch":
			account = new Checking(dto.getAccountNumber(), 0, dto.getParty(),dto.getBalance());
			break;
		case "S":
			 account = new Saving(dto.getAccountNumber(), 0, dto.getParty(), dto.getBalance());
			break;
		}
		return account;
	}

}
