package src;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1 {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {
        Set<String> sets = new HashSet<>();
        sets.add("test");
        Map<String, Object> mp = new HashMap<>();
        mp.put("params", null);

        Set<String> test = (Set<String>) mp.get("params");
        System.out.println(test);


        FindingTest findingTest = FindingTest.builder().properties(mp).build();

        String objectStr = null;
        try {
            objectStr = objectMapper.writeValueAsString(mp);
        } catch (final JsonProcessingException exception) {
            System.out.println(exception);
            System.out.println("Exception occurred #################");
        }
        System.out.println(objectStr);
        System.out.println(findingTest);
    }


    @Data
    @Builder
    public static class FindingTest {
        Map<String, Object> properties;
    }
}
