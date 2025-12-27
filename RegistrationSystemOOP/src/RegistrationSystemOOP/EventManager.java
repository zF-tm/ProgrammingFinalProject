package RegistrationSystemOOP;
import java.util.ArrayList;
public class EventManager {
	private ArrayList<Event> events;
	public EventManager() {
		events = new ArrayList<>();
	}
	public void addStandardEvent(String name, int date, 
			String duration, String location, int capacity) {
		Event e = new Event(name,date,duration,location,capacity);
		events.add(e);
		System.out.println("Event added");
		e.printEventInfo();
	}
	public void addOnlineEvent(String name, int date, String duration, 
			int capacity, String eventPlatform) {
		Event e = new OnlineEvent(name,date,duration,capacity,eventPlatform);
		events.add(e);
		System.out.println("Event added");
		e.printEventInfo();
		
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public Event findEventById(int id) {
		for(Event e: events) {
			if(e.getId() == id) {
				return e;
			}
		}
		return null;
	}
	public boolean registerParticipantToEvent(int eventId , Participant p) {
		Event e = findEventById(eventId);
		if(e == null) {
			return false;
		}
		return e.registerParticipant(p);
	}
	public ArrayList<Event> getEventsSorted() {
		ArrayList<Event> sortedEvents = new ArrayList<>(events);
		int n = sortedEvents.size();
		boolean swapped;
		for(int i = 0 ; i<n - 1 ; i++) {
			swapped = false;
			for(int j = 0 ; j < n-1-i ; j++) {
				Event e1 = sortedEvents.get(j);
				Event e2 = sortedEvents.get(j + 1);
				
				if(e1.getDateAsInteger() > e2.getDateAsInteger()) {
					sortedEvents.set(j ,  e2);
					sortedEvents.set(j+1 ,  e1);
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
		return sortedEvents;
	} 
	public void printAllEvents() {
		if(events.isEmpty()) {
			System.out.println("No Events available");
		} else {
			System.out.println("\tAllEvents");
			for(Event e : events) {
				e.printEventInfo();
			}
		}
	}
	
	public void printEventsSorted() {
		ArrayList<Event> sortedEvents = getEventsSorted();
		if(sortedEvents.isEmpty()) {
			System.out.println("No Events Avaailable");
		} else {
			System.out.println("\tUpcoming Events:");
			for(Event e:sortedEvents) {
				e.printEventInfo();
			}
		}
	}
	
	public void printRegistrationReport() {
		if(events.isEmpty()) {
			System.out.println("No Events to report");
		} else {
			System.out.println("========Registration Report========");
			for(Event e:events) {
				e.printEventInfo();
				if(e.getRegisteredCount() == 0) {
					System.out.println("No Participants");
				} else {
					System.out.println("Participants: ");
					for(Participant p : e.getParticipants()) {
						p.printParticipantInfo();
					}
				}
			}
			System.out.println("===================================");
		}
	}
}
