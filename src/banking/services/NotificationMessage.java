package banking.services;

import framework.services.Message;

public class NotificationMessage implements Message {

	String forr;
	String from;
	String msg;
	String subject;
	
	public NotificationMessage(String msg, String subject, String from, String forr) {
		this.msg = msg;
		this.subject = subject;
		this.from = from;
		this.forr = forr;
	}
	
	/* (non-Javadoc)
	 * @see service.Message#getMsg()
	 */
	@Override
	public String getMsg() {
		return msg;
	}
	/* (non-Javadoc)
	 * @see service.Message#getSubject()
	 */
	@Override
	public String getSubject() {
		return subject;
	}
	/* (non-Javadoc)
	 * @see service.Message#getFrom()
	 */
	@Override
	public String getFrom() {
		return from;
	}
	/* (non-Javadoc)
	 * @see service.Message#getForr()
	 */
	@Override
	public String getForr() {
		return forr;
	}

	@Override
	public String toString() {
		return "NotificationMessage [for=" + forr + ", from=" + from + ", msg=" + msg + ", subject=" + subject + "]";
	}
}
