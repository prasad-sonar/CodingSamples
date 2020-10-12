import finance.*;

class AnnotationTest {

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName("finance." + args[1]);
		var loan = (Loan)c.getConstructor().newInstance();
		int m = 10;
		if(c.isAnnotationPresent(MaxDuration.class)){
			MaxDuration md = c.getAnnotation(MaxDuration.class);
			m = md.value();
		}
		for(int n = 1; n <= m; ++n){
			float r = loan.interestRate(n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%12.2f%n", n, emi);
		}
	}
}


