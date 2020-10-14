import java.io.*;

class DataIOTest {

	public static void main(String[] args) throws Exception {
		if(args.length > 2){
			String name = args[0].toUpperCase();
			float price = Float.parseFloat(args[1]);
			short stock = Short.parseShort(args[2]);
			try(var output = new DataOutputStream(new FileOutputStream("item.dat"))){
				output.writeShort(stock);
				output.writeFloat(price);
				output.writeUTF(name);
			}
		}else{
			try(var input = new DataInputStream(new FileInputStream("item.dat"))){
				short stock = input.readShort();
				float price = input.readFloat();
				String name = input.readUTF();
				System.out.printf("%s %s %s%n", name, price, stock);
			}
		}
	}
}


