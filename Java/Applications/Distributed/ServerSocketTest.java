import java.util.*;
import java.io.*;
import java.net.*;

class ServerSocketTest {

	public static void main(String[] args) throws Exception{
		var listener = new ServerSocket(2055);
		for(int i = 0; i < 3; ++i){
			var child = new Thread(() -> {
				try{
					service(listener);
				}catch(IOException e){} 
			});
			child.start();
		}
	}

	private static void service(ServerSocket server) throws IOException{
		String[] items = {"cpu", "hdd", "keyboard", "motherboard", "mouse", "ram"};
		double[] prices = {18000, 4500, 850, 6200, 450, 2400};
		int[] stocks = {25, 38, 150, 25, 120, 65};
		//Arrays.sort(items);
		for(;;){
			Socket client = server.accept();
			client.setSoTimeout(60000);
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(input));
			PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(output), true);
			try{
				writer.println("Welcome to Mundanda Enterprise");
				String item = reader.readLine();
				int i = Arrays.binarySearch(items, item);
				if(i >= 0){
					writer.printf("price=%.2f&stock=%d%n", prices[i], stocks[i]);
				}
			}catch(Exception e){}
			writer.close();
			reader.close();
			client.close();
		}
	}
}


