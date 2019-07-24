
package model;


public class Transaction
{

	String			bankid;
	String			transactionId;
	String			accountid;
	TransactionType	transType;
	double			amount;
	Account			account;




	public Transaction(String accountId, Account account, TransactionType transType)
	{
		this.accountid = accountId;
		this.transType = transType;
		this.account = account;
	}




	public void deposit(int amount)
	{
		this.amount = amount;

	}




	public void withdraw(int amount)
	{
		this.amount = amount;

	}




	public void commit()
	{
		switch (transType)
		{
			case cashDeposit:
				doCashDeposit();
				break;

			case balanceEnquiry:
				break;
				
			case cashWithdrawal:
				doCashWithdraw();
				break;
				
			case creditCardWithdrawal:
				break;
				
			case externalTransfer:
				break;
				
			case interest:
				break;
				
			case internalTransfer:
				break;
				
			default:
				break;

		}
	}




	/*
	 * Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors: 
	 * if an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods
	 */
	public synchronized void doCashDeposit()
	{
		account.balance += amount;
	}




	/*
	 * Synchronized methods enable a simple strategy for preventing thread interference and memory consistency errors: 
	 * if an object is visible to more than one thread, all reads or writes to that object's variables are done through synchronized methods
	 */
	public synchronized void doCashWithdraw()
	{
		/*
		 * Simple case just do it
		 * In real life production we need to check if the client has overdraft facility
		 * Also need to send alert message to credit compliance microservice
		 */
		account.balance -= amount;

	}


}
