class BoundedTypeTest {
	
	private static <T extends Comparable<T>> T select(T first, T second) {
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args) {
		String ss = select("Monday", "Friday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = select(13.4, 23.2);
		System.out.printf("Selected double = %s%n", sd);
		Interval si = select(new Interval(2, 30), new Interval(3, 20));
		System.out.printf("Selected Interval = %s%n", si);
	}
}


