import banking.*;

class AbstractClassTest {

	public static void main(String[] args) {
		Account jack = Banker.openCurrentAccount();
		jack.deposit(12000);
		Account jill = Banker.openSavingsAccount();
		jill.deposit(7000);
		double payment = Double.parseDouble(args[0]);
		try{
			jill.transfer(payment, jack);
		}catch(InsufficientFundsException e){
			System.out.println("Transfer failed due to lack of funds!");
		}
		System.out.printf("Jack's Account ID is %d and Balance is %.2f%n", jack.getId(), jack.getBalance());
		System.out.printf("Jill's Account ID is %d and Balance is %.2f%n", jill.getId(), jill.getBalance());
	}
}


