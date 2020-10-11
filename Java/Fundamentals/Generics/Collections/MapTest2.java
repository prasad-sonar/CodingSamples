import java.util.*;

class MapTest2 {

	public static void main(String[] args) {
		var store = new TreeMap<String, Interval>();
		store.put("monday", new Interval(4, 31));
		store.put("tuesday", new Interval(7, 42));
		store.put("wednesday", new Interval(5, 23));
		store.put("thursday", new Interval(3, 44));
		store.put("friday", new Interval(6, 15));
		store.put("monday", new Interval(2, 21));
		if(args.length > 0){
			Interval val = store.get(args[0]);
			if(val != null)
				System.out.printf("Value = %s%n", val);
			else
				System.out.println("Key not found!");
		}else{
			for(var entry : store.entrySet()){
				System.out.printf("%-16s%s%n", entry.getKey(), entry.getValue());
			}
		}
	}
}


