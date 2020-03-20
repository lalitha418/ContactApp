import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashSet;
public  class Contact implements Comparable<Contact>
{
	
   String name;
    Set<String> phoneNumber= new LinkedHashSet<>();
  // String phoneNumber;
   String email;
   String favourites;
   String lastName;
  public Contact(String name,String lastName,Set<String> phoneNumber,String email,String favourites)
  {
	  this.name=name;
	  this.phoneNumber=phoneNumber;
	  this.email=email;
	  this.favourites=favourites;
	  this.lastName=lastName;
  }
  
//public Contact(String name,String lastName,Set<String> phoneNumber,String email,String favourites) {
//	  this.name=name;
//	  this.phoneNumber=phoneNumber;
//	  this.email=email;
//	  this.favourites=favourites;
//	  this.lastName=lastName;
//}

public String getName()
  {
    return name;
  }
  public String getLastName()
  {
    return lastName;
  }
  public Set<String> getPhoneNumber()
  {

    return phoneNumber;
  }
  public String getEmail()
  {
    return email;
  }
  public String getFavourites()
  {
    return favourites;
  }
  public Set setPhoneNumber(Set phoneNumber)
  {
	this.phoneNumber=phoneNumber;
	return phoneNumber;
	  
  }
  public int compareTo(Contact au){
	    
	     int name = this.name.compareTo(au.name);
	     if(name==0)
	     {
	    	 int lastName=this.lastName.compareTo(au.lastName);
	    	 return lastName;
	     }
	     return name;
	  }
 
}



