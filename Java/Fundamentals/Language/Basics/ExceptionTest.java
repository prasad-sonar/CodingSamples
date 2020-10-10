enum RiskLevel {
	NONE, LOW, MEDIUM, HIGH;
}

class Investment {

	private double invest;
	private int period;
	private RiskLevel risk;

	public Investment(double amount, int duration) {
		if(amount < 5000)
			throw new IllegalArgumentException("Low amount.");
		invest = amount;
		period = duration;
		risk = RiskLevel.NONE;
	}

	public void allowRisk(boolean yes) {
		risk = yes ? RiskLevel.HIGH : RiskLevel.NONE;
	}

	public void setRiskLevel(RiskLevel level) {
		risk = level;
	}

	public double income() {
		float rate = 0;
		switch(risk) {
			case NONE:
				rate = 6;
				break;
			case LOW:
				rate = 6.5f;
				break;
			case MEDIUM:
				rate = 7.5f;
				break;
			default:
				rate = 9;
		}
		double amount = invest * Math.pow(1 + rate / 100, period);
		return amount - invest;
	}
	

}



class ExceptionTest {

	public static void main(String[] args) {
		try{
			double p = Double.parseDouble(args[0]);
			int n = Integer.parseInt(args[1]);
			Investment i = new Investment(p, n);
			System.out.printf("Income in silver scheme: %.2f%n", i.income());
			i.allowRisk(true);
			System.out.printf("Income in gold scheme  : %.2f%n", i.income());
			i.setRiskLevel(RiskLevel.MEDIUM);
			System.out.printf("Income in platinum scheme: %.2f%n", i.income());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("ERROR: Missing input.");
		}catch(NumberFormatException e){
			System.out.println("ERROR: Invalid input.");
		}catch(Exception e){
			System.out.printf("ERROR: %s%n", e.getMessage());
		}
	}
}


