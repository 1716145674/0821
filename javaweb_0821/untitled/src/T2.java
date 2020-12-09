public class T2 implements Runnable{
    private Integer num;

    public T2(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        num++;
    }
}
