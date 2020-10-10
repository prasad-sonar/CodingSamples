class AutoBoxTest {

	/*
	private static String select(int selector, String first, String second) {
		if((selector % 2) == 1)
			return first;
		return second;
	}

	private static double select(int selector, double first, double second) {
		if((selector % 2) == 1)
			return first;
		return second;
	}
	*/

	private static Object select(int selector, Object first, Object second) {
		if((selector % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) {
		int s = Integer.parseInt(args[0]);
		String ss = (String)select(s, "Monday", "Friday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = (double)select(s, 23.4, 13.2); //automatic boxing(for arguments) and unboxing(for return value)
		System.out.printf("Selected double = %s%n", sd);
		int si = (int)select(s, 1234, "abcd");
		System.out.printf("Selected int    = %s%n", si);
	}
}


