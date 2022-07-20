package com.baeldung.concurrent.waitandnotify;

public class Data2 {

    private String packet;
    // True if receiver should wait
    //False if sender should wait
    private boolean transfer = true;

    public synchronized String receive() {
        while(transfer){
            try{
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
        }
        transfer = true;

        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String packet){
        while(!transfer){
            try {
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = false;
        this.packet = packet;
        notifyAll();
    }
}