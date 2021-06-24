package zeroday.events;

public class EventChat extends mainEvent<EventChat>{
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EventChat(String message) {
		this.message = message;
	}

	public String message;
	
}
