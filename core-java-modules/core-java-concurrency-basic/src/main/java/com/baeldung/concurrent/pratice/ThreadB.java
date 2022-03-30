package com.baeldung.concurrent.pratice;

public class ThreadB extends Thread{
    ResourceLock lock;
    final int nums=2;
    ThreadB(ResourceLock lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try{
            synchronized (lock) {
                while(true){
                    while(lock.flag!=2){
                        lock.wait();
                    }
//                    for(int i =0; i<nums; i++)
                    System.out.print("B");
                    lock.flag=3;
                    lock.notifyAll();
                }
            }
        }catch (Exception e){
            System.err.println("Exception Thread B");
        }
    }
}
