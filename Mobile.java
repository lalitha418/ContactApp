import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class Mobile {

	private ArrayList<Contact> myContacts;
	// static ArrayList<Numbers> list;

	public Mobile() {
		this.myContacts = new ArrayList<>();
		//this.list=new ArrayList<>();
		Collections.sort(myContacts);
	}
	static Scanner scanner = new Scanner(System.in);
	
	int c=0;  
    public void printFavourites()
	{
		
	  for(int i=0;i<myContacts.size();i++)
	  {

		if(this.myContacts.get(i).getFavourites().equals("yes"))
		{
			System.out.println(myContacts.get(i).getName()+" "+myContacts.get(i).getLastName());
            
			c++;
		}
		
		
	  }	
	  if(c==0)
	  {
		  System.out.println("no favourite contacts");
	  }
	}
  	
	public void printContacts() {
		System.out.println("You have " + myContacts.size() + " contacts in your mobile");
		
		// Collections.sort(myContacts);
		 
	
		
		for (int i = 0; i < this.myContacts.size(); i++) 
		{
		
			System.out.println(
					(i + 1) + "." + this.myContacts.get(i).getName() + "    "+this.myContacts.get(i).getLastName() +"->" + this.myContacts.get(i).getPhoneNumber()+"    "+this.myContacts.get(i).getFavourites()+"    "+this.myContacts.get(i).getEmail());
		}
	}

	public boolean addNewContact(Contact contact) {
		if((findContact(contact.getName()) >= 0)&&(findContact(contact.getLastName())>=0) ){
			System.out.println("contact already exists");
			return false;
		}
		myContacts.add(contact);
		return true;
	}

	int findContact(String string) {
		return this.myContacts.indexOf(string);
	}

	public int findContact(String contactFirstName,String contactLastName) {
		for (int i = 0; i < this.myContacts.size(); i++) {
			Contact contact = this.myContacts.get(i);
			System.out.println(contact);
			if (((contact.getName().equals(contactFirstName)) &&(contact.getLastName().equals(contactLastName)))){
				return i;
			}
		}
		return -1;
	}

	public Contact queryContact(String name,String lastName) {
		int position = findContact(name,lastName);
		if (position >= 0) {
			return this.myContacts.get(position);
		}
		return null;
	}
	public int ifAlreadyExists(String name, String lastName) 
	{
		int position=findContact(name,lastName);
		if(position>0)
		{
			System.out.println("hi");
			return position;
		}
		else{
		return position ;}
	}
   public void addNumber(String name)
   {
	   int index = this.myContacts.indexOf(name );
	   String phone5=scanner.nextLine();
	  
   	
      // this. myContacts.setPhoneNumber(phone5);
   	
   	
	   // this.myContacts.setPhoneNumber(phoneNumbe.add(phone));
   }
	public boolean removeContact(String name,String lastName) {
		int foundPosition1 = findContact(name);
		int foundPosition2 = findContact(name);
		if ((foundPosition1 < 0)&&(foundPosition2<0)) {
			//System.out.println(Contact.getName() + " was not found");
			System.out.println(name+" "+lastName+" " + " was not found");
			return false;
		}
		this.myContacts.remove(foundPosition1);
		System.out.println( name+" "+lastName+" "+ " was deleted.");
		return true;
	}



	
	}