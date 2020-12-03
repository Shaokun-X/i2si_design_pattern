import java.util.HashSet;
import java.util.Set;

public class WebServer implements WebRequestObservable{
    private Set<WebRequestObserver> observers = new HashSet<>();
    public void getRequest(WebRequest request) {
        AbstractRequestHandler renderHandler = new RenderContentHandler();
        AbstractRequestHandler policyHandler = new PolicyCheckRequestHandler(renderHandler);
        AbstractRequestHandler contentCheckHandler = new ExistingContentCheckRequestHandler(policyHandler);
        contentCheckHandler.handleRequest(request);
        notifyObservers(request);
    }
    
    public void attach(WebRequestObserver observer) {
        observers.add(observer);
    }

    public void detach(WebRequestObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(WebRequest webRequest) {
        for (WebRequestObserver observer : observers) {
            observer.update(webRequest);
        }
    }
}
