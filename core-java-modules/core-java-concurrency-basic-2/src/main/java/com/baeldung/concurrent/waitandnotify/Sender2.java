package com.baeldung.concurrent.waitandnotify;

public class Sender2 implements Runnable {
    private Data data;

    public Sender2(Data data) {
        this.data = data;
    }

    @Override
    public void run(){
        String packets[] = {
                "First Packet",
                "2",
                "3",
                "4",
                "End"
        };
        for(String packet: packets){
            data.send(packet);
        }

    }

}