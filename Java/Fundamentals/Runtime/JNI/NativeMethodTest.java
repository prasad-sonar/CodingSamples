class NativeMethodTest{

	private native static int gcd(int first, int second);

	public static void main(String[] args) {
		System.loadLibrary("nmt");
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.printf("G.C.D = %d%n", gcd(a, b));
	}
}


