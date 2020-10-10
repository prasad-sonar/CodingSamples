class SimpleStack<V> {

	private Node top;

	//inner member class
	class Node {
		V value;
		Node below;

		public Node(V val) {
			value = val;
			below = top;
		}
	}

	public void push(V val) {
		top = new Node(val);
	}

	public V pop() {
		V val = top.value;
		top = top.below;
		return val;
	}

	public boolean empty() {
		return top == null;
	}
}


class GenClassTest {

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		SimpleStack<String> b = new SimpleStack<>(); //type inference in initializer from declaration
		b.push("June");
		b.push("May");
		b.push("April");
		b.push("March");
		var c = new SimpleStack<Interval>();
		c.push(new Interval(5, 31));
		c.push(new Interval(7, 42));
		c.push(new Interval(6, 53));
		c.push(new Interval(3, 24));
		c.push(new Interval(4, 15));
		while(!a.empty())
			System.out.println(a.pop());
		System.out.println("--------------------");
		while(!b.empty())
			System.out.println(b.pop());
		System.out.println("--------------------");
		while(!c.empty())
			System.out.println(c.pop());
	}

}


