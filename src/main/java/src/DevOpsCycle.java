package src;

public enum DevOpsCycle {
    PLAN("Plan"),
    CODE("Code"),
    BUILD("Build"),
    TEST("Test"),
    RELEASE("Release"),
    DEPLOY("Deploy"),
    OPERATE("Operate"),
    MONITOR("Monitor");

    private final String value;

    DevOpsCycle(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DevOpsCycle forValue(String v) {
        for (DevOpsCycle c: DevOpsCycle.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        return null;
    }
}
