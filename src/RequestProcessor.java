import java.net.Socket;

public class RequestProcessor {
    private HttpContext context;

    public RequestProcessor(Socket socket) {
        this.context = new HttpContext(socket);
    }

    private void process() {
        HttpRequest request = context.getRequest();
        HttpResponse response = context.getResponse();
        if (request.getUrl().equals("/")) {
            response.ok("c est bon !")
        } else {
            response.notFound("c est pas trouvé !")
        }

    }
}
