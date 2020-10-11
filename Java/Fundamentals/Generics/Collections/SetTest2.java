import java.util.*;

class SetTest2 {

	public static void main(String[] args) {
		//var store = new TreeSet<Interval>();
		var store = new TreeSet<Interval>((x, y) -> x.seconds() - y.seconds());
		store.add(new Interval(4, 31));
		store.add(new Interval(7, 42));
		store.add(new Interval(5, 23));
		store.add(new Interval(3, 44));
		store.add(new Interval(6, 15));
		store.add(new Interval(3, 91));
		for(Interval i : store)
			System.out.println(i);
	}
}


