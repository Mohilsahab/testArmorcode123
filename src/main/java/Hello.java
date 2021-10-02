
public class Hello implements Runnable{
    String s1,s2;
    public void run() {
        for(int i=0;i<10; i++) {
            s1 = "Welcome";
            s2 = "to java";
            System.out.println(s1+s2);
        }
    }
    public static void main(String[] args) {
     Hello hello = new Hello();
     Thread obj1 = new Thread();
     Thread obj2 = new Thread();
     obj1.start();
     obj2.run();

    }
}
