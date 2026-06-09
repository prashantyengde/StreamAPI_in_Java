package claude.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {

            for (int i = 0; i < 10000; i++) {

                lock.lock(); // Acquire lock

                try {
                    counter++;
                } finally {
                    lock.unlock(); // Always release lock
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Counter Value = " + counter);
    }
}