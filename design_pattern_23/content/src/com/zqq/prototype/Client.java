package com.zqq.prototype;

public class Client {
    public static void main(String[] args) {
//        Sheep sheep = new Sheep("多利", 18, "白色");
//        Sheep clone = sheep.clone();
//        Sheep clone1 = sheep.clone();
//        System.out.println(sheep.hashCode());
//        System.out.println(clone.hashCode());
//        System.out.println(clone1.hashCode());
        DeepPrototype deepPrototype = new DeepPrototype("张三", new DeepCloneableTarget("zhangsan"));

        DeepPrototype deepPrototype1 = deepPrototype.deepClone();

        System.out.println(deepPrototype.toString()+deepPrototype.hashCode() +","+deepPrototype.getDeepCloneableTarget().hashCode());
        System.out.println(deepPrototype1.toString()+deepPrototype1.hashCode() +","+deepPrototype1.getDeepCloneableTarget().hashCode());

    }
}
