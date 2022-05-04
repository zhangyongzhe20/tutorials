package com.baeldung.concurrent.pratice;

public class ThreadA extends Thread{
    ResourceLock lock;
    final int nums = 3;
    ThreadA(ResourceLock lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try{
            synchronized (lock) {
                while(true){
                    while(lock.flag!=1){
                        lock.wait();
                    }
//                    for(int i =0; i<nums; i++)
                        System.out.print("A");
//                    before release lock, set the flag for next thread
                    lock.flag=2;
                    lock.notifyAll();
                }
            }
        }catch (Exception e){
            System.err.println("Exception Thread A");
        }
    }

}
