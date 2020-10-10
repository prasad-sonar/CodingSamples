class MethodTest {

	private static double income(double invest, int period, boolean risky) {
		float rate = risky ? 9 : 6;
		double amount = invest * Math.pow(1 + rate / 100, period);
		return amount - invest;
	}
	
	//overloading - implementing a method with the name of another method but with different list of parameter types
	private static double income(double invest, int period) {
		return income(invest, period, false);
	}

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.printf("Income in gold scheme  : %.2f%n", income(p, n, true));
		System.out.printf("Income in silver scheme: %.2f%n", income(p, n));
	}
}


