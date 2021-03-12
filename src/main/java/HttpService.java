import kong.unirest.HttpRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.IOException;

public class HttpService {
    public String connect(String url) throws IOException {
        String responseJSONString = "";
        Unirest.config().defaultBaseUrl(Config.APP_URL);
        HttpRequest request = Unirest.get(url);
        HttpResponse<JsonNode> jsonResponse = request.asJson();
        try {
            responseJSONString = jsonResponse.getBody().toString();
        }catch (NullPointerException e){
            System.out.println("Pokemon of this type not found!!!!");
            MainApp mainApp= new MainApp();
            mainApp.run();
        }
        return responseJSONString;
    }
}
