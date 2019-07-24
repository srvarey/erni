
package test;

import static org.junit.Assert.assertTrue;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Account;
import model.Client;
import model.Transaction;
import model.TransactionType;


public class AllTests
{

	/*
	 
	ConcurrentHashMap
	
	Uuse ConcurrentHashMap when you need very high concurrency.
	It is thread safe without synchronizing the whole map.
	
	
	*/

	static Map<String, Account>	clientAccounts	= new ConcurrentHashMap<String, Account>();//Key is clientId , Value is Client object

	static Map<String, Client>	clients			= new ConcurrentHashMap<String, Client>();//Key is clientId , Value is Client object

	static Client				johnSmith;
	static Client				aliceSmith;




	private static void showall()
	{
		clientAccounts.forEach((k, v) -> {
			System.out.println(v);

			Client c = clients.get(v.getClientId());
			if (c != null)
			{
				System.out.println(c.toString());
			}
			else
			{
				//Should not happen
				//Throw exception or log
			}

		});
	}




	@BeforeClass
	public static void oneTimeSetUp()
	{

		johnSmith = new Client("Jonny", "Smith", "21-12-1957", "HU10NL");
		aliceSmith = new Client("Alice", "Smith", "16-10-1959", "HU10NL");

		clients.put(johnSmith.getClientId(), johnSmith);
		clients.put(aliceSmith.getClientId(), aliceSmith);

		Account johnSmithAccount = new Account(johnSmith);
		Account aliceSmithAccount = new Account(aliceSmith);

		clientAccounts.put(johnSmith.getClientId(), johnSmithAccount);
		clientAccounts.put(aliceSmith.getClientId(), aliceSmithAccount);

		showall();
	}




	@AfterClass
	public static void oneTimeTearDown()
	{
		// one-time cleanup code
	}




	@Before
	public void setUp()
	{

	}




	@After
	public void tearDown()
	{
		
	}




	@Test
	public void ATMCashDeposit()
	{

		Account ac = clientAccounts.get(johnSmith.getClientId());

		Transaction trans = new Transaction(ac.getAccountId(), ac, TransactionType.cashDeposit);
		trans.deposit(100);
		trans.commit();
		showall();
		assertTrue(ac.getBalance() == 100);
	}




	@Test
	public void ATMCashWithdrawal()
	{
		Account ac = clientAccounts.get(johnSmith.getClientId());

		Transaction trans = new Transaction(ac.getAccountId(), ac, TransactionType.cashWithdrawal);
		trans.withdraw(50);
		trans.commit();
		showall();
		assertTrue(ac.getBalance() == 50);
	}
	
	
	@Test
	public void getBalance()
	{
		System.out.println("Testing getBalance");
		Account ac = clientAccounts.get(johnSmith.getClientId());

		showall();
		assertTrue(ac.getBalance() == 50);
	}
}
