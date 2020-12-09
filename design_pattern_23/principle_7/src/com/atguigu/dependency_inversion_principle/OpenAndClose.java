package com.atguigu.dependency_inversion_principle;

public class OpenAndClose  {
    ITv iTv;

    public OpenAndClose(ITv iTv) {
        this.iTv = iTv;
    }

    public ITv getiTv() {
        return iTv;
    }

    public void setiTv(ITv iTv) {
        this.iTv = iTv;
    }

    public void open() {
        iTv.play();
    }
}
