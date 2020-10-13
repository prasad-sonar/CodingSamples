class ThreadTest {

	private static ThreadLocal<String> client = new ThreadLocal<>();

	private static void handleJob(int id) {
		System.out.printf("Thread<%x> has accepted job<%d> for client<%s>%n", Thread.currentThread().hashCode(), id, client.get());
		Worker.doWork(id);
		System.out.printf("Thread<%x> has finished job<%d> for client<%s> %n", Thread.currentThread().hashCode(), id, client.get());
	}

	public static void main(String[] args) throws Exception {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 50;
		Thread child = new Thread(() -> {
			client.set("Jack");
			handleJob(n);
		});
		child.setDaemon(n > 75);
		child.start();
		client.set("Jill");
		handleJob(60);
	}
}

