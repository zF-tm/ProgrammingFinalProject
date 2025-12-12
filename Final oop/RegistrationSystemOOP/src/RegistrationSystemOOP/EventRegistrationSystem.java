package RegistrationSystemOOP;
import java.util.Scanner;
public class EventRegistrationSystem {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		EventManager manager = new EventManager();
		int choice;
		boolean firstRun = true;
		
		while(true) {
			if(!firstRun) {
				System.out.println("\nPress Enter to continue");
				scanner.nextLine();
			}
			
			firstRun = false;
			printMenu();
			choice = scanner.nextInt();
			scanner.nextLine();
			switch(choice) {
			case 1: addStandardEvent(manager); break;
			case 2: addOnlineEvent(manager); break;
			case 3: manager.printAllEvents(); break;
			case 4: manager.printEventsSorted(); break ;
			case 5: registerParticipant(manager); break;
			case 6: manager.printRegistrationReport(); break;
			case 0: System.out.println("GoodBye!"); return;
			default: System.out.println("Not a valid Choice"); break;
			}
		}
		

	}
	private static void addStandardEvent(EventManager manager) {
		System.out.println("\n=====Add Standard Event=====");
		System.out.println("Event name: ");
		String name = scanner.nextLine();
		System.out.println("Event Date In The Format YYYYMMDD: ");
		int date = scanner.nextInt(); 
		scanner.nextLine();
		System.out.println("Event Duration (Example: 2 hours): ");
		String duration= scanner.nextLine();
		System.out.println("Event Location: ");
		String location = scanner.nextLine();
		System.out.println("Event Capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();
		
		manager.addStandardEvent(name, date, duration, location, capacity);
	}
	private static void addOnlineEvent(EventManager manager) {
		System.out.println("\n=====Add Online Event=====");
		System.out.println("Event name: ");
		String name = scanner.nextLine();
		System.out.println("Event Date In The Format YYYYMMDD: ");
		int date = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Event Duration (Example: 2 hours): ");
		String duration= scanner.nextLine();
		System.out.println("Event Platform (Example: teams, zoom, etc...): ");
		String eventplatform = scanner.nextLine();
		System.out.println("Event Capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();
		
		manager.addOnlineEvent(name, date, duration, capacity , eventplatform);
	}
	private static void registerParticipant(EventManager manager) {
		System.out.println("\n===== Register Participant =====");
		if(manager.getEvents().isEmpty()) {
			System.err.println("No Events Available");
		} else {
			while(true) {
				manager.printAllEvents();
				System.out.println("Enter the id of the event you want to add the participant to: ");
				int eventId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Participant Name: ");
				String participantName = scanner.nextLine();
				System.out.println("Enter the participant contact info: ");
				String contactInfo = scanner.nextLine();
			
				Participant p = new Participant(participantName , contactInfo);
				boolean added = manager.registerParticipantToEvent(eventId, p);
				if(added) {
					System.out.println("Participant " + p.getName() + " Registered Successfully to the event" + manager.findEventById(eventId).getName());
					break;
				} else {
					System.err.println("Participant Registration Failed.");
					System.out.println("Press Enter to continue...");
					scanner.nextLine();
				}
			}
		}
	}
	private static void printMenu() {
        System.out.println("\n==============================");
        System.out.println(" Event Registration System");
        System.out.println("==============================");
        System.out.println("1) Add Standard Event");
        System.out.println("2) Add Online Event");
        System.out.println("3) Print All Events");
        System.out.println("4) Print Upcoming Events (Sorted by Date)");
        System.out.println("5) Register Participant to Event");
        System.out.println("6) Print Registration Report");
        System.out.println("0) Exit");
        System.out.println("==============================");
    }

}
