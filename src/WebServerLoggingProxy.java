import java.time.LocalDateTime;

public class WebServerLoggingProxy implements AbstractWebServer {
    private WebServer webServer;
    private FileLogger logger;
    // public WebServerLoggingProxy() {}
    public WebServerLoggingProxy(WebServer webServer, FileLogger logger) {
        this.webServer = webServer;
        this.logger = logger;
    }
    public void getRequest(WebRequest request) {
        String msg;
        String admin = request.getLoggedUser().isAdmin() ? "[ADMIN]" : "[USER]";
        msg = LocalDateTime.now().toString() + " | " + admin + request.getPath();
        logger.log(msg);
        webServer.getRequest(request);
    }
    public void setLogger(FileLogger logger) {
        this.logger = logger;
    }
    public void setWebServer(WebServer webServer) {
        this.webServer = webServer;
    }
    public FileLogger getLogger() {
        return logger;
    }
    public WebServer getWebServer() {
        return webServer;
    }
}
