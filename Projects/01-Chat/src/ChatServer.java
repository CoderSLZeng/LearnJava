import java.io.*;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			while (true) {
				Socket socket = serverSocket.accept();
System.out.println("a client connected");
				DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
				String str = dataInputStream.readUTF();
System.out.println(str);
				dataInputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
