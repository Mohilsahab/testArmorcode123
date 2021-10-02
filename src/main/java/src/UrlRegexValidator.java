package src;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlRegexValidator {
    public static void main(String[] args) {
        final String regex = "(http|https)(:\\/\\/)?(www.)?(?!.*(ftp|http|https|www.))[a-zA-Z0-9_-]+(\\.[a-zA-Z]+)+((\\/)[\\w#]+)*(\\/\\w+\\?[a-zA-Z0-9_]+=\\w+(&[a-zA-Z0-9_]+=\\w+)*)?$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("https://www.asp.net.com/abcd?abcd=123&fhdg=123");

        String url = null;
        if(m.find()){
            url = m.group();
        }
        System.out.println(url);
    }
}
