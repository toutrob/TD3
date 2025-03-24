import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {
    private String method;
    private String url;

    public HttpRequest(Socket socket) {
        readClientRequest(socket);
    }

    private void readClientRequest(Socket socket) {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = input.readLine();
            if (response != null) {
                String[] parts = response.split(" ");
                this.method = parts[0];
                this.url = parts[1];
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
