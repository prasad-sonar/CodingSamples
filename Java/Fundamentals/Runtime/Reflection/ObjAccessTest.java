class ObjAccessTest {

	/*
	private static void printAsXml(Interval obj) {
		System.out.println("<Interval>");
		System.out.printf("  <min>%d</min>%n", obj.minutes());
		System.out.printf("  <sec>%d</sec>%n", obj.seconds());
		System.out.println("</Interval>");
		System.out.println();
	}

	private static void printAsXml(payroll.Employee obj) {
		System.out.println("<Employee>");
		System.out.printf("  <id>%d</id>%n", obj.getId());
		System.out.printf("  <hours>%d</hours>%n", obj.getHours());
		System.out.printf("  <rate>%f</rate>%n", obj.getRate());
		System.out.println("</Employee>");
		System.out.println();
	}
	*/

	private static void printAsXml(Object obj) {
		Class<?> c = obj.getClass();
		System.out.printf("<%s>%n", c.getSimpleName());
		for(var f : c.getDeclaredFields()){
			System.out.printf("  <%s>", f.getName());
			try{
				f.setAccessible(true);
				System.out.printf("%s", f.get(obj));
			}catch(Exception e){
				System.out.print(e);
			}
			System.out.printf("</%s>%n", f.getName());
		}
		System.out.printf("</%s>%n", c.getSimpleName());
		System.out.println();
	}

	public static void main(String[] args) {
		printAsXml(new Interval(3, 45));
		printAsXml(new payroll.Employee(52, 58));
	}
}

