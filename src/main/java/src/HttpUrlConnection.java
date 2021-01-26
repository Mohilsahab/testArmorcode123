package src;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUrlConnection {
    public static void main(String[] args) {
        String res = HttpUrlConnection.httpConnection();
        System.out.println(res);
    }

    public static String httpConnection() {
        String inputString = "{\n" +
                "  repository(name: \"testing\", owner: \"Mohilsahab\") {\n" +
                "    ref(qualifiedName:\"main\") {      \n" +
                "      target {\n" +
                "        ... on Commit {\n" +
                "          blame(path:\"src/main/java/src/HttpUrlConnection.java\") {\n" +
                "            ranges {\n" +
                "              commit {\n" +
                "                author {\n" +
                "                  name\n" +
                "                }\n" +
                "              }\n" +
                "              startingLine\n" +
                "              endingLine\n" +
                "            \tcommit {\n" +
                "            \t  id\n" +
                "            \t}\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        StringBuilder result = new StringBuilder();
        try {
            String link = "https://api.github.com/graphql";
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            String token = "b028cba72928e1abab632c6940fadaa43db709c5";
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setDoOutput(true);
            String query = "query{repository(name:\"testing\",owner:\"Mohilsahab\"){ref(qualifiedName:\"main\"){target{...onCommit{blame(path:\"src/main/java/src/HttpUrlConnection.java\"){ranges{commit{author{name}}startingLineendingLinecommit{id}}}}}}}}";
            String json = "{\"query\" : \"${body}\"}";
            json = json.replace("${body}", query);
            System.out.println(json);
            try(OutputStream os = connection.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }

            InputStream connectionIn = connection.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connectionIn));
            String inputLine;
            while ((inputLine = buffer.readLine()) != null) {
                result.append(inputLine + "\n");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
        return result.toString();
    }
}
