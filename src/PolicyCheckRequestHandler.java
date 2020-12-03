
public class PolicyCheckRequestHandler extends AbstractRequestHandler {
    public PolicyCheckRequestHandler() {}
    public PolicyCheckRequestHandler(AbstractRequestHandler successor) {
        setSuccessor(successor);
    }
    public void handleRequest(WebRequest request) {
        Boolean isAdmin = request.getLoggedUser().isAdmin();
        String path = request.getPath();
        if (path == ValidPathEnum.DASHBOARD.toString() && !isAdmin) {
            System.out.println("Status 403 : user is not authorized to access this content");
        } else {
            passToSuccessor(request);
        }
    }
}
