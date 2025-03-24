import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private void readRequest(Socket socket) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = "";
            while((response = input.readLine()).isEmpty() == false)
                System.out.println(response);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void sendResponse(Socket socket) {
        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.write("HTTP/1.0 200 OK\n");
            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void run(int portNumber) throws IOException {
        ServerSocket serverSocket = new ServerSocket(portNumber);
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
