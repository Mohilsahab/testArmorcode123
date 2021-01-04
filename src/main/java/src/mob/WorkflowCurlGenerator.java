package src.mob;

import java.io.*;

public class WorkflowCurlGenerator {
    public static final String WF_ID = "[WF_ID]";

    public String template = "curl --location --request POST 'http://localhost:8080/adminWorkFlowExplorer/restartBlocked' \\\n" +
            "--header 'Accept: application/json' \\\n" +
            "--header 'Content-Type: application/json' \\\n" +
            "--header 'clientName: test' \\\n" +
            "--data-raw '{\n" +
            "   \"workFlowId\":\"[WF_ID]\"\n" +
            "}'";


    public void generateWFCurl(File file) throws IOException {
        File resultFile = new File("/home/kanwarmohil/Desktop/mob/KPWF.sh");
        PrintWriter pw = new PrintWriter(resultFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String str;
        while ((str = br.readLine())!=null){
//            String[] splitted = str.split(",");
//            System.out.println("Line read::"+str);
            String finalResponse = template.replace(WF_ID, str);
            pw.println(finalResponse);
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        File file  = new File("/home/kanwarmohil/Desktop/mob/KPWFblocked.txt");
        WorkflowCurlGenerator generator = new WorkflowCurlGenerator();
        generator.generateWFCurl(file);
    }
}
