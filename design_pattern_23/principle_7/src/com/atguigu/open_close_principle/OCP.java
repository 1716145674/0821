package com.atguigu.open_close_principle;

public class OCP {
    public static void main(String[] args) {
        Edit edit = new Edit();
        edit.draw(new sanJiao());
        edit.draw(new siBianXing());
        edit.draw(new lingXing());
    }
}

class Edit {
    public void draw(shape shape) {
        shape.doDraw();
    }
}

abstract class shape {
    abstract void doDraw();
}

class sanJiao extends shape {
    @Override
    void doDraw() {
        System.out.println("三角形！！");
    }
}

class siBianXing extends shape {

    @Override
    void doDraw() {
        System.out.println("四边形！！");
    }
}
class lingXing extends  shape{

    @Override
    void doDraw() {
        System.out.println("菱形！！");
    }
}
