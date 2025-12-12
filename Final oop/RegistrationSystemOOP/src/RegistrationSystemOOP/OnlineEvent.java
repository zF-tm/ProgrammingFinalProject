package RegistrationSystemOOP;

public class OnlineEvent extends Event{
	private String eventPlatform;
	
	public OnlineEvent(String name, int date, String duration,
			int capacity, String eventPlatform) {
		super(name,date,duration,"Online", capacity);
		this.eventPlatform = eventPlatform;
	}

	public String getEventPlatform() {
		return eventPlatform;
	}
	
	public String getType() {
		return "Online Event";
	}
	
	public void printEventInfo() {
		super.printEventInfo();
		System.out.println("Platform: " + eventPlatform);
	}
}
