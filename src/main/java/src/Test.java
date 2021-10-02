package src;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String xyz = null;
        System.out.println("###"+StringUtils.substring(xyz, 0, 255)+"##");

//        componentUpdate();
    }

    private static void componentUpdate() {
        List<String> components = Arrays.asList("app.test:armorcode-aop:5.2.2.RELEASE",
                "app.test:armorcode:context:5.2.2-RELEASE",
                "me.soliveirajr:menta-regex:jar:0.9.6-SNAPSHOT",
                "app.demo.b2c.app-20.7.12-3.2-ALPHA.jar",
                "amqp-client-4.8.3.jar",
                "activemq-jms-pool-5.15.8.jar");
        for (String component : components) {
            System.out.println("###"+ getComponentVersion(component) + "###");
        }
    }

    private static String getComponentVersion(String fileName) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m;
        String split[] = fileName.split("-");
        for (int i=split.length - 1; i>=0; i--) {
            m = p.matcher(split[i]);
            if (m.find()) {
                return getVersion(split[i]);
            }
        }
        return "";
    }

    private static String getVersion(String str) {
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(str);
        if (!m.find()) {
            return str;
        }
        int startIndex = 0;
        for (int i=0; i<str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                startIndex = i;
                break;
            }
        }
        for (int i=str.length()-1; i>=0; i--) {
            if (Character.isDigit(str.charAt(i))) {
                return str.substring(startIndex, i+1);
            }
        }
        return "";
    }
}
