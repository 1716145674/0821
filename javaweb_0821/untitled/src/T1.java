public class T1  implements Runnable{
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public T1(Integer num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i <1000000 ; i++) {

            num++;
        }
    }
}
