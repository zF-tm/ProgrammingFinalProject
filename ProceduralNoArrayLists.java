package RegisterationSystemProcedural;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static final int MAX_EVENTS = 100;
    public static final int MAX_PARTICIPANTS_PER_EVENT = 50;

    public static int[] ids = new int[MAX_EVENTS];
    public static String[] events = new String[MAX_EVENTS];
    public static String[] locations = new String[MAX_EVENTS];
    public static int[] dates = new int[MAX_EVENTS];
    public static String[] durations = new String[MAX_EVENTS];
    public static int[] capacities = new int[MAX_EVENTS];
    
    public static String[][] participants = new String[MAX_EVENTS][MAX_PARTICIPANTS_PER_EVENT];
    public static int[] participantCounts = new int[MAX_EVENTS];

    public static Scanner scanner = new Scanner(System.in);
    
    public static int eventCount = 0;
    public static int idCounter = 0;

    public static void main(String[] args) {
        int choice;
        boolean firstRun = true;

        while (true) {
            if (!firstRun) {
                System.out.println("\nPress Enter to continue");
                scanner.nextLine();
            }

            firstRun = false;
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: addStandardEvent(scanner); break;
                case 2: addOnlineEvent(scanner); break;
                case 3: printAllEvents(); break;
                case 4: printUpcomingEvents(); break;
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
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean dateValid(int date) {
        int day = date % 100;
        int month = (date / 100) % 100;

        if (date < 10000000 || date > 99999999 || date < todaysDate()) {
            return false;
        } else if (month < 1 || month > 12) {
            return false;
        } else if (day < 1 || day > daysInMonth(month)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean nameValid(String name) {
        boolean flag = true;
        for (int i = 0; i < eventCount; i++) {
            if (name.trim().toLowerCase().equals(events[i].trim().toLowerCase())) {
                flag = false;
                break;
            }
        }
        if (name.trim().isEmpty()) {
            flag = false;
        }
        return flag;
    }

    public static boolean locationValid(String location) {
        if (location.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static void addStandardEvent(Scanner scanner) {
        if (eventCount >= MAX_EVENTS) {
            System.out.println("System is full, cannot add more events.");
            return;
        }

        System.out.println("Enter the event's name: ");
        String name = scanner.nextLine();
        while (!nameValid(name)) {
            System.err.println("Choose Another Name: ");
            name = scanner.nextLine();
        }
        System.out.println("Enter the event's location: ");
        String location = scanner.nextLine();
        while (!locationValid(location)) {
            System.err.println("Choose Another Location: ");
            location = scanner.nextLine();
        }
        System.out.println("Enter the event's date in the format (YYYYMMDD):  ");
        int date = scanner.nextInt();
        scanner.nextLine();
        while (!dateValid(date)) {
            System.err.print("Date Invalid,");
            System.out.println(" Please Enter The Date Again: ");
            date = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println("Enter the duration: ");
        String duration = scanner.nextLine();
        while (duration.trim().isEmpty()) {
            System.err.println("Duration can't be empty, Choose Another Duration: ");
            duration = scanner.nextLine();
        }
        System.out.println("Enter the capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        while (capacity <= 0 || capacity > MAX_PARTICIPANTS_PER_EVENT) {
            System.out.println("Capacity must be > 0 and <= " + MAX_PARTICIPANTS_PER_EVENT + ": ");
            capacity = scanner.nextInt();
            scanner.nextLine();
        }

        ids[eventCount] = ++idCounter;
        events[eventCount] = name;
        locations[eventCount] = location;
        dates[eventCount] = date;
        durations[eventCount] = duration;
        capacities[eventCount] = capacity;
        participantCounts[eventCount] = 0; 
        
        eventCount++; 

        System.out.println("Event " + name + " Has been added successfully.");
    }

    public static void addOnlineEvent(Scanner scanner) {
        if (eventCount >= MAX_EVENTS) {
            System.out.println("System is full, cannot add more events.");
            return;
        }

        System.out.println("Enter the event's name: ");
        String name = scanner.nextLine();

        while (!nameValid(name)) {
            System.err.println("Choose Another Name: ");
            name = scanner.nextLine();
        }

        System.out.println("Enter the event's date in the format (YYYYMMDD):  ");
        int date = scanner.nextInt();
        scanner.nextLine();

        while (!dateValid(date)) {
            System.err.print("Date Invalid,");
            System.out.println(" Please Enter The Date Again: ");
            date = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Enter the duration: ");
        String duration = scanner.nextLine();

        while (duration.trim().isEmpty()) {
            System.err.println("Duration can't be empty, Choose Another Duration: ");
            duration = scanner.nextLine();
        }

        System.out.println("Enter the capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();

        while (capacity <= 0 || capacity > MAX_PARTICIPANTS_PER_EVENT) {
            System.out.println("Capacity must be > 0 and <= " + MAX_PARTICIPANTS_PER_EVENT + ": ");
            capacity = scanner.nextInt();
            scanner.nextLine();
        }

        ids[eventCount] = ++idCounter;
        events[eventCount] = name;
        locations[eventCount] = "Online";
        dates[eventCount] = date;
        durations[eventCount] = duration;
        capacities[eventCount] = capacity;
        participantCounts[eventCount] = 0;

        eventCount++;

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
        for (int i = 0; i < eventCount; i++) {
            System.out.println("Event ID: " + ids[i]);
            System.out.println("Event Name: " + events[i]);
            System.out.println("Event Location: " + locations[i]);
            System.out.println("Event date: " + formatedDate(dates[i]));
            System.out.println("Event duration: " + durations[i]);
            System.out.println("Capicity: " + participantCounts[i] + "/" + capacities[i]);
            System.out.println("====================");
        }
    }

    public static boolean participantNameValid(String name, int eventIndex) {
        boolean flag = true;
        for (int i = 0; i < participantCounts[eventIndex]; i++) {
            if (name.trim().toLowerCase().equals(participants[eventIndex][i].trim().toLowerCase())) {
                flag = false;
                break;
            }
        }
        if (name.isEmpty()) {
            flag = false;
        }
        return flag;
    }

    public static void registerParticipant(Scanner scanner) {
        if (eventCount == 0) {
            System.out.println("No Events Yet.");
        } else {
            printAllEvents();
            System.out.println("Enter The ID of the event u want to register a participant in: ");
            int searchID = scanner.nextInt();
            searchID--; 
            scanner.nextLine();
            
            boolean found = false;
            if (searchID >= 0 && searchID < eventCount) {
                found = true;
            }

            if (found && participantCounts[searchID] < capacities[searchID]) {
                System.out.println("Enter the name of the participant you want to add: ");
                String name = scanner.nextLine();
                while (!participantNameValid(name, searchID)) {
                    System.err.println("Name Either duplicated or empty, please choose another name: ");
                    name = scanner.nextLine();
                }
                
                int currentCount = participantCounts[searchID];
                participants[searchID][currentCount] = name;
                participantCounts[searchID]++; 
                
            } else if (!found) {
                System.err.println("Event id not found");
            } else if (participantCounts[searchID] >= capacities[searchID]) {
                System.err.println("This event is full.");
            }
        }
    }

    public static void printRegistrationReport() {
        System.out.println("\n===========================================");
        System.out.println("        EVENT REGISTRATION REPORT");
        System.out.println("===========================================");

        if (eventCount == 0) {
            System.out.println("No events found in the system.");
        } else {
            for (int i = 0; i < eventCount; i++) {
                
                System.out.println("ID: " + ids[i] + " | Event: " + events[i]);
                System.out.println("Location: " + locations[i]);
                System.out.println("Capacity: " + participantCounts[i] + "/" + capacities[i]);
                
                System.out.println("Registered Members:");
                
                int count = participantCounts[i];
                
                if (count == 0) {
                    System.out.println("   -> No members registered yet.");
                } else {
                    for (int j = 0; j < count; j++) {
                        System.out.println("   " + (j + 1) + ". " + participants[i][j]);
                    }
                }
                System.out.println("===========================================");
            }
        }
    }

    public static void printUpcomingEvents() {
        int[] sortedIds = new int[eventCount];
        for(int i = 0; i < eventCount; i++) {
            sortedIds[i] = ids[i];
        }
        
        for (int i = 0; i < eventCount - 1; i++) {
            for (int j = 0; j < eventCount - i - 1; j++) {
                
                int indexA = sortedIds[j] - 1;
                int indexB = sortedIds[j + 1] - 1;
                
                int dateA = dates[indexA];
                int dateB = dates[indexB];
                
                if (dateA > dateB) {
                    int temp = sortedIds[j];
                    sortedIds[j] = sortedIds[j + 1];
                    sortedIds[j + 1] = temp;
                }
            }
        }
        
        System.out.println("\n--- UPCOMING EVENTS ---");
        for (int i = 0; i < eventCount; i++) {
            int currentId = sortedIds[i];
            int index = currentId - 1; 
            
            System.out.println("Event ID: " + ids[index]);
            System.out.println("Event Name: " + events[index]);
            System.out.println("Date: " + formatedDate(dates[index]));
            System.out.println("Capicity: " + participantCounts[index] + "/" + capacities[index]);
            System.out.println("--------------------");
        }
    }
}
