package creditcard.factories;

import framework.dto.ReportDTO;
import framework.factories.IReportFactory;
import framework.services.Report;
import creditcard.services.MonthlyBillingReport;

public class ReportFactory implements IReportFactory {

	@Override
	public Report create(ReportDTO dto) {
		Report report = null;
		switch (dto.getType()) {
		case "Monthly":
			report = new MonthlyBillingReport(dto.getFilter());
			break;
		}
		return report;
	}

}
