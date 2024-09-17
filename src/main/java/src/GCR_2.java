//package src;
//
//import com.google.api.gax.paging.Page;
//import com.google.auth.oauth2.AccessToken;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.cloud.storage.Bucket;
//import com.google.cloud.storage.Storage;
//import com.google.cloud.storage.StorageOptions;
//import com.google.common.collect.Lists;
//import org.apache.commons.io.IOUtils;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.HashMap;
//import java.util.Map;
//
//public class GCR_2 {
//    public static void main(String[] args) {
//        Map<String, Object> map = new GCR_2().getStringObjectMap();
//        accessToken(map);
//    }
//
//    private Map<String, Object> getStringObjectMap() {
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
//    private static void accessToken(Map<String, Object> configMap) {
//        try {
//            GoogleCredentials credentials = GoogleCredentials.fromStream(IOUtils.toInputStream(GsonUtil.getGson().toJson(configMap)))
//                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
////                .createScoped(Lists.newArrayList("https://accounts.google.com/o/oauth2/v2/auth"));
////                .createScoped(Lists.newArrayList("https://oauth2.googleapis.com/token"));
//            Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
//
//            Page<Bucket> buckets = storage.list();
//            AccessToken accessToken = credentials.getAccessToken();
//            System.out.println("token - " + accessToken.getTokenValue());
//            System.out.println(accessToken.getTokenValue());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
