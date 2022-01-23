package src.lld.razorpay;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
@ToString
public class HotTier implements Tier {
    private Map<String, String> docContentMp;

    public HotTier() {
        this.docContentMp = new HashMap<>();
    }

    @Override
    public void storeContent(String name, String content) {
        docContentMp.put(name, content);
    }

    @Override
    public String getContent(String name) {
        return docContentMp.get(name);
    }
}
