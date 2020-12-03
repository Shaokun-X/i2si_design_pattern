
public class WebServer implements AbstractWebServer{
    public void getRequest(WebRequest request) {
        AbstractRequestHandler renderHandler = new RenderContentHandler();
        AbstractRequestHandler policyHandler = new PolicyCheckRequestHandler(renderHandler);
        AbstractRequestHandler contentCheckHandler = new ExistingContentCheckRequestHandler(policyHandler);
        contentCheckHandler.handleRequest(request);
    }
    
}
