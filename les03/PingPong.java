package les3;

import lombok.SneakyThrows;



//1. Реализовать программу, в которой два потока поочередно пишут ping и pong.

public class PingPong {
    public static Object mon = new Object();

    public static void main(String[] args) {

        Thread ping = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (mon) {
                    while (true) {
                        System.out.println("ping");
                        mon.notify();
                        mon.wait();
                    }
                }
            }
        });

        Thread pong = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (mon) {
                    while (true) {
                        System.out.println("pong");
                        mon.notify();
                        mon.wait();
                    }
                }
            }
        });

        ping.start();
        pong.start();
    }
}
