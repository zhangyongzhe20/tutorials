package com.baeldung.concurrent.waitandnotify;

public class NetworkDriver2 {
    public static void main(String[] args) {

        Data data = new Data();
        Thread sender = new Thread(new Sender2(data));
        Thread receiver = new Thread(new Receiver2(data));
        sender.start();
        receiver.start();

    }
}