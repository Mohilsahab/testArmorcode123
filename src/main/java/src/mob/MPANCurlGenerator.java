package src.mob;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MPANCurlGenerator {
    public static final String VISA_PLACEHOLDER = "[visaMPAN]";
    public static final String MASTER_PLACEHOLDER = "[masterMPAN]";
    public static final String RUPAY_PLACEHOLDER = "[rupayMPAN]";
    public static final String MCC_PLACEHOLDER = "[mcc]";

    public String template = "curl --location --request POST 'http://localhost:8080/api/v1/mpan/insert' \\\n" +
            "--header 'Accept: application/json' \\\n" +
            "--header 'Content-Type: application/json' \\\n" +
            "--header 'clientName: test' \\\n" +
            "--data-raw '{\n" +
            "   \"visaMpan\":\"[visaMPAN]\",\n" +
            "   \"masterMpan\":\"[masterMPAN]\",\n" +
            "   \"rupayMpan\":\"[rupayMPAN]\",\n" +
            "   \"mcc\":\"[mcc]\"\n" +
            "}'";

    private List<Integer> integers = Arrays.asList(5331,5411,5451,5912,5111,5541,5993,5814,5691,8299);

    public void generateMPANCurl(File file) throws IOException {
        File resultFile = new File("/home/kanwarmohil/Desktop/mob/resultCC.sh");
        PrintWriter pw = new PrintWriter(resultFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String str;
        while ((str = br.readLine())!=null){
            String[] splitted = str.split(",");
            System.out.println("Line read::"+str);
            String finalResponse = template.replace(VISA_PLACEHOLDER,splitted[0])
                                            .replace(MASTER_PLACEHOLDER,splitted[1])
                                            .replace(RUPAY_PLACEHOLDER,splitted[2])
                                            .replace(MCC_PLACEHOLDER,
                                                    String.valueOf(integers.get(new Random().nextInt(integers.size()))));
            pw.println(finalResponse);
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        File file  = new File("/home/kanwarmohil/Desktop/mob/InsertMpans_copy.csv");
        MPANCurlGenerator generator = new MPANCurlGenerator();
        generator.generateMPANCurl(file);
    }
}
