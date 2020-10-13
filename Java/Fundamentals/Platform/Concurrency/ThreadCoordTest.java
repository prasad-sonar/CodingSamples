class ThreadCoordTest {

	private static volatile int data;
	private static Object coordinator = new Object();

	private static void produce() {
		System.out.printf("Producer<%x> ready...%n", Thread.currentThread().hashCode());
		int value = Worker.doWork();
		synchronized(coordinator){
			data = value;
			coordinator.notify();
		}
	}

	private static void consume() {
		System.out.printf("Consumer<%x> ready...%n", Thread.currentThread().hashCode());
		//while(data == 0) Thread.yield();
		synchronized(coordinator){
			try{
				coordinator.wait();
			}catch(InterruptedException e){}
			int value = data;
			System.out.printf("Processed value = %d%n", value * value);
		}
	}

	public static void main(String[] args) throws Exception{
		var producer = new Thread(ThreadCoordTest::produce);
		producer.start();
		var consumer = new Thread(ThreadCoordTest::consume);
		consumer.start();
	}
}


