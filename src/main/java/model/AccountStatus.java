
package model;


public enum AccountStatus
{
	inCredit,//in good standing
	created,
	debitsAreFrozen,//only credits allowed
	locked//No transactions at all are possible
}
