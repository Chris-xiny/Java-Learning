package com.xin.d_MultiThread;

public class test {
    public static void main(String[] args) {
        BaoziShop bzs =new BaoziShop(0, false);
        Producer p=new Producer(bzs);
        Consumer c=new Consumer(bzs);
        //如果多个生产者和消费者会出现什么情况呢?
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();
        /*  
            结果是不能做到生产一个消费一个了，原因是因为notify随机唤醒一个线程，举一个例子：假如flag==true生产者全部唤醒却都进入if等待后，
            消费者线程才开始抢到锁，第一个吃掉了包子唤醒了生产线程，flag==true,但notify假如唤醒的还是生产者并且这个生产者抢到锁了，那么即使
            flag==true，他依然会直接出if并生产，因为他上一次在if中wait，醒来抢到锁后直接继续上一次的执行
            因此需要使用notifyAll()配合if改为while每次都要判断flag来解决问题
        */
    }
    

}
