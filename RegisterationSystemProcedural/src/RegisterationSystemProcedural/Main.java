package RegisterationSystemProcedural;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
	public static ArrayList<Integer> ids = new ArrayList<>();
	public static ArrayList<String> events = new ArrayList<>();
	public static ArrayList<String> locations = new ArrayList<>();
	public static ArrayList<Integer> dates = new ArrayList<>();
	public static ArrayList<String> durations = new ArrayList<>();
	public static ArrayList<Integer> capacities = new ArrayList<>();
	public static ArrayList<ArrayList<String>> participants = new ArrayList<>();
	public static Scanner scanner = new Scanner(System.in);
	public static int id = 0;
	public static void main(String[] args) {
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
			case 1: addStandardEvent(scanner); break;
			case 2: addOnlineEvent(scanner); break;
			case 3: printAllEvents(); break;
			case 4: printUpcomingEvents(); break ;
			case 5: registerParticipant(scanner); break;
			case 6: printRegistrationReport(); break;
			case 0: System.out.println("GoodBye!"); return;
			default: System.out.println("Not a valid Choice"); break;
			}
		}

	}
	
	public static void printMenu() {
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
	public static int todaysDate() {
	    LocalDate today = LocalDate.now();
	    int year = today.getYear();
	    int month = today.getMonthValue();
	    int day = today.getDayOfMonth();
	    
	    
	    return (year * 10000) + (month * 100) + day;
	}
	public static int daysInMonth(int month) {
        if (month == 2) {
            return 29;
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        else {
            return 31;
        }
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
        else if (day < 1 || day > daysInMonth(month)) {
        	return false;
        }
        else {
            return true;
        }
	}
	public static boolean nameValid(String name) {
		boolean flag = true;
		for(String event: events) {
			if(name.trim().toLowerCase().equals(event.trim().toLowerCase())) {
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
	public static void addStandardEvent(Scanner scanner) {
		
		System.out.println("Enter the event's name: ");
		String name = scanner.nextLine();
		while(!nameValid(name)) {
			System.err.println("Choose Another Name: ");
			name = scanner.nextLine();
		}
		System.out.println("Enter the event's location: ");
		String location = scanner.nextLine();
		while(!locationValid(location)) {
			System.err.println("Choose Another Location: ");
			location = scanner.nextLine();
		}
		System.out.println("Enter the event's date in the format (YYYYMMDD):  ");
		int date = scanner.nextInt();
		scanner.nextLine();
		while(!dateValid(date)) {
			System.err.print("Date Invalid,");
			System.out.println(" Please Enter The Date Again: ");
			date = scanner.nextInt();
			scanner.nextLine();
		}
		System.out.println("Enter the duration: ");
		String duration = scanner.nextLine();
		while(duration.trim().isEmpty()) {
			System.err.println("Duration can't be empty, Choose Another Duration: ");
			duration = scanner.nextLine();
		}
		System.out.println("Enter the capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();
		while(capacity<=0) {
			System.out.println("Capacity can't be lower or equal to zero, enter another: ");
			capacity = scanner.nextInt();
			scanner.nextLine();
		}
		
		ids.add(++id);
		events.add(name);
		locations.add(location);
		dates.add(date);
		durations.add(duration);
		capacities.add(capacity);
		participants.add(new ArrayList<String>());
		
		System.out.println("Event " + name + " Has been added successfully.");
		
		
	}
	public static void addOnlineEvent(Scanner scanner) {
		
		System.out.println("Enter the event's name: ");
		String name = scanner.nextLine();
		
		while(!nameValid(name)) {
			System.err.println("Choose Another Name: ");
			name = scanner.nextLine();
		}
		
		
		System.out.println("Enter the event's date in the format (YYYYMMDD):  ");
		int date = scanner.nextInt();
		scanner.nextLine();
		
		while(!dateValid(date)) {
			System.err.print("Date Invalid,");
			System.out.println(" Please Enter The Date Again: ");
			date = scanner.nextInt();
			scanner.nextLine();
		}
		
		
		System.out.println("Enter the duration: ");
		String duration = scanner.nextLine();
		
		while(duration.trim().isEmpty()) {
			System.err.println("Duration can't be empty, Choose Another Duration: ");
			duration = scanner.nextLine();
		}
		
		
		System.out.println("Enter the capacity: ");
		int capacity = scanner.nextInt();
		scanner.nextLine();
		
		while(capacity<=0) {
			System.out.println("Capacity can't be lower or equal to zero, enter another: ");
			capacity = scanner.nextInt();
			scanner.nextLine();
		}
		
		
		ids.add(++id);
		events.add(name);
		locations.add("Online");
		dates.add(date);
		durations.add(duration);
		capacities.add(capacity);
		participants.add(new ArrayList<String>());
		
		System.out.println("Online Event " + name + " Has been added successfully.");
		
		
	}
	public static String formatedDate(int date) {
		int year = date / 10000;
		int month = (date / 100) % 100;
		int day = (date % 100);
		return (day + " / " + month + " / " + year);
	}
	public static void printAllEvents() {
		System.out.println("=======Events=======");
		for(int i = 0 ; i<events.size(); i++) {
			System.out.println("Event ID: " + ids.get(i));
			System.out.println("Event Name: " + events.get(i));
			System.out.println("Event Location: " + locations.get(i));
			System.out.println("Event date: " + formatedDate(dates.get(i)));
			System.out.println("Event duration: " + durations.get(i));
			System.out.println("Capicity: " + participants.get(i).size() + "/" + capacities.get(i));
			System.out.println("====================");
		}
	}
	public static boolean participantNameValid(String name, int ID) {
		
		boolean flag = true;
		for(String participant:participants.get(ID)) {
			if(name.trim().toLowerCase().equals(participant.trim().toLowerCase())) {
				flag = false;
				break;
			}
		}
		if(name.isEmpty()) {
			flag = false;
		}
		return flag;
	}
	
	public static void registerParticipant(Scanner scanner) {
		if(events.isEmpty()) {
			System.out.println("No Events Yet.");
		} else {
			printAllEvents();
			System.out.println("Enter The ID of the event u want to register a participant in: ");
			int searchID = scanner.nextInt();
			searchID--;
			scanner.nextLine();
			boolean found = false;
			for(int i = 0 ; i<ids.size(); i++) {
				if(searchID == i) {
					found = true;
					break;
				}
			}
			
			if(found && participants.get(searchID).size() < capacities.get(searchID)) {
				System.out.println("Enter the name of the participant you want to add: ");
				String name = scanner.nextLine();
				while(!participantNameValid(name,searchID)) {
					System.err.println("Name Either duplicated or empty, please choose another name: ");
					name = scanner.nextLine();
				}
				participants.get(searchID).add(name);
			} else if (!found) {
				System.err.println("Event id not found");
			} else if(participants.get(searchID).size() >= capacities.get(searchID)) {
				System.err.println("This event is full.");
			}
		}
		
	}
	
	public static void printRegistrationReport() {
	    System.out.println("\n===========================================");
	    System.out.println("       EVENT REGISTRATION REPORT");
	    System.out.println("===========================================");

	    if (events.isEmpty()) {
	        System.out.println("No events found in the system.");
	    } else {
	        for (int i = 0; i < events.size(); i++) {
	            
	            System.out.println("ID: " + ids.get(i) + " | Event: " + events.get(i));
	            System.out.println("Location: " + locations.get(i));
	            System.out.println("Capacity: " + participants.get(i).size() + "/" + capacities.get(i));
	            
	            
	            System.out.println("Registered Members:");
	            
	            ArrayList<String> currentParticipants = participants.get(i);
	            
	            if (currentParticipants.isEmpty()) {
	                System.out.println("   -> No members registered yet.");
	            } else {
	                for (int j = 0; j < currentParticipants.size(); j++) {
	                    System.out.println("   " + (j + 1) + ". " + currentParticipants.get(j));
	                }
	            }
	            System.out.println("===========================================");
	        }
	    }
	}
	
	public static void printUpcomingEvents() {
	    
	    ArrayList<Integer> idss = new ArrayList<>(ids);
	    
	    
	    for(int i = 0 ; i < idss.size() - 1 ; i++) {
	        for(int j = 0 ; j < idss.size() - i - 1 ; j++) {
	            
	            
	            int dateA = dates.get(idss.get(j) - 1);
	            int dateB = dates.get(idss.get(j + 1) - 1);
	            
	            if(dateA > dateB) {
	                
	                int temp = idss.get(j);
	                idss.set(j, idss.get(j + 1));
	                idss.set(j + 1, temp);
	            }
	        }
	    }
	    
	    
	    System.out.println("\n--- UPCOMING EVENTS ---");
	    for(int id : idss) {
	        int index = id - 1;
	        System.out.println("Event ID: " + ids.get(index));
	        System.out.println("Event Name: " + events.get(index));
	        System.out.println("Date: " + formatedDate(dates.get(index)));
	        System.out.println("Capicity: " + participants.get(index).size() + "/" + capacities.get(index));
	        System.out.println("--------------------");
	    }
	}
	
	
	
	
	

}
