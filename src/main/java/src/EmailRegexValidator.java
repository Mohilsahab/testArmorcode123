package src;

import java.io.*;

public class EmailRegexValidator {
    public static void main(String[] args) throws IOException {
        final String REGEX =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        File file  = new File("/home/kanwarmohil/Desktop/mob/emails.txt");

        File resultFile = new File("/home/kanwarmohil/Desktop/mob/emailsResult.txt");
        PrintWriter pw = new PrintWriter(resultFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        String str;
        while ((str = br.readLine())!=null) {
//            String [] arr = str.split("#",2);
            if (!str.matches(EMAIL_PATTERN)) {
                pw.println(str);
            }
        }
        pw.close();
    }
}
