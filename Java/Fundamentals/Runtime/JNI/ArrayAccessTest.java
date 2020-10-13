class ArrayHelper {

	public native static int square(double[] values);

	static{
		System.loadLibrary("arrh");
	}
}

class ArrayAccessTest {

	public static void main(String[] args) {
		double[] list = {1.2, 2.3, 3.4, 4.5, 5.6};
		ArrayHelper.square(list);
		for(double i : list)
			System.out.printf("%.3f%n", i);
	}
}

