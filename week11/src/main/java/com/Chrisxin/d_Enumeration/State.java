package com.Chrisxin.d_Enumeration;

public enum State {
    //这里相当于使用有参构造State(String name)创建本类型对象: State UNPAID=new State("未支付")
    UNPAID("未支付"),
    PAID("已支付"),
    UNSHIPPED("未发货"),
    SHIPPED("已发货");

    private final String name;

    State(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

}
