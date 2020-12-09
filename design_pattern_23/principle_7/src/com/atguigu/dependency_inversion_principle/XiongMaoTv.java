package com.atguigu.dependency_inversion_principle;

 class XiongMaoTv implements ITv {

        @Override
        public void play() {
            System.out.println("熊猫电死打开了！");
        }
    }