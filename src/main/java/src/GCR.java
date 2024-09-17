//package src;
//
//import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.gax.core.CredentialsProvider;
//import com.google.api.gax.core.FixedCredentialsProvider;
//import com.google.api.gax.core.GoogleCredentialsProvider;
//import com.google.api.gax.paging.Page;
//import com.google.api.services.cloudresourcemanager.v3.CloudResourceManager;
//import com.google.api.services.cloudresourcemanager.v3.model.ListProjectsResponse;
//import com.google.api.services.cloudresourcemanager.v3.model.Project;
//import com.google.api.services.compute.Compute;
//import com.google.api.services.compute.model.Image;
//import com.google.api.services.compute.model.ImageList;
//import com.google.auth.oauth2.AccessToken;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.devtools.containeranalysis.v1.ContainerAnalysisSettings;
//import com.google.cloud.storage.Bucket;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import com.google.common.collect.Lists;
//
//import java.io.ByteArrayInputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import com.google.gson.Gson;
//import io.grafeas.v1.GrafeasClient;
//import io.grafeas.v1.GrafeasSettings;
//import io.grafeas.v1.Occurrence;
//import io.grafeas.v1.ProjectName;
//import com.google.cloud.devtools.containeranalysis.v1.ContainerAnalysisClient;
//import org.apache.commons.io.IOUtils;
//
//import java.security.GeneralSecurityException;
//import java.util.*;
//
//public class GCR {
//
//    public static final String OAUTH_URL = "";
//
//    private String getJson() {
//        return GsonUtil.getGson().toJson(getMap());
//    }
//
//    private static Map<String, Object> getMap() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("type", "service_account");
//        map.put("project_id", "fluted-harmony-326907");
//        map.put("private_key_id", "1908a6decdb652151ae2192da79d80b9c823720b");
//        map.put("private_key", "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDAx1hBuWNOBzmK\nojjqzXDyDejSSzXRbU5BKrWd7Vml+gp5qlECHSNzu7tGz9yTqmQgFYXKQ7TK8sGL\nl0t0ExmQStSaPUZFqAMR0Hc1vwPLyXOSwGEYzD+/F5To3qBBZWnAXPUIcw34YVuh\n6Ibv0upBJ6gfxJW8ToVAWnNHuWIAKv8maQruOskFQDIzUWMPdStBTX2nLkczIOYZ\neP/NHJnaLJ4s/MygZ2TSoi5deVU6wizGQP7iCNvixHFEv40hnLB8PFRwWOgPsuWu\nu8jFlN4LfmBOo3JmwnLArjjpbd4nDqxyIezpGUVahlAXOihyAw60sXzUkP0e6bA2\ntCW5vpcHAgMBAAECggEAQTBHwnXfxEeCKESiDZhqHJgihlZDfS3CvBumraBQ4+Tx\nPOIgoZ/b2Kt/cTsiAlcoo4bTpqmNjeFYHI2NSNOaneYIDZ4x0KU3YINHhIeyz2sw\nZ0whqWKMHeDqDHMX6vVRtOhaPcC2VSsK8u2wD5IZf+3alt+BqNs+iRvtBrCEGLzb\nKiz3ZWn8ZTFZxMDZkqmEM++4pElJOlzXtXqKtpQuMZHC0h+FynfIkzVkqHlNZRiM\nNhYdeNeDfrS4pJo7cbcbhWxzeK6ZWJ36WH0sQm97oEvCDrj2D/wCXK7OVazoUwJI\nurK4i+GiEVnBfi9WZ4m/bzMhjZBlUnlt4rXfrnBj2QKBgQDf+Z1IYSfcIiyDiXuM\n7eceJn96iMK9L+mGC0mlZMuWCr4lEu49yTn+q0loWQeaaDqrJM7aRd+4n48f52V5\nSezHb0KoBEK2PF7tS9ivV1NfQTxoZr2Mv4aY6QTD94ZVompssJ8hM08Lh3lMwI4e\n8zN6bAJR+n/L2edt5E/PB9rnvwKBgQDcV9F3MiE78aEHFWtfmym3QoIihBGjjqAk\nLJX2pw3itlAssISO5f3J7LYeEhlCAvLIPmqTeIqm9B+u+Yw73orbIXTfRsS//+nO\nWEDw/kE9jKSaZWrIchzzyPdmmphLmhdzNmnQCnAPi768VO962LWK1dlxdWDnxLnN\nshUFZapiuQKBgHtFQQGjJ3MLBADpXCy2i2uWuLbSKoxBoH98Gu6CyWItS3XQM3ui\nEt9NmrtptLuQ/ilPuuF7b6SHfRiMHNdijoU9gSxEHAt8sqpcAkiPAX39w6eaVFzw\n1L24Ej1hMHhVScnEc/Cr8qdfyq0plY8HP5/zblt8SXYC2lMrQ5mosxy1AoGAf3wX\n510LuYD95/lOnIxLwIosfQfopLb6lLNvOLxC3m8ZSCIBMCSFh/T7Eb7q+jR2f8EN\nLLHLlvkb88LSjjkeIdbjpeNuJqBMiGSrfkO9P31GJ0aSV9MeSTZ3XdgIUYWgF7rd\n0c6YM4ZpHtINlQgZUXCVVH3TSYWa8xYb73l48ZECgYBirQSbG46hhHbJyrzCrq/C\nplq0pHLil6u9+0IzD+41a684qkzaRAUz5hyjiZyM5YtqL1flQPmsiA7/1vu93ma6\nb1MoZdDIOJnBIeIln5aGZZjF2CpoFO0p2/OS2Vp5Lq0XbRSs7FMn5DpdttXJEwrh\naG1xe73T/dt59Hw4M+O+RQ==\n-----END PRIVATE KEY-----\n");
//        map.put("client_email", "kanwartest@fluted-harmony-326907.iam.gserviceaccount.com");
//        map.put("client_id", "110805944207656655755");
//        map.put("auth_uri", "https://accounts.google.com/o/oauth2/auth");
//        map.put("token_uri", "https://oauth2.googleapis.com/token");
//        map.put("auth_provider_x509_cert_url", "https://www.googleapis.com/oauth2/v1/certs");
//        map.put("client_x509_cert_url", "https://www.googleapis.com/robot/v1/metadata/x509/kanwartest%40fluted-harmony-326907.iam.gserviceaccount.com");
//        return map;
//    }
//
//
//    public static void main(String[] args) throws IOException, InterruptedException, GeneralSecurityException {
//        getAccessToken(getMap());
////        getAccessToken("C:\\Users\\Kanwar\\Downloads\\fluted-harmony-326907-1908a6decdb6.json");
////        getOccurrencesForImage("https://gcr.io/projects/fluted-harmony-326907/global/images@sha256:e24bcaf41034c28b6a08aba94507a169ae23f2b87899e225a3d18fe8c36d26f5", "fluted-harmony-326907");
////        getOccurrencesForImage("https://www.googleapis.com/compute/beta/fluted-harmony-326907/global/images@sha256:e24bcaf41034c28b6a08aba94507a169ae23f2b87899e225a3d18fe8c36d26f5", "fluted-harmony-326907");
////        getOccurrencesForImage("https://gcr.io/projects/fluted-harmony-326907/global/images", "fluted-harmony-326907");
//
//        /**
//         * working great
//         */
////        findVulnerabilityOccurrencesForImage(
////                "https://gcr.io/fluted-harmony-326907/webgoat-8.0@sha256:e24bcaf41034c28b6a08aba94507a169ae23f2b87899e225a3d18fe8c36d26f5",
////                "fluted-harmony-326907");
//
////        getImagesList();
//
////        getCloudProjects();
//    }
//
//    private static void getAccessToken(Map<String, Object> map) throws IOException {
//        // You can specify a credential file by providing a path to GoogleCredentials.
//        // Otherwise credentials are read from the GOOGLE_APPLICATION_CREDENTIALS environment variable.
//        GoogleCredentials credentials = GoogleCredentials.fromStream(IOUtils.toInputStream(GsonUtil.getGson().toJson(map)))
//                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
////                .createScoped(Lists.newArrayList("https://accounts.google.com/o/oauth2/v2/auth"));
////                .createScoped(Lists.newArrayList("https://oauth2.googleapis.com/token"));
//        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//
//        Page<Bucket> buckets = storage.list();
//        AccessToken accessToken = credentials.getAccessToken();
//        System.out.println("token - " + accessToken.getTokenValue());
//        System.out.println("expiry time - " + accessToken.getExpirationTime());
//        System.out.println("Buckets:");
//        for (Bucket bucket : buckets.iterateAll()) {
//            System.out.println(bucket.toString());
//        }
//    }
//
//    // Retrieve a list of vulnerability occurrences associated with a resource
//    public static List<Occurrence> findVulnerabilityOccurrencesForImage(String resourceUrl,
//                                                                        String projectId) throws IOException {
//        // String resourceUrl = "https://gcr.io/project/image@sha256:123";
//        // String projectId = "my-project-id";
//        final String projectName = ProjectName.format(projectId);
//        String filterStr = String.format("kind=\"VULNERABILITY\" AND resourceUrl=\"%s\"", resourceUrl);
//
//        // Initialize client that will be used to send requests. After completing all of your requests,
//        // call the "close" method on the client to safely clean up any remaining background resources.
//
//        GoogleCredentials googleCredentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\Kanwar\\Downloads\\fluted-harmony-326907-29e801c6fcd0.json"))
//                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//
//        CredentialsProvider credentials = FixedCredentialsProvider.create(googleCredentials);
//        ContainerAnalysisSettings containerAnalysisSettings =
//                ContainerAnalysisSettings.newBuilder()
//                        .setCredentialsProvider(credentials)
//                        .build();
//
//        GrafeasClient client = ContainerAnalysisClient.create(containerAnalysisSettings).getGrafeasClient();
//        LinkedList<Occurrence> vulnerabilities = new LinkedList<>();
//        for (Occurrence o : client.listOccurrences(projectName, filterStr).iterateAll()) {
//            vulnerabilities.add(o);
//        }
//        return vulnerabilities;
//    }
//
//
//    // Retrieves all the Occurrences associated with a specified image
//    // Here, all Occurrences are simply printed and counted
//    public static int getOccurrencesForImage(String resourceUrl, String projectId)
//            throws IOException, InterruptedException {
////         String resourceUrl = "https://gcr.io/project/image@sha256:123";
////         String projectId = "my-project-id";
//        final String projectName = ProjectName.format(projectId);
//        final String filterStr = String.format("resourceUrl=\"%s\"", resourceUrl);
//
//        // Initialize client that will be used to send requests. After completing all of your requests,
//        // call the "close" method on the client to safely clean up any remaining background resources.
//
//        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream("C:\\Users\\Kanwar\\Downloads\\fluted-harmony-326907-29e801c6fcd0.json"))
//                .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
//
//        GrafeasSettings grafeasSettings =
//                GrafeasSettings.newBuilder()
//                        .setCredentialsProvider(FixedCredentialsProvider.create(credentials))
//                        .build();
//        GrafeasClient grafeasClient = GrafeasClient.create(grafeasSettings);
//
//        int i = 0;
//        for (Occurrence o : grafeasClient.listOccurrences(projectName, filterStr).iterateAll()) {
//            // Write custom code to process each Occurrence here
//            System.out.println(o.getName());
//            i = i + 1;
//        }
//
//
//        GrafeasClient client = ContainerAnalysisClient.create().getGrafeasClient();
//        i = 0;
//        for (Occurrence o : client.listOccurrences(projectName, filterStr).iterateAll()) {
//            // Write custom code to process each Occurrence here
//            System.out.println(o.getName());
//            i = i + 1;
//        }
//        return i;
//    }
//
//    public static CloudResourceManager createCloudResourceManagerService()
//            throws IOException, GeneralSecurityException {
//        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
//
//        GoogleCredential credential = GoogleCredential.getApplicationDefault();
//        if (credential.createScopedRequired()) {
//            credential =
//                    credential.createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
//        }
//
//        return new CloudResourceManager.Builder(httpTransport, jsonFactory, credential)
//                .setApplicationName("Google-CloudResourceManagerSample/0.1")
//                .build();
//    }
//
//    public static Compute createComputeService() throws IOException, GeneralSecurityException {
//        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
//        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
//
//        GoogleCredential credential = GoogleCredential.getApplicationDefault();
//        if (credential.createScopedRequired()) {
//            credential =
//                    credential.createScoped(Arrays.asList("https://www.googleapis.com/auth/cloud-platform"));
//        }
//
//        return new Compute.Builder(httpTransport, jsonFactory, credential)
//                .setApplicationName("Google-ComputeSample/0.1")
//                .build();
//    }
//
//    private static void getImagesList() throws IOException, GeneralSecurityException {
//        String project = "fluted-harmony-326907"; // TODO: Update placeholder value.
//
//        Compute computeService = createComputeService();
//        Compute.Images.List request = computeService.images().list(project);
//
//        ImageList response;
//        do {
//            response = request.execute();
//            if (response.getItems() == null) {
//                continue;
//            }
//            for (Image image : response.getItems()) {
//                // TODO: Change code below to process each `image` resource:
//                System.out.println(image);
//            }
//            request.setPageToken(response.getNextPageToken());
//        } while (response.getNextPageToken() != null);
//        System.out.println("pass google");
//    }
//
//    public static void getCloudProjects() throws IOException, GeneralSecurityException {
//        CloudResourceManager cloudResourceManagerService = createCloudResourceManagerService();
//        CloudResourceManager.Projects.List request = cloudResourceManagerService.projects().list();
//
//        ListProjectsResponse response;
//        do {
//            response = request.execute();
//            if (response.getProjects() == null) {
//                continue;
//            }
//            for (Project project : response.getProjects()) {
//                // TODO: Change code below to process each `project` resource:
//                System.out.println(project);
//            }
//            request.setPageToken(response.getNextPageToken());
//        } while (response.getNextPageToken() != null);
//    }
//}
