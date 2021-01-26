package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Tools {

    //For Code/Build DevOps Cycle
    BANDIT("Bandit"),
    BLACKDUCK("Blackduck"),
    BLACKDUCK_HUB("Blackduck Hub"),
    CHECKMARX("Checkmarx"),
    CHECKMARX_DETAILED("Checkmarx detailed"),
    DEPENDENCY_CHECK("Dependency Check"),
    ESLINT("ESLint"),
    FORTIFY("Fortify"),
    GO_SECNER("Gosecner"),
    JFROG("JFrog Xray"),
    SONARQUBE("SonarQube"),
    SONARQUBE_DETAILED("SonarQube detailed"),
    SONATYPE("SonaType"),
    SYNK("Synk"),
    VEERACODE("VeeraCode"),

    //For Plan DevOps Cycle
    FORESEETI("Foreseeti"),
    MICROSOFT_THREAT_MODELING("Microsoft Threat Modeling"),
    OWASP_THREAT_DRAGON("Owasp Threat Dragon"),

    //For Test/Deploy DevOps Cycle
    DAST("DAST"),
    SAST("SAST"),

    //For Release DevOps Cycle
    BURP("Burp"),
    HCL_APP_SCAN("HCL App Scan"),
    QUALYS("Qualys"),
    WEB_INSPECT("Web Inspect"),
    ZAP("ZAP"),

    //For Operate DevOps Cycle
    GIT("Git"),
    GITLAB("GitLab"),

    //For Monitor DevOps Cycle
    NAGIOS("Nagios"),
    SPLUNK("Splunk"),
    VAGRANT("Vagrant");

    private final String value;

    Tools(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Tools forValue(String v) {
        for (Tools c: Tools.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        return null;
    }

    public static Map<String, List<String>> toolsTypeMapping() {
        Map<String, List<String>> toolsTypeMap = new HashMap<>();
        toolsTypeMap.put(Tools.DEPENDENCY_CHECK.value(), Arrays.asList(ToolTypes.SCA.name()));
        toolsTypeMap.put(Tools.JFROG.value(), Arrays.asList(ToolTypes.SCA.name()));
        toolsTypeMap.put(Tools.GO_SECNER.value(), Arrays.asList(ToolTypes.SCA.name()));
        toolsTypeMap.put(Tools.SYNK.value(), Arrays.asList(ToolTypes.SCA.name()));
        toolsTypeMap.put(Tools.SONATYPE.value(), Arrays.asList(ToolTypes.SCA.name()));

        toolsTypeMap.put(Tools.BANDIT.value(), Arrays.asList(ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.BLACKDUCK.value(), Arrays.asList(ToolTypes.SCA.name(), ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.BLACKDUCK_HUB.value(), Arrays.asList(ToolTypes.SCA.name(), ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.CHECKMARX.value(), Arrays.asList(ToolTypes.SCA.name(), ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.CHECKMARX_DETAILED.value(), Arrays.asList(ToolTypes.SCA.name(), ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.FORTIFY.value(), Arrays.asList(ToolTypes.SCA.name(), ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.VEERACODE.value(), Arrays.asList(ToolTypes.SCA.name(), ToolTypes.SAST.name()));

        toolsTypeMap.put(Tools.ESLINT.value(), Arrays.asList(ToolTypes.SAST.name()));
        toolsTypeMap.put(Tools.SONARQUBE.value(), Arrays.asList(ToolTypes.SAST.name()));

        toolsTypeMap.put(Tools.BURP.value(), Arrays.asList(ToolTypes.DAST.name()));
        toolsTypeMap.put(Tools.ZAP.value(), Arrays.asList(ToolTypes.DAST.name()));

        return toolsTypeMap;
    }
}
