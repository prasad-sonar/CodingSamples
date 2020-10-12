package finance;

@MaxDuration(15)//@MaxDuration(value=15)
public class HomeLoan implements Loan{

	public float interestRate(int period) {
		return period < 10 ? 9.25f : 8.75f;
	}

	public float interestRateForWomen(int period) {
		return interestRate(period) - 0.25f;
	}
}

