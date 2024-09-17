package src;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class AzureWebUtil {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class AzureWorkItemData {
        private String op;
        private String path;
        private String value;
    }

    public static void test() {

    }

    public static void main(String[] args) {
        String body = getBody();
        StringBuilder result = new StringBuilder();
        try {

            String link = "https://dev.azure.com/kanwarmohil/TestProject/_apis/wit/workitems/$Issue?api-version=5.0";
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

//            String token = "a2Fud2FyLm1vaGlsQGFybW9yY29kZS5pbzprNzJyaWVpNndoMzdxaWljbHpwaHZzbGRqeWM0cWpwc255a3hyeDZscXFtcjdzY2lhdGJx";
            String token = "" + ":" + "k72riei6wh37qiiclzphvsldjyc4qjpsnykxrx6lqqmr7sciatbq";
            String encoded = Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
            System.out.println("encode-" + encoded);
            System.out.println("encode-" + "a2Fud2FyLm1vaGlsQGFybW9yY29kZS5pbzprNzJyaWVpNndoMzdxaWljbHpwaHZzbGRqeWM0cWpwc255a3hyeDZscXFtcjdzY2lhdGJx");
            System.out.println("encode-" + "Oms3MnJpZWk2d2gzN3FpaWNsenBodnNsZGp5YzRxanBzbnlreHJ4NmxxcW1yN3NjaWF0YnE=");
            connection.setRequestProperty("Content-Type", "application/json-patch+json");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Accept", "application/json-patch+json");
            connection.setRequestProperty("Authorization", "Basic " + encoded);
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            try(OutputStream os = connection.getOutputStream()) {
                os.write(body.getBytes(StandardCharsets.UTF_8));
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
        System.out.println(result.toString());
    }

    /*public static void main(String[] args) {
        String body = getBody();
        StringBuilder result = new StringBuilder();
        try {

            String link = "https://dev.azure.com/kanwarmohil/TestProject/_apis/wit/workitems/$Issue?api-version=5.0";
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
//            String token = "a2Fud2FyLm1vaGlsQGFybW9yY29kZS5pbzprNzJyaWVpNndoMzdxaWljbHpwaHZzbGRqeWM0cWpwc255a3hyeDZscXFtcjdzY2lhdGJx";
            String token = "k72riei6wh37qiiclzphvsldjyc4qjpsnykxrx6lqqmr7sciatbq";
            String encoded = Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
            connection.setRequestProperty("Content-Type", "application/json-patch+json");
//            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Accept", "application/json-patch+json");
            connection.setRequestProperty("Authorization", "Basic " + token);
            connection.setDoOutput(true);

            try(OutputStream os = connection.getOutputStream()) {
                os.write(body.getBytes(StandardCharsets.UTF_8));
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
        System.out.println(result.toString());
    }*/

    public static String getBody() {
        Gson gson = new Gson();
        List<AzureWorkItemData> azureWorkItemData = getAzureData();
        return gson.toJson(azureWorkItemData);
    }

    private static List<AzureWorkItemData> getAzureData() {
        List<AzureWorkItemData> azureWorkItemDataList = new ArrayList<>();
        azureWorkItemDataList.add(new AzureWorkItemData("add", "/fields/System.Title", "Armorcode test creation"));
        azureWorkItemDataList.add(new AzureWorkItemData("add", "/fields/System.AssignedTo", "kanwar.mohil@armorcode.io"));
        azureWorkItemDataList.add(new AzureWorkItemData("add", "/fields/System.Description", "Sample task failed due to error"));
        azureWorkItemDataList.add(new AzureWorkItemData("add", "Microsoft.VSTS.Common.Priority", "2"));
        return azureWorkItemDataList;
    }
}