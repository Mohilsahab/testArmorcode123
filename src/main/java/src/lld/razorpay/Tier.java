package src.lld.razorpay;

public interface Tier {
    void storeContent(String name, String content);

    String getContent(String name);
}
