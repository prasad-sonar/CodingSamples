package payroll;

public class SalesPerson extends Employee {

	private double sales;

	public SalesPerson(int h, float r, double s){
		super(h, r); //call super-class (Employee) constructor
		sales = s;
	}

	public double getSales() { return sales; }

	//overriding super-class method
	@Override
	public double income() {
		double amount = super.income();
		if(sales >= 5000)
			amount += 0.05 * sales;
		return amount;
	}
}

