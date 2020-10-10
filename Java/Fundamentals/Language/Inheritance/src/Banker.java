package banking;

public class Banker {

	private static long nid;

	//will execute once when class is loaded
	static {
		nid = System.currentTimeMillis() % 1000000;
	}

	//all members are static so there is no need to activale this class
	private Banker() {}

	public static Account openCurrentAccount() {
		var acc = new CurrentAccount();
		acc.id = 10000000 + nid++;
		return acc;
	}

	public static Account openSavingsAccount() {
		var acc = new SavingsAccount();
		acc.id = 20000000 + nid++;
		return acc;
	}
}


