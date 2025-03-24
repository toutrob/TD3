import java.io.IOException;

public class WebServerApplication {
    public static void main(String[] args) throws IOException {
        WebServer server = new WebServer();
        server.run(80);
    }
}
