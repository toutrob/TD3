import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    public void run(int portNumber) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber))
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                readRequest(clientSocket);
                sendResponse(clientSocket);
                clientSocket.close();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
