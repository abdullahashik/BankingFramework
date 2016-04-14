package creditcard.services;

import framework.services.Message;
import framework.services.Notification;

public class NotificationMail implements Notification {
	
	@Override
	public void send(Message notification) {
		System.out.println("-------Notification Message Sended--------");
		System.out.println(notification.toString());
	}

}
