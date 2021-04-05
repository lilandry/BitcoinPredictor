import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebConnection {
    public List<Double> GetFromWeb() {
        List<Double> result = new ArrayList<>();
        String urlString = "https://api.coindesk.com/v1/bpi/historical/close.json";
        int responseCode;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();

                while ((reader.readLine()) != null) {
                    response.append(reader.readLine());
                    JSONObject jsonObject = new JSONObject(reader.readLine());
                    Map<String, Object> jsonMap = jsonObject.toMap();
                    System.out.println(jsonObject.keys().toString());
                    String date = jsonObject.getString(jsonObject.keys().next());
                    Double value = jsonObject.getDouble(jsonObject.keys().next());
                    result.add(value);
                }
            }
        } catch (IOException e) {
            e.getCause();
        }
        return result;
    }
}
