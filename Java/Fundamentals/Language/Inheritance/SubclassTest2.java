import payroll.*;

class SubclassTest2 {

	private static double averageIncome(Employee[] group) {
		double total = 0;
		for(Employee member : group){
			total += member.income();
		}
		return total / group.length;
	}

	private static double totalSales(Employee[] group) {
		double total = 0;
		for(Employee member : group){
			//if(member.getId() == 103 || member.getId() == 105){
			if(member instanceof SalesPerson){
				SalesPerson sp = (SalesPerson)member; //explicit downcasting
				total += sp.getSales();
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Employee[] dept = new Employee[5];
		dept[0] = new Employee(50, 58);
		dept[1] = new Employee(36, 108);
		dept[2] = new SalesPerson(35, 45, 5500); //implicit upcasting
		dept[3] = new Employee(45, 110);
		dept[4] = new SalesPerson(52, 36, 4500);
		System.out.printf("Average income: %.2f%n", averageIncome(dept));
		System.out.printf("Total sales   : %.2f%n", totalSales(dept));
	}
}


