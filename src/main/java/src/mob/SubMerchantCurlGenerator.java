package src.mob;

import java.io.*;

public class SubMerchantCurlGenerator {

    public static void main(String args[]) throws IOException {
        String curl = "curl --location --request POST 'http://localhost:8080/api/v1/submerchant/details/update' \\\n" +
                "--header 'Content-Type: application/json' \\\n" +
                "--header 'clientName: freechargetest' \\\n" +
                "--data-raw '{\n" +
                "  \"entityType\": \"merchant\",\n" +
                "  \"entityId\": \"{entityId}\",\n" +
                "  \"fieldValueMap\": {\n" +
                "    \"MCC\": \"5691\"\n" +
                "  }\n" +
                "}'";

        File file = new File("/home/kanwarmohil/Desktop/mob/mid.txt");

        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        File file1 = new File("/home/kanwarmohil/Desktop/mob/migrate.sh");
        PrintWriter pw = new PrintWriter(file1);
        while ((line=br.readLine())!=null){
            String ncurl = curl.replace("{entityId}",line);
            pw.println(ncurl);
        }
        pw.close();
        br.close();
        fileInputStream.close();
    }
}
