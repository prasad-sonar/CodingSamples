class LegacyTaxPayer {

	private double income;

	public LegacyTaxPayer(double income) {
		this.income = income;
	}

	public boolean validate(short age) {
		return age > 17 && age < 100;
	}

	public native double getIncomeTax(short age);

	static{
		System.loadLibrary("ltaxp");
	}
}

class ObjectAccessTest {

	public static void main(String[] args) {
		try{
			double i = Double.parseDouble(args[0]);
			short a = Short.parseShort(args[1]);
			var t = new LegacyTaxPayer(i);
			System.out.printf("Income Tax: %.2f%n", t.getIncomeTax(a));
		}catch(Exception e){
			System.out.println(e);			
		}
	}
}

