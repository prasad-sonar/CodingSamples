class Mean {

	public double average;

	public double deviation;
}

class VarArgsTest {

	private static double average(double first, double second, double... remaining) {
		double total = first + second;
		for(double value : remaining){
			total += value;
		}
		return total / (2 + remaining.length);
	}

	private static Mean averageWithDeviation(double first, double second) {
		Mean result = new Mean();
		result.average = (first + second) / 2;
		result.deviation = first > second ? (first - second) / 2 : (second - first) / 2;
		return result;
	}

	public static void main(String[] args) {
		System.out.printf("Average of two values is %f%n", average(23.8, 28.3));
		System.out.printf("Average of three values is %f%n", average(23.8, 28.3, 31.6));
		System.out.printf("Average of five values is %f%n", average(23.8, 28.3, 31.6, 19.8, 34.7));
		if(args.length > 1){
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			Mean z = averageWithDeviation(x, y);
			System.out.printf("Average of given values is %f with a deviation of %f%n", z.average, z.deviation);
		}
	}
}


