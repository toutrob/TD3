import java.net.Socket;

public class HttpContext {
    private Socket socket;
    private HttpRequest request;
    private HttpResponse response;

    public HttpContext(Socket socket) {
        this.socket = socket;
        this.request = new HttpRequest(socket);
        this.response = new HttpResponse(socket);
    }

    public HttpRequest getRequest() {
        return request;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public void close() {
        try {
            if (socket != null) {
                socket.close;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
    }
}
