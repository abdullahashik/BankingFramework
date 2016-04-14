package framework.services;

public interface NotificationService {

	public default void sendNotification(String from, String forr, String msg, String subject, String type){
		Message message = createMessage(from, forr, msg, subject);
		Notification notification = createNotification(type);
		notification.send(message);
	}

	public Notification createNotification(String type);
	
	public Message createMessage(String from, String forr, String msg, String subject);

}