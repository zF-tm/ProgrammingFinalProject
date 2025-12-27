package RegistrationSystemOOP;
import java.time.LocalDate;
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
	public static int todaysDate() {
	    LocalDate today = LocalDate.now();
	    int year = today.getYear();
	    int month = today.getMonthValue();
	    int day = today.getDayOfMonth();
	    
	    
	    return (year * 10000) + (month * 100) + day;
	}
	
	public static boolean dateValid(int date) {
		int day = date % 100;
        int month = (date / 100) % 100;

        if (date < 10000000 || date > 99999999 || date < todaysDate()) {
            return false;
        }
        else if (month < 1 || month > 12) {
        	return false;
        }
        else if (day < 1 || day > Event.daysInMonth(month)) {
        	return false;
        }
        else {
            return true;
        }
	}
	public static boolean nameValid(String name, EventManager manager) {
		boolean flag = true;
		for(Event event: manager.getEvents()) {
			if(name.trim().toLowerCase().equals(event.getName().trim().toLowerCase())) {
				flag = false;
				break;
			}
		}
		if(name.trim().isEmpty()) {
			flag = false;
		}
		return flag;
		
	}
	public static boolean locationValid(String location) {
		if(location.trim().isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	private static void addStandardEvent(EventManager manager) {
		System.out.println("\n=====Add Standard Event=====");
		
		
		System.out.println("Event name: ");
		String name = scanner.nextLine();
		
		while(!nameValid(name, manager)) {
			System.err.println("Choose Another Name: ");
			name = scanner.nextLine();
		}
		
		
		System.out.println("Event Date In The Format YYYYMMDD: ");
		int date = scanner.nextInt(); 
		scanner.nextLine();
		
		while(!dateValid(date)) {
			System.err.print("Date Invalid,");
			System.out.println(" Please Enter The Date Again: ");
			date = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.println("Event Duration (Example: 2 hours): ");
		String duration= scanner.nextLine();
		
		while(duration.trim().isEmpty()) {
			System.err.println("Duration can't be empty, Choose Another Duration: ");
			duration = scanner.nextLine();
		}
		
		
		System.out.println("Event Location: ");
		String location = scanner.nextLine();
		
		while(!locationValid(location)) {
			System.err.println("Choose Another Location: ");
			location = scanner.nextLine();
		}
		
		System.out.println("Event Capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();
		
		while(capacity<=0) {
			System.out.println("Capacity can't be lower or equal to zero, enter another: ");
			capacity = scanner.nextInt();
			scanner.nextLine();
		}
		
		
		manager.addStandardEvent(name, date, duration, location, capacity);
	}
	private static void addOnlineEvent(EventManager manager) {
		System.out.println("\n=====Add Online Event=====");
		System.out.println("Event name: ");
		String name = scanner.nextLine();
		
		while(!nameValid(name, manager)) {
			System.err.println("Choose Another Name: ");
			name = scanner.nextLine();
		}
		
		System.out.println("Event Date In The Format YYYYMMDD: ");
		int date = scanner.nextInt();
		scanner.nextLine();
		
		while(!dateValid(date)) {
			System.err.print("Date Invalid,");
			System.out.println(" Please Enter The Date Again: ");
			date = scanner.nextInt();
			scanner.nextLine();
		}
		
		System.out.println("Event Duration (Example: 2 hours): ");
		String duration= scanner.nextLine();
		
		while(duration.trim().isEmpty()) {
			System.err.println("Duration can't be empty, Choose Another Duration: ");
			duration = scanner.nextLine();
		}
		
		System.out.println("Event Platform (Example: teams, zoom, etc...): ");
		String eventPlatform = scanner.nextLine();
		
		while(eventPlatform.trim().isEmpty()) {
			System.out.println("Please Enter a Platform: ");
			eventPlatform = scanner.nextLine();
		}
		
		System.out.println("Event Capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();
		
		while(capacity<=0) {
			System.out.println("Capacity can't be lower or equal to zero, enter another: ");
			capacity = scanner.nextInt();
			scanner.nextLine();
		}
		
		
		manager.addOnlineEvent(name, date, duration, capacity , eventPlatform);
	}
	public static boolean participantNameValid(String name, int ID, EventManager manager) {
		
		boolean flag = true;
		for(Participant participant: manager.getEvents().get(ID).getParticipants()) {
			if(name.trim().toLowerCase().equals(participant.getName().trim().toLowerCase())) {
				flag = false;
				break;
			}
		}
		if(name.isEmpty()) {
			flag = false;
		}
		return flag;
	}
	public static boolean emailParticipantValid(String email, int ID, EventManager manager) {
		
		boolean flag = true;
		for(Participant participant: manager.getEvents().get(ID).getParticipants()) {
			if(email.trim().toLowerCase().equals(participant.getContactInfo().trim().toLowerCase())) {
				flag = false;
				break;
			}
		}
		if(email.isEmpty()) {
			flag = false;
		}
		return flag;
	}
	private static void registerParticipant(EventManager manager) {
		System.out.println("\n===== Register Participant =====");
		if(manager.getEvents().isEmpty()) {
			System.err.println("No Events Available");
		} else {
			manager.printAllEvents();
			System.out.println("Enter The ID of the event u want to register a participant in: ");
			int searchID = scanner.nextInt();
			scanner.nextLine();
			boolean found = false;
			for(Event e : manager.getEvents()) {
				if(e.getId() == searchID) {
					found = true;
					break;
				}
			}
			if(found && manager.getEvents().get(searchID-1).getParticipants().size() < manager.getEvents().get(searchID-1).getCapacity()) {
				System.out.println("Enter the name of the participant you want to add: ");
				String name = scanner.nextLine();
				while(!participantNameValid(name,searchID-1,manager)) {
					System.err.println("Name Either duplicated or empty, please choose another name: ");
					name = scanner.nextLine();
				}
				System.out.println("Enter The participant's contact information: ");
				String contactInfo = scanner.nextLine();
				while(!emailParticipantValid(contactInfo,searchID-1,manager)) {
					System.out.println("Contact info Either duplicate or empty, enter another contact : ");
					contactInfo = scanner.nextLine();
				}
				Participant p = new Participant(name,contactInfo);
				manager.registerParticipantToEvent(searchID, p);
			} else if(!found) {
				System.err.println("Event id not found.");
			} else if(manager.getEvents().get(searchID-1).getParticipants().size() >= manager.getEvents().get(searchID-1).getCapacity()){
				System.err.println("This Event is full.");
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
