package src.cache;

import java.util.*;

public class ExpiryTimeCache {
    /*
    You need to design a simple caching system like mini version of redis.
    In which , you need to store simple key value pairs as strings with some expiry like expiry time can be in seconds or may be in years.
    You need to make sure that users are not getting expired keys and you are timely deleting all the expired keys as we dont have too much memory.
    There can be billions of keys at any point of time.
     */

    static Map<String, Temp> cacheMap = new HashMap<String, Temp>();
    static Map<Date, List<String>> keyStorageSystem = new TreeMap<Date, List<String>>();
    class Temp{
        public String value;
        public Date expiryTime;

        public Temp(String value, Date expiryTime) {
            this.value = value;
            this.expiryTime = expiryTime;
        }
    }

    public static void main(String[] args) {
    }

    private void removeExpiredKeys(Date now) {
        for (Map.Entry<Date, List<String>> keyStorage : keyStorageSystem.entrySet()) {
            if (keyStorage.getKey().compareTo(new Date())<1) {
                List<String> list = keyStorage.getValue();
                for (String key : list) {
                    cacheMap.remove(key);
                }
            } else {
                break;
            }
        }
        removeExpiredKeysFromKeyStore(now);
    }

    private void removeExpiredKeysFromKeyStore(Date now) {
    }

    void put(String key, String value, Date expiryTime) {
        Temp temp = new Temp(value, expiryTime);
        if (temp.expiryTime.compareTo(new Date()) > 1) {
            cacheMap.put(key, temp);
        }

    }

    Temp get(String key) {
        Temp temp = cacheMap.get(key);
        if (temp.expiryTime.compareTo(new Date()) < 1) {
            cacheMap.remove(key);
            return null;
        }
        return temp;
    }
}
