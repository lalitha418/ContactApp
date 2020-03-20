
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Program {
	static Scanner scanner = new Scanner(System.in);
	static Mobile mobile = new Mobile();
	//Contact obj=new Contact();
	static Validation valid = new Validation();

	public static void main(String[] args) {
		Program obj2=new Program();
		obj2.add();
		boolean entry = true;}
	public void add() {
		int action=0;
		while (true) {
			printActions();
			System.out.println("\nEnter action:");
			try {
			 action = scanner.nextInt();}
			catch(InputMismatchException e)
			{
				System.out.println("enter valid acction");
			}
			scanner.nextLine();
			switch (action) {
			case 1:
				mobile.printContacts();
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				removeContact();
				break;
			case 4:
				queryContact();
				break;
			case 5:
				mobile.printFavourites();
				break;
						}
		}
	}

	private static void printActions() {
		System.out.println("\nAvailable actions:\npress");
		System.out.println("1 - to printcontacts\n" + "2- to add a new contact\n" + "3 - to removecontact\n"
				+ "4 - to querycontact\n" + "5-display favourte contact\n");
		System.out.println("choose your action: ");
	}

	private  void addNewContact() {
		 Set<String> phone1=new LinkedHashSet<>();
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		System.out.println("Enter new contact last name: ");
		String lastName = scanner.nextLine();
		

		System.out.println("Enter phone number: ");
		//String phone=scanner.nextLine();
		
		String phone =null;
	
		boolean result=true;
		
		//String phone;
	     
		 while (result)
		 {
				phone = scanner.nextLine();
				 result = valid.validNum(phone);
			//	 System.out.println(result);
				// Set phone1=new LinkedHashSet<>();
				 
				 
				if (result)
				{
					
				    int resultt=mobile.ifAlreadyExists(name,lastName);
				    if(resultt>0)
					{
				    	mobile.addNumber(phone);
				    	
						
					}
					 phone1.add(phone);
					System.out.println("do yo want to add another num");
				    String resultin=scanner.nextLine();
				    if(resultin.equals("yes"))
				    {
				    	continue;
				    	// phone1.add(phone);
				    }
				    else
				    {
				    	result=false;
				    }
				}

				
               else 
               {
					System.out.println("enter the valid phone");
				}
			}
		 String emaill=null;
		 result=true;
		System.out.println("enter the email");
		
		do {
				emaill = scanner.nextLine();
				result = valid.validEmail(emaill);
				if (result) {
                  
					result=false;
				} else {
					System.out.println("enter the valid email");
					result=true;
				}
			}while(result);
		String email=emaill;;
		
		System.out.println("enter the favourite or not:");
		String favourites = scanner.nextLine();
		//String phone=phone1;
		
	
		Contact newContact = new Contact(name,lastName,phone1, emaill, favourites);
		if (mobile.addNewContact(newContact)) {
			System.out.println("New contact added: " + name +",Lastname: "+ lastName+", number: " + phone1+ ",email: " + emaill
					+ ",favourite: " + favourites);
		} else {
			System.out.println("Cannot add, " + name + " already exists");
		}

	}
//	  public  void addNum(String phone)
//	    {
//	    	obj.phoneNumber.add(phone);
//	    }
//


	private static void removeContact() {
		System.out.println("Enter existing contact first and last name: ");
		String name = scanner.nextLine();
		String lastName=scanner.nextLine();
		Contact existingContactRecord = mobile.queryContact(name,lastName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found.");
			return;
		}

		if (mobile.removeContact(name,lastName)) {
			System.out.println("Successfully removed contact");
		} else {
			System.out.println(" contact with that name is not in the list");
		}
	}

	private static void queryContact() {
		System.out.println("Enter existing contact name: ");
		String name = scanner.nextLine();
		String lastName=scanner.nextLine();
		Contact existingContactRecord = mobile.queryContact(name,lastName);
		if (existingContactRecord == null) {
			System.out.println("Contact not found.");
			return;
		}
		System.out.println("Name: " + existingContactRecord.getName() + " phone number is "
				+ existingContactRecord.getPhoneNumber() + "email:" + existingContactRecord.getEmail() + "favourites:"
				+ existingContactRecord.getFavourites());
	}
	
}