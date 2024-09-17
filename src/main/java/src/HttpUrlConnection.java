package src;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

public class HttpUrlConnection {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        try {

            untrustedPrivateManager();

            String link = "https://git-enterprise.armorcode.ai/api/v3/app/installations/18/access_tokens";
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            String token = "eyJhbGciOiJSUzI1NiJ9.eyJpYXQiOjE2MTI4NzM5MTksImV4cCI6MTYxMjg3NDUxOSwiaXNzIjoiMiJ9.GajXdiTWPyEGQw5_rY6pTcNdbZ-mZzYtTMazbnAPX892jpato-cZhvaxSoWfsoAMhN7_M-1n3fA9h8Sc2zaJxwCgoqj2YJ4TGKSLgqprvC0imT9tabF0Ue6xqpBfvBLbuDJOBwMJbgMmlUIfS4PShcTOlBRoP5uk9gFOmooqjHf8SxSqAgf4ePQaWFwEu7lZwzpzM_NSlr56cSzxJn9lolIuBQ-UFBK9hmfk3UkmbL-qPWJlOT3vxEj-rLA5RPe9dXoMygIOsNafXqVVCLMA6Lc8pfbDgQzZpY7ObzrHkC2Zcgg5WVZ9gQXU5lIY8glsBphK1WQdql5z6lRlHN0fMA";
            connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Accept", "application/vnd.github.machine-man-preview+json");
            connection.setRequestProperty("Authorization", "Bearer " + token);
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

    private static void untrustedPrivateManager() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
