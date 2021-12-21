import com.google.gson.Gson;
import org.json.JSONML;
import org.json.JSONArray;
import org.json.CDL;
import org.json.JSONObject;
import org.json.HTTPTokener;
import org.json.HTTP;
import org.json.JSONString;
import org.json.CookieList;
import org.json.XML;
import org.json.XMLTokener;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Constructor {
    private static JSONObject gson = new JSONObject();
    public static void CreateDatabase(String groupId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create())
                .setHeader("User-Agent", "java")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //Root empObject = gson.fromJson(response.body(), Root.class);
        Root empObject = gson

        String ids = "";

        for (int i = 0; i < empObject.response.items.size(); i++){
            ids += empObject.response.items.get(i) + ",";
        }

        StringBuilder url = new StringBuilder("");
        url.append(ids);

        request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url.toString()))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        FillDatabase(response);
    }

    public static void FillDatabase(HttpResponse<String> response) {
        UserData userInfo = gson.fromJson(response.body(), UserData.class);
        for (int i=0; i < userInfo.response.size(); i++){
            var currentUser = new UserInfo(
                    userInfo.response.get(i).id,
                    userInfo.response.get(i).first_name,
                    userInfo.response.get(i).last_name,
                    userInfo.response.get(i).can_invite_to_chats);
            userInfo.allUsers.add(currentUser);
        }
    }
}
