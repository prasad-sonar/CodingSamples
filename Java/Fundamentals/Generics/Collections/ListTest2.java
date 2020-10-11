import java.util.*;

class ListTest2 {

	public static void main(String[] args) {
		var store = new LinkedList<Interval>();
		store.add(new Interval(4, 31));
		store.add(new Interval(7, 42));
		store.add(new Interval(5, 23));
		store.add(new Interval(3, 44));
		store.add(new Interval(6, 15));
		store.add(new Interval(3, 91));
		for(Interval i : store)
			System.out.println(i);
		System.out.printf("Third entry = %s%n", store.get(2));
	}
}


