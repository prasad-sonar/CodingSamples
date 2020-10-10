interface Consumer {

	void apply(int action);

	default void applyAll(int first, int last) {
		for(int action = first; action <= last; ++action){
			apply(action);
		}
	}
}

class Resource implements Consumer, AutoCloseable {

	private String id;

	public Resource(String name) {
		id = name;
		System.out.printf("%s resource acquired%n", id);
	}

	public void apply(int action) {
		if(id != null){
			System.out.printf("%s resource consumed using action<%d>%n", id, action);
		}
	}

	public void close(){
		System.out.printf("%s resource released%n", id);
		id = null;
	}
}

class InterfaceTest2 {

	private static void run(String cmd) {
		/*
		Resource b = new Resource("Second");
		try{
			b.applyAll(1, Integer.parseInt(cmd));
		}finally{
			b.close();
		}
		*/
		try(var b = new Resource("Second")){
			b.applyAll(1, Integer.parseInt(cmd));
		}
	}

	public static void main(String[] args) {
		Resource a = new Resource("First");
		a.apply(1);
		a.close();
		try{
			run(args[0]);
		}catch(Exception e){}
	}
}


