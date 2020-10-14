import java.util.stream.IntStream;

class ParallelStreamTest {

	public static void main(String[] args) {
		int first = args.length > 0 ? Integer.parseInt(args[0]) : 1;
		int last = args.length > 1 ? Integer.parseInt(args[1]) : 20;
		long t1 = System.currentTimeMillis();
		long r = IntStream.range(first, last + 1)
					.parallel()
					.mapToLong(value -> Worker.doWork(value) * value)
					.sum();
		long t2 = System.currentTimeMillis();
		System.out.printf("Result = %d, computed in %.3f seconds%n", r, (t2 - t1) / 1000.0);
	}
}


