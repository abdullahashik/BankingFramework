package banking.factories;

import framework.dto.ReportDTO;
import framework.factories.IReportFactory;
import framework.services.Report;
import banking.services.TransactionReport;

public class ReportFactory implements IReportFactory {

	@Override
	public Report create(ReportDTO dto) {
		Report report = null;
		switch (dto.getType()) {
		case "Transaction":
			report = new TransactionReport(dto.getFilter());
			break;
		}
		return report;
	}

}
