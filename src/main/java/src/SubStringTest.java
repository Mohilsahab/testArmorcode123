package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubStringTest {

    private static final String GITHUB_API_BASE_URL = "https://api.github.com/";
    private static final String SEPARATOR = "/";
    private static final String GITHUB_URL = "https://github.com/";
    public static final String VALID_URL_REGEX = "(https://)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";

    public static void main(String[] args) {
        new SubStringTest().test();
    }

    private void test() {
//        String test = "https://github.com/repos/Mohilsahab/testing";
//        String[] split = test.split("/");
//        System.out.println(split);
        System.out.println(isValidURL("https://txyfgdfg.com.com%"));
    }

    public static boolean isValidURL(String url)
    {
        // Regex to check valid URL
//        String regex = "(https://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
        String regex = "(https://)(www.)?[a-zA-Z0-9.]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9.]*)";

        // Compile the ReGex

        Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (url == null) {
            return false;
        }

        // Find match between given string
        // and regular expression
        // using Pattern.matcher()
        Matcher m = p.matcher(url);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

}
