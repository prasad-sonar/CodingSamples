class StringHelper {

	public native static String reverse(String str);

	static{
		System.loadLibrary("strh");
	}
}

class StringAccessTest {

	public static void main(String[] args) {
		System.out.println(StringHelper.reverse(args[0]));
	}
}

