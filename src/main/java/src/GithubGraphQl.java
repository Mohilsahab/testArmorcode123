package src;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.StringUtils;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.*;

public class GithubGraphQl {

    public static final int NO_LINES_TO_CHECK = 10;

    public static void main(String[] args) {
        String res = GithubGraphQl.httpConnection();
        System.out.println(res);
        Gson gson = new Gson();
        GithubFileCommitDetails response = gson.fromJson(res, GithubFileCommitDetails.class);

        List<GithubCommitDetailsResponse> ranges = response.getData().getRepository().getRef().getTarget().getBlame().getRanges();
        String commiter = getLineLastCommitter(ranges, 82l);
        System.out.println("commiter:" + commiter);
        Map<String, Set<String>> params = new HashMap<>();
        params.put("123", new HashSet<>(Arrays.asList("titleToNumber")));
        Set<String> findings = getFindings(response.getData().getRepository().getRef().getTarget().getFile().getObject().getText(), 14l, params);
        System.out.println("findings:" + findings);
    }

    private static Set<String> getFindings(String text, Long lineNumber, Map<String, Set<String>> findingParams) {
        if (Objects.isNull(lineNumber)
                || Objects.isNull(findingParams)
                || StringUtils.isEmpty(text)) {
            return null;
        }
        Set<String> findings = new HashSet<>();
        String arr[] = text.split("\n");
        for (Map.Entry<String, Set<String>> findingParam : findingParams.entrySet()) {
            for (int i = Math.toIntExact(lineNumber); i > lineNumber - NO_LINES_TO_CHECK && i>=0; i--) {
                for (String param : findingParam.getValue()) {
                    if (arr[i].contains(param)) {
                        findings.add(findingParam.getKey());
                    }
                }
            }
        }
        return findings;
    }

    private static String getLineLastCommitter(List<GithubCommitDetailsResponse> commitDetails, Long lineNumber) {
        if (lineNumber == null) {
            return getFileLastCommitterResponse(commitDetails);
        }

        Optional<GithubCommitDetailsResponse> response =
                commitDetails.stream()
                        .filter(commitDetailsResponse -> lineNumber.compareTo(commitDetailsResponse.getEndingLine()) <= 0)
                        .findFirst();

        return response.isPresent()
                ? response.get().getCommit().getCommitter().getEmail()
                : getFileLastCommitterResponse(commitDetails);
    }

    private static String getFileLastCommitterResponse(List<GithubCommitDetailsResponse> commitDetails) {
        Comparator<GithubCommitDetailsResponse> comparator = (o1, o2) -> (o2.getCommit().getCommitter().getDate().compareTo(o1.getCommit().getCommitter().getDate()));
        commitDetails.sort(comparator);
        return commitDetails.get(0).getCommit().getCommitter().getEmail();
    }

    public static String httpConnection() {
        StringBuilder result = new StringBuilder();
        try {
            String link = "https://api.github.com/graphql";
            URL url = new URL(link);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            String token = "ghs_j6DnV5Bc56RFbjHTPBGwgTnLwWMCds0M6gth";
            connection.setRequestProperty("Content-Type", "application/json");
//            connection.setRequestProperty("Accept-Charset", "UTF-8");
//            connection.setRequestProperty("Accept", "application/json");
//            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Authorization", "Bearer ghs_j6DnV5Bc56RFbjHTPBGwgTnLwWMCds0M6gth");
            connection.setDoOutput(true);
            String query = "{\"query\":\"query{repository(name: \\\"<repo>\\\", owner: \\\"<owner>\\\"){ref(qualifiedName:\\\"<branch>\\\"){target{...on Commit{blame(path:\\\"<path>\\\"){ranges{commit{author{name email date}committer{name email date}}startingLine endingLine commit {message url}}} file(path: \\\"<path>\\\"){object{...on Blob{text}}} }}}}}\"";
            String json = query.replace("<repo>", "PetClinic")
                                .replace("<owner>", "Linish2020")
                                .replace("<branch>", "main")
                                .replace("<path>", "src/main/java/org/springframework/samples/petclinic/owner/VisitController.java");
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

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GithubFileCommitDetails implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private Data data;

        @Getter
        @Setter
        @NoArgsConstructor
        public static class Data {
            private GitHubRepository repository;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GitHubRepository {
            private GithubRef ref;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GithubRef {
            private GithubTarget target;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GithubTarget {
            private GithubBlame blame;
            private GithubFile file;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GithubFile {
            private GithubObject object;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GithubObject {
            private String text;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GithubBlame {
            private List<GithubCommitDetailsResponse> ranges;
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class GithubCommitDetailsResponse implements Serializable {
        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private String sha;
        @SerializedName("node_id")
        private String nodeId;
        private GithubCommitDetails commit;
        private Long startingLine;
        private Long endingLine;

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class GithubCommitDetails {
            private GithubCommitter author;
            private GithubCommitter committer;
            private String message;
            private String url;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class GithubCommitter {
            private String email;
            private String name;
            private Timestamp date;
        }
    }

}
