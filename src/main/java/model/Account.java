
package model;

import java.util.UUID;

public class Account
{

	private Client	client;

	String			accountId;


	String			clientId;
	double			balance;
	AccountStatus	status;


	/*
	 * For the first iteration of this application clientId is redundant since we can get it via the client object
	 * For the real world application we will have a persistance store (relation db, object db or graph db)
	 * Retrieving uniquely identifiable objects is going to affect how we use and define uniqueness here
	 * 
	 */

	
	/*
	 * Read only setters
	 */

	public Client getClient()
	{
		return client;
	}




	public String getAccountId()
	{
		return accountId;
	}




	public String getClientId()
	{
		return clientId;
	}




	public double getBalance()
	{
		return balance;
	}




	public AccountStatus getStatus()
	{
		return status;
	}




	public Account(Client cli)
	{
		this.client = cli;
		clientId=cli.getClientId();
		accountId = UUID.randomUUID().toString();
		status = AccountStatus.created;
	}




	@Override
	public String toString()
	{
		//StringBuffer methods are synchronized while StringBuilder are not.

		StringBuffer sb = new StringBuffer();
		sb.append("\nAccount");
		sb.append("\n\taccountId : " + accountId);
		sb.append("\n\tclientId  : " + clientId);
		sb.append("\n\tbalance   : " + balance);
		sb.append("\n\tstatus    : " + status);

		return sb.toString();

	}
}
