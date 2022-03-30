package com.baeldung.concurrent.pratice;

public class ThreadC extends Thread{
    ResourceLock lock;
    ThreadC(ResourceLock lock){
        this.lock = lock;
    }

    @Override
    public void run(){
        try{
            synchronized (lock) {
                while(true){
                    while(lock.flag!=3){
                        lock.wait();
                    }
                    System.out.print("C");
                    lock.flag=1;
                    lock.notifyAll();
                }
            }
        }catch (Exception e){
            System.err.println("Exception Thread C");
        }
    }
}
