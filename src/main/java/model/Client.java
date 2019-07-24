
package model;

import java.util.UUID;

public class Client
{

	String	firstname;
	String	lastname;
	String	birthdate;
	String	address; 	//Time does not permit for this exercise but obviously we can decompose this into address object
	String	clientId;




	
	public String getFirstname()
	{
		return firstname;
	}




	
	public String getLastname()
	{
		return lastname;
	}




	
	public String getBirthdate()
	{
		return birthdate;
	}




	
	public String getAddress()
	{
		return address;
	}




	
	public String getClientId()
	{
		return clientId;
	}




	public Client(String firstname, String lastname, String birthdate, String address)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = address;
		clientId = UUID.randomUUID().toString();

	}




	@Override
	public String toString()
	{
		//StringBuffer methods are synchronized while StringBuilder are not.

		StringBuffer sb = new StringBuffer();
		sb.append("\n\tClient");
		sb.append("\n\t\tfirstname : " + firstname);
		sb.append("\n\t\tlastname  : " + lastname);
		sb.append("\n\t\tbirthdate : " + birthdate);
		sb.append("\n\t\taddress   : " + address);

		return sb.toString();

	}
}
