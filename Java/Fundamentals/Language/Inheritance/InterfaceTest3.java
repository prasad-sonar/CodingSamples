//functional interface
//1. Contains exactly one abstract method
//2. Supports implicit conversion from a method reference whose
//   signature is compatible with its own abstract method

@FunctionalInterface
interface Sequence {

	int term(int position);

	default boolean skip(int position) {
		return false;
	}
}

class Series {

	public static long sum(int count, Sequence next) {
		long total = 0;
		for(int i = 1; i <= count; ++i){
			total += next.term(i);
		}
		return total;
	}
}



class InterfaceTest3 {

	//nested member class
	static class OddSequence implements Sequence {
		public int term(int p) {
			return 2 * p - 1;
		}
	}

	private static int fibo(int p) {
		if(p > 1)
			return fibo(p - 1) + fibo(p - 2);
		return p;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		long a = Series.sum(n, new OddSequence());
		System.out.printf("Sum of odd numbers = %d%n", a);
		long b = Series.sum(n, InterfaceTest3::fibo); //passing method reference
		System.out.printf("Sum of fibonacci numbers = %d%n", b);
		long c = Series.sum(n, p -> p * p); //passing lambda expression (closure)
		System.out.printf("Sum of squares of numbers = %d%n", c);
	}
}


