import java.util.*;

class StreamTest {

	static class Journey {

		private float distance;
		private Interval duration;

		public Journey(float dis, Interval dur) {
			distance = dis;
			duration = dur;
		}

		public double speed() {
			return 3.6 * distance / duration.time();
		}

		public String toString() {
			return String.format("%s\t%.1f", duration, speed());
		}
	}

	public static void main(String[] args) {
		int l = args.length > 0 ? Integer.parseInt(args[0]) : 0;
		var store = new ArrayList<Interval>();
		store.add(new Interval(4, 31));
		store.add(new Interval(7, 42));
		store.add(new Interval(5, 23));
		store.add(new Interval(3, 44));
		store.add(new Interval(6, 15));
		store.add(new Interval(8, 36));
		store.stream()
			 .filter(i -> i.time() > l)
			 .sorted()
			 .map(i -> new Journey(500, i))
			 .forEach(System.out::println);
	}
}


