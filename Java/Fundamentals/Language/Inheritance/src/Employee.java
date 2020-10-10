package payroll;

public class Employee {

	private int id;
	private int hours;	//instance field - each instance will have its own separate value
	private float rate;
	static int count;	//static field - all instances will share the same value

	//parameterized constructor
	public Employee(int h, float r) {
		id = 101 + count++;
		hours = h;
		rate = r;
	}

	//parameterless (zero-argument) constructor
	public Employee() {
		this(0, 0); //call above constructor with h=0 and r=0
	}

	public int getId() { return id; }
	
	public int getHours() { return hours; }
	public void setHours(int value) { hours = value; }

	public float getRate() { return rate; }
	public void setRate(float value) { rate = value; }

	//instance method - must be called on an object which is refered by hidden 'this' argument
	public double income() {
		int ot = hours > 40 ? hours - 40 : 0;
		return (hours + ot) * rate;
	}

	//static method - can be called on a class and it does not receive 'this' argument
	public static int active() {
		return count;
	}

}

