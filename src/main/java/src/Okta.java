package src;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Okta {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try {
            String link = "https://armorcodemohil.okta.com/api/v1/users";
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            String token = "00t6VyO4_OWHIdWzfX1SY_STjWCdwaUJ80v6wjdxHa";
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "SSWS " + token);
            connection.setDoOutput(true);

            InputStream connectionIn = connection.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connectionIn));
            String inputLine;
            while ((inputLine = buffer.readLine()) != null) {
                result.append(inputLine + "\n");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println(result.toString());
    }
}
