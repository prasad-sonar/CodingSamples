import payroll.Employee;

class SubclassTest1 {

	private static double tax(Employee e) {
		double i = e.income(); //e.class.income(e)
		return i > 3500 ? 0.10 * (i - 3500) : 0;
	}

	public static void main(String[] args) {
		Employee jack = new Employee();
		jack.setHours(50);
		jack.setRate(58);
		System.out.printf("Jack's ID is %d and income is %.2f with tax of %.2f%n", jack.getId(), jack.income(), tax(jack));
		var jill = new payroll.SalesPerson(50, 58, 8600);
		System.out.printf("Jill's ID is %d and income is %.2f with tax of %.2f%n%n", jill.getId(), jill.income(), tax(jill));
	}
}


