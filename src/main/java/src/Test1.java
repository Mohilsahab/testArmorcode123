package src;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    private enum Armor {
        ARMOR1("armor1", 1l),
        ARMOR2("armor2", 2l);

        private String armor;
        private Long value;

        Armor(String armor, long l) {
            this.armor = armor;
            this.value = l;
        }

        static Map<String, Long> severityWeightMap = new HashMap<>();

        static {
            severityWeightMap.put(ARMOR1.name(), ARMOR1.value);
            severityWeightMap.put(ARMOR2.name(), ARMOR2.value);
        }

        public static String getSeverityKey(Long severity) {
            return StringUtils.capitalize(severityWeightMap.entrySet().stream()
                    .filter(entry -> Objects.equals(entry.getValue(), severity))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.joining()));
        }
    }

    public static void main(String[] args) {
        String test = Armor.getSeverityKey(null);
        System.out.println(Armor.valueOf(test));
    }
}

