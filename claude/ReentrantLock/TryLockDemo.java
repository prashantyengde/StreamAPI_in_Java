package claude.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {

        if (lock.tryLock()) {

            try {
                System.out.println("Lock acquired by " +
                        Thread.currentThread().getName());
            } finally {
                lock.unlock();
            }

        } else {
            System.out.println("Could not acquire lock");
        }
    }
}