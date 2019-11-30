import java.io.*;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		
		boolean started = false;
		
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			started = true;
			while (started) {
				boolean connected = false;
				Socket socket = serverSocket.accept();
System.out.println("a client connected");
				connected = true;
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				while (connected) {
					String str = dataInputStream.readUTF();
System.out.println(str);
				}
				dataInputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
