import java.util.Iterator;

class SimpleStack<V> implements Iterable<V>{

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

	public Iterator<V> iterator() {
		//return instance of a inner local anonymous class which implements Iterator<V>
		return new Iterator<V>() {

			Node current = top;

			public boolean hasNext() { return current != null; }

			public V next() {
				V val = current.value;
				current = current.below;
				return val;
			}
		};
	}
}

class IterationTest {

	public static void main(String[] args) {
		int[] a = {1, 4, 9, 16, 25, 36, 49};
		System.out.println("All integers in array");
		for(int i : a)
			System.out.println(i);
		SimpleStack<String> b = new SimpleStack<>(); 
		b.push("July");
		b.push("June");
		b.push("May");
		b.push("April");
		b.push("March");
		System.out.println("All strings on stack");
		for(String s : b)
			System.out.println(s);
		System.out.println("Again all strings on stack");
		for(String s : b)
			System.out.println(s);
	}

}


