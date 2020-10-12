package finance;

public class PersonalLoan implements Loan{

	public float interestRate(int period) {
		return 10 + 0.5f * (period / 3);
	}

	public float interestRateForEmployees(int period) {
		return 0.75f * interestRate(period);
	}
}


