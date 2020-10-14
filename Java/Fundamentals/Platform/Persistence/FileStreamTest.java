import java.io.*;

class FileStreamTest {

	public static void main(String[] args) throws Exception {
		try(var source = new FileInputStream(args[0])){
			try(var target = new FileOutputStream(args[1])){
				byte[] buffer = new byte[80];
				while(source.available() > 0){
					int n = source.read(buffer, 0, 80);
					for(int i = 0; i < n; ++i)
						buffer[i] = (byte)(buffer[i] ^ '#');
					target.write(buffer, 0, n);
				}
			}
		}
	}
}

