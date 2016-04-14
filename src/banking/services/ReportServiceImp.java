package banking.services;

import framework.dto.ReportDTO;
import framework.services.Report;
import framework.services.ReportService;
import banking.factories.ReportFactory;

public class ReportServiceImp implements ReportService {

	
	private static ReportServiceImp instance;
	private ReportFactory factory;
	
	private ReportServiceImp(){
		factory = new ReportFactory();
	}
	
	public static ReportService getInstance(){
		if(instance == null)
			instance = new ReportServiceImp();
		return instance;
	}

	@Override
	public Report createReport(ReportDTO dto) {
		return factory.create(dto);
	}

}
