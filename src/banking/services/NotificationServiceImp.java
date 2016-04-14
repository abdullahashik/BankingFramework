package banking.services;

import framework.services.Message;
import framework.services.Notification;
import framework.services.NotificationService;

public class NotificationServiceImp implements NotificationService {
	
	private static NotificationServiceImp instance;
	//List<observer>
	private NotificationServiceImp(){
	}
	
	public static NotificationService getInstance(){
		if(instance == null)
			instance = new NotificationServiceImp();
		return instance;
	}

	@Override
	public Notification createNotification(String type) {
		if(type.equals("Mail")){
			return new NotificationMail();
		}
		return null;
	}

	@Override
	public Message createMessage(String from, String forr, String msg, String subject) {
		return new NotificationMessage(msg, subject, from, forr);
	}
}
