package finance;

public class CarLoan implements Loan{

	public float interestRate(int period) {
		return 10.75f + 0.25f * period; 
	}
}

