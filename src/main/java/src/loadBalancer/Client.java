package src.loadBalancer;

public class Client {
    public static void main(String[] args) throws Exception{
        LoadBalancer loadBalancer = new LoadBalancer(2, 3);
        int id = loadBalancer.executeTasks(50, 50);
        int id2 = loadBalancer.executeTasks(30, 40);
        int id3 = loadBalancer.executeTasks(30, 40);
        int id4 = loadBalancer.executeTasks(30, 40);
        System.out.println("test");
    }
}