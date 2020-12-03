public abstract class AbstractRequestHandler {
    private AbstractRequestHandler successor;
    public abstract void handleRequest(WebRequest request);
    public AbstractRequestHandler getSuccessor() {
        return successor;
    }
    public void setSuccessor(AbstractRequestHandler successor) {
        this.successor = successor;
    }
    protected void passToSuccessor(WebRequest request) {
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
