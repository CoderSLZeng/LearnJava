import java.io.IOException;
import java.net.*;

public class ChatServer {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			while (true) {
				Socket socket = serverSocket.accept();
System.out.println("a client connected");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
