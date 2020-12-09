import java.lang.management.ThreadInfo;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int num = 0;
        T1 t1 = new T1(num);
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t1);
        thread.start();
        thread1.start();
        Thread.sleep(1000);
        System.out.println(t1.getNum());

    }
}
