package com.baeldung.concurrent.waitandnotify;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver2 implements Runnable {

    private Data load;

    public Receiver2(Data load) {
        this.load = load;
    }


    @Override
    public void run() {
        //could receive multuiple string
        for(String receivedMsg = load.receive(); !"End".equals(receivedMsg);
        receivedMsg = load.receive()){
            System.out.println(receivedMsg);
        }

        //mimic heavy server-side processing
        try{
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }


    }
}