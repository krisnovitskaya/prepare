package les3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//        2. Реализовать потокобезопасный счетчик с помощью интерфейса Lock.
public class Counter {
    private int counter;
    private Lock lock;

    public Counter() {
        counter = 0;
        lock = new ReentrantLock();
    }

    public void increase(){
        lock.lock();
        try{
            counter++;
        }finally {
            lock.unlock();
        }
    }

    public int get(){
        lock.lock();
        try{
            return counter;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 500; j++) {
                        counter.increase();
                    }
                }
            }).start();
        }

        Thread.sleep(10000);
        System.out.println(counter.get());
    }

}
