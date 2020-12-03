public class RenderContentHandler extends AbstractRequestHandler {
    public RenderContentHandler() {}
    public RenderContentHandler(AbstractRequestHandler successor) {
        setSuccessor(successor);
    }
    public void handleRequest(WebRequest request) {
        String path = request.getPath();
        if (path == ValidPathEnum.DASHBOARD.toString()) {
            System.out.println("Status 200 : Dashboard content here");
        } else if (path == ValidPathEnum.HOME.toString()) {
            System.out.println("Status 200 : Home content here");
        }
    }
}
