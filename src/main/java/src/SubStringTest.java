package src;

public class SubStringTest {

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/";
    private static final String SEPARATOR = "/";
    private static final String GITHUB_URL = "https://github.com/";

    class FindingIndex{
        private String testType;
        public FindingIndex(String testType) {
            this.testType = testType;
        }
        public String getTestType() {
            return testType;
        }
        public void setTestType(String testType) {
            this.testType = testType;
        }
    }
    public static void main(String[] args) {
        new SubStringTest().test();
    }

    private void test() {
        FindingIndex findingIndex = new FindingIndex("SonarQube");

        if (ToolTypes.getToolTypesList(ToolTypes.SAST).stream()
                .anyMatch(toolType ->  toolType == findingIndex.getTestType())) {
            System.out.println("trrr");
        }
        System.out.println("false");
    }
}
