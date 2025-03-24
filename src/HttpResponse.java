import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {
    private BufferedWriter output;

    public HttpResponse(Socket socket) {
        try {
            this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ok(String message) {
        try {
            output.write("HTTP/1.0 200 " + message + "\r\n");
            output.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void notFound(String message) {
        try {
            output.write("HTTP/1.0 404 " + message + "\r\n");
            output.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendContent(String contentType, String content) {
        try {
            output.write("HTTP/1.0 200 OK\r\n");
            output.write(content);
            output.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}