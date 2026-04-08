package com.xin;

public class DieLockDemo implements Runnable{
    static Object LockA=new Object();
    static Object LockB=new Object();
    boolean flag;
    DieLockDemo(boolean f){
        flag=f;
    }
    @Override
    public void run(){
        if(flag==true){
            synchronized(LockA){//第一个线程先获得锁A
                System.out.println("if...LockA");
                synchronized(LockB){//此时大概率锁B在第二个线程那
                    System.out.println("if...LockB");
                }
            }//-------------------------------------------------------------->两边都在等待对方释放锁，卡死
        }else{
            synchronized(LockB){//第二个线程先获得锁B
                System.out.println("else...LockB");
                synchronized(LockA){//此时大概率锁A在第一个线程那
                    System.out.println("else...LockA");
                }
            }
        }
    }

    public static void main(String[] args) {
        DieLockDemo DieLock1=new DieLockDemo(true);
        DieLockDemo DieLock2=new DieLockDemo(false);

        new Thread(DieLock1).start();
        new Thread(DieLock2).start();
    }
}
