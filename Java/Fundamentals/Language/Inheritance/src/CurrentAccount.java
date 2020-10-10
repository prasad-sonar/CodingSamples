package banking;

//non-inheritable class
final class CurrentAccount extends Account {

	public void deposit(double amount) {
		if(balance < 0)
			amount *= 0.1;
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		balance -= amount;
	}
}

