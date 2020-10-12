import finance.*;

class LateBindTest {
	
	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName("finance." + args[1]);
		var loan = c.getConstructor().newInstance();
		var f = c.getMethod(args[2], int.class); 
		int m = 10;
		for(int n = 1; n <= m; ++n){
			float r = (float)f.invoke(loan, n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%12.2f%n", n, emi);
		}
	}
}


