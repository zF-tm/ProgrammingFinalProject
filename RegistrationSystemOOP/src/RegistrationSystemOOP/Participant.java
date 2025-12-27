package RegistrationSystemOOP;

public class Participant {
	private String name;
	private String contactInfo;
	
	
	public Participant(String name, String contactInfo) {
		setName(name);
		setContactInfo(contactInfo);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
            System.out.println("Location cannot be empty.");
        }
        else {
            this.name = name.trim();
        }
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		if (contactInfo == null || contactInfo.trim().isEmpty()) {
            System.out.println("Location cannot be empty.");
        }
        else {
            this.contactInfo = contactInfo.trim();
        }
	}
	
	public void printParticipantInfo() {
		System.out.println("Participant Name: " + name);
		System.out.println("Participant Contact Info: " + contactInfo);
	}
	
	
}
