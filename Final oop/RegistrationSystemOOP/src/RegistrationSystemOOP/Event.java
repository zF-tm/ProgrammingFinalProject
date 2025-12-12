package RegistrationSystemOOP;

import java.util.ArrayList;

public class Event {

    private static int nextId = 1;
    private final int id;

    private String name;
    private int date;
    private String duration;
    private String location;
    private int capacity;

    private ArrayList<Participant> participants;

    public Event(String name, int date, String duration, 
    		String location, int capacity) {
        this.id = nextId++;
        this.participants = new ArrayList<>();

        setName(name);
        setDuration(duration);
        setLocation(location);
        setCapacity(capacity);
        setDate(date);
    }

    public int getId() {
        return id;
    }

    public ArrayList<Participant> getParticipants() {
    	return participants;
    }

    public void setParticipants(ArrayList<Participant> participants) {
    	 if(participants.size() > capacity) {
    		 System.out.println("Participants are more than the capacity.");
    	 } else {
    		 this.participants = participants;
    	 }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            System.out.println("Event name cannot be empty.");
        }
        else {
            this.name = name.trim();
        }
    }

    public String getDate() {
        if (date == 0) {
            return "No date set";
        }
        else {
            int day = date % 100;
            int month = (date / 100) % 100;
            int year = date / 10000;
            return day + " / " + month + " / " + year;
        }
    }
    public int getDateAsInteger() {
    	return date;
    }

    public void setDate(int date) {

        int day = date % 100;
        int month = (date / 100) % 100;
        int year = date / 10000;

        if (date < 10000000 || date > 99999999) {
            System.out.println("Wrong syntax, please use YYYYMMDD.");
        }
        else if (year < 2026) {
            System.out.println("Year must be 2026 or later.");
        }
        else if (month < 1 || month > 12) {
            System.out.println("Invalid month.");
        }
        else if (day < 1 || day > daysInMonth(month)) {
            System.out.println("Invalid day for this month.");
        }
        else {
            this.date = date;
        }
    }

    private int daysInMonth(int month) {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        if (duration.trim().isEmpty()) {
            System.out.println("Duration cannot be empty.");
        }
        else {
            this.duration = duration.trim();
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (location.trim().isEmpty()) {
            System.out.println("Location cannot be empty.");
        }
        else {
            this.location = location.trim();
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Capacity must be greater than 0");
        }
        else if (capacity < participants.size()) {
            System.out.println("Capacity cannot be less than the amount of the participants (" + getRegisteredCount() + ").");
        }
        else {
            this.capacity = capacity;
        }
    }

    public boolean isFull() {
        return participants.size() >= capacity;
    }

    public boolean registerParticipant(Participant p) {
        if (isFull()) {
            return false;
        }
        else if (participants.contains(p)) {
            return false;
        } else if(p.getName() == null ||p.getName().trim().isEmpty()) {
        	return false;
        } else if(p.getContactInfo() == null ||p.getContactInfo().trim().isEmpty()) {
        	return false;
        }
        else {
            participants.add(p);
            return true;
        }
    }

    public String getType() {
        return "Standard Event";
    }

    public int getRegisteredCount() {
        return participants.size();
    }

    public void printEventInfo() {
        System.out.println("[ " + getType() + " ] ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Date: " + getDate());
        System.out.println("Duration: " + duration);
        System.out.println("Location: " + location);
        System.out.println("Capacity: " + capacity);
        System.out.println("Participant Count: " + getRegisteredCount());
        System.out.println("================");
    }
}
