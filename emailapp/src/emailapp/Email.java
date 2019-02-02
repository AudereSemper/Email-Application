package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLenght = 8;
	private String department;
	private String email;
	private int defaultMailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = "company.com";
	
	//Constructor to receive the first and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email created: " + this.firstName + this.lastName);
		
		this.department=setDepartment();
		System.out.println(this.department);
		
		this.password=randomPassword(defaultPasswordLenght);
		System.out.println("Your password is: " + this.password);
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("Your Email is:" + email);
	}
	
	//ask for the department
	private String setDepartment () {
		System.out.println("DEPARTMENT CODE\nEnter the department\n1 Sales\n2 Accounting\n3 Development\n0 None\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if(depChoice == 1) {return "sales";}
		else if(depChoice == 2) {return "accounting";}
		else if(depChoice == 3) {return "development";}
		else { return ""; }
	}
	
	//generate random password
	private String randomPassword(int lenght) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@ù#$%&!£";
		char[] password = new char[lenght];
		
		for(int i = 0; i<lenght; i++) {
			int rand =(int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
			
		}
		
		return new String(password);
	}
	
	public void setMailboxCapacity(int capacity) {
		this.defaultMailboxCapacity = capacity;
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return defaultMailboxCapacity; }
	public String getAlternateEmail() {return alternateEmail; }
	public String getPassword () { return password; }
	
	public String showInfo() {
		return "Display name: " + firstName + " " + lastName + "\n" +
			   "Company email: " + email + "\n" +
			   "Mailbox capacity: " + defaultMailboxCapacity + "mb\n";
	}
	
}
