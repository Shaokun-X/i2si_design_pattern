import java.util.ArrayList;
import java.util.List;

public class ExistingContentCheckRequestHandler extends AbstractRequestHandler {
    public ExistingContentCheckRequestHandler() {}
    public ExistingContentCheckRequestHandler(AbstractRequestHandler successor) {
        setSuccessor(successor);
    }
    public void handleRequest(WebRequest request) {
        List<String> validValues = new ArrayList<>();
        // validValues.add("/home");
        // validValues.add("/dashboard");
        for (ValidPathEnum value : ValidPathEnum.values()) {
            validValues.add(value.toString());
        }
        String path = request.getPath();
        if (validValues.contains(path)) {
            passToSuccessor(request);
        } else {
            System.out.println("Status 404 : Page missing");
        }
    }
}
