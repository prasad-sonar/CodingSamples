import finance.*;

class EarlyBindTest {

	/*
	private static float rateFor(String policy, int period) {
		switch(policy){
			case "BusinessLoan":
				return new BusinessLoan().interestRate(period);
			case "HomeLoan":
				return new HomeLoan().interestRate(period);
			case "PersonalLoan":
				return new PersonalLoan().interestRate(period);
			default:
				throw new IllegalArgumentException(policy);
		}
	}
	*/

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName("finance." + args[1]);
		var loan = (Loan)c.getConstructor().newInstance();
		int m = 10;
		for(int n = 1; n <= m; ++n){
			//float r = rateFor(args[1], n);
			float r = loan.interestRate(n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%12.2f%n", n, emi);
		}
	}
}


