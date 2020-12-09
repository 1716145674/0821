package com.zqq.prototype;

import java.io.Serializable;

public class DeepCloneableTarget  implements Serializable ,Cloneable{
    public static final Long serialVersionUID=1L;
    private String name;

    public DeepCloneableTarget() {
    }

    public DeepCloneableTarget(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DeepCloneableTarget{" +
                "name='" + name + '\'' +
                '}';
    }
}
