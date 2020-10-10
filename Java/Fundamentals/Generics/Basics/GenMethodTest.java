class GenMethodTest {
	
	private static <T> T select(int selector, T first, T second) {
		if((selector % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) {
		int s = Integer.parseInt(args[0]);
		String ss = select(s, "Monday", "Friday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = select(s, 23.4, 13.2);
		System.out.printf("Selected double = %s%n", sd);
		int si = select(s, 1234, 0xabcd);
		System.out.printf("Selected int    = %s%n", si);
	}
}


