package framework.factories;

import framework.dto.TransactionDTO;
import framework.entities.Transaction;

public interface ITransactionFactory extends IFactory<TransactionDTO, Transaction> {
	@Override
	public Transaction create(TransactionDTO dto);
}
