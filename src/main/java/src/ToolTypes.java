package src;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ToolTypes {
    SCA("SCA"),
    SAST("SAST"),
    DAST("DAST"),
    THREAT_MODEL("Threat Model"),
    AUTOMATION("Automation"),
    VAPT("VAPT"),
    VERSION_CONTROL("Version Control"),
    DYNAMIC("Dynamic");

    private final String value;

    ToolTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ToolTypes forValue(String v) {
        for (ToolTypes c: ToolTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        return null;
    }

    public static Map<ToolTypes, List<String>> toolTypesMap() {
        Map<ToolTypes, List<String>> toolTypesMap = new HashMap<>();
        toolTypesMap.put(ToolTypes.SCA,
                Arrays.asList(Tools.BLACKDUCK.value(), Tools.BLACKDUCK_HUB.value(), Tools.CHECKMARX.value(),
                        Tools.CHECKMARX_DETAILED.value(), Tools.DEPENDENCY_CHECK.value(), Tools.FORTIFY.value(),
                        Tools.GO_SECNER.value(), Tools.JFROG.value()));

        toolTypesMap.put(ToolTypes.SAST,
                Arrays.asList(Tools.BANDIT.value(), Tools.BLACKDUCK.value(), Tools.BLACKDUCK_HUB.value(),
                        Tools.CHECKMARX.value(), Tools.CHECKMARX_DETAILED.value(), Tools.ESLINT.value(),
                        Tools.FORTIFY.value(), Tools.SONARQUBE.value(), Tools.SONARQUBE_DETAILED.value()));

        toolTypesMap.put(ToolTypes.DAST,
                Arrays.asList(Tools.BURP.value(), Tools.ZAP.value()));
        return toolTypesMap;
    }

    public static List<String> getToolTypesList(ToolTypes toolType) {
        return toolTypesMap().get(toolType);
    }

    public static Map<ToolTypes, List<String>> toolTypeDevOpsCycleMap() {
        Map<ToolTypes, List<String>> toolTypesMap = new HashMap<>();
        toolTypesMap.put(ToolTypes.SCA, Arrays.asList(DevOpsCycle.CODE.value(), DevOpsCycle.BUILD.value()));
        toolTypesMap.put(ToolTypes.SAST, Arrays.asList(DevOpsCycle.CODE.value(), DevOpsCycle.BUILD.value(),
                DevOpsCycle.TEST.value(), DevOpsCycle.DEPLOY.value()));
        toolTypesMap.put(ToolTypes.DAST, Arrays.asList(DevOpsCycle.RELEASE.value(),
                DevOpsCycle.TEST.value(), DevOpsCycle.DEPLOY.value()));

//        toolTypesMap.put(ToolTypes.THREAT_MODEL, Arrays.asList(DevOpsCycle.PLAN.value()));
//        toolTypesMap.put(ToolTypes.AUTOMATION, Arrays.asList(DevOpsCycle.TEST.value()));
//        toolTypesMap.put(ToolTypes.VAPT, Arrays.asList(DevOpsCycle.RELEASE.value(), DevOpsCycle.DEPLOY.value()));
//        toolTypesMap.put(ToolTypes.VERSION_CONTROL, Arrays.asList(DevOpsCycle.OPERATE.value()));
//        toolTypesMap.put(ToolTypes.DYNAMIC, Arrays.asList(DevOpsCycle.MONITOR.value()));
        return toolTypesMap;
    }
}
