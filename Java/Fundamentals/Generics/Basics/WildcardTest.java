class SimpleStack<V> {

	private Node top;

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

	public void copy(SimpleStack<? super V> that) {
		for(Node n = top; n != null; n = n.below)
			that.push(n.value);
	}
}


class WildcardTest {

	private static void printStack(SimpleStack<? extends Object> store) {
		for(int count = 0; !store.empty(); ++count){
			if(count > 0)
				System.out.print(", ");
			System.out.print(store.pop());
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		SimpleStack<String> b = new SimpleStack<>(); 
		b.push("June");
		b.push("May");
		b.push("April");
		b.push("March");
		a.copy(b);
		var c = new SimpleStack<Interval>();
		c.push(new Interval(5, 31));
		c.push(new Interval(7, 42));
		c.push(new Interval(6, 53));
		c.push(new Interval(3, 24));
		c.push(new Interval(4, 15));
		var d = new SimpleStack<Object>();
		d.push("Sunday");
		d.push(new Interval(2, 30));
		d.push(12.34);
		c.copy(d);
		printStack(a);
		printStack(b);
		printStack(c);
		printStack(d);
	}

}


