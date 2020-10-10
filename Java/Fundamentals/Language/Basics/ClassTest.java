class Investment {

	private double invest;
	private int period;
	private boolean risky;

	//constructor
	public Investment(double amount, int duration) {
		invest = amount;
		period = duration;
		risky = false;
	}

	public void allowRisk(boolean yes) {
		risky = yes;
	}
	/*
	public static void allowRisk(Investment this, boolean yes) {
		this.risky = yes;
	}
	*/


	public double income() {
		float rate = risky ? 9 : 6; 
		double amount = invest * Math.pow(1 + rate / 100, period);
		return amount - invest;
	}
	/*
	public static double income(Investment this) {
		float rate = this.risky ? 9 : 6;
		double amount = this.invest * Math.pow(1 + rate / 100, this.period);
		return amount - this.invest;
	}
	*/
	

}

class ClassTest {

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		//activation
		Investment i = new Investment(p, n);
		System.out.printf("Income in silver scheme: %.2f%n", i.income()); //binding: Investment.income(i)
		i.allowRisk(true); //Investment.allowRisk(i, true)
		System.out.printf("Income in gold scheme  : %.2f%n", i.income());
	}
}


