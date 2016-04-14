package framework.factories;

import framework.dto.ReportDTO;
import framework.services.Report;

public interface IReportFactory extends IFactory<ReportDTO, Report> {
	@Override
	public Report create(ReportDTO dto);
}
