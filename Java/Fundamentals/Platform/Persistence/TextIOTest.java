import java.io.*;

class TextIOTest {

	public static void main(String[] args) throws Exception {
		if(args.length > 2){
			String name = args[0].toUpperCase();
			float price = Float.parseFloat(args[1]);
			short stock = Short.parseShort(args[2]);
			try(var output = new PrintWriter(new FileWriter("item.txt"))){
				output.println(stock);
				output.println(price);
				output.println(name);
			}
		}else{
			try(var input = new BufferedReader(new FileReader("item.txt"))){
				short stock = Short.parseShort(input.readLine());
				float price = Float.parseFloat(input.readLine());
				String name = input.readLine();
				System.out.printf("%s %s %s%n", name, price, stock);
			}
		}
	}
}


