package claude.volitevsSynchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyDemo {

    // 1. volatile → visibility only
    static volatile boolean stop = false;

    // 2. shared counters
    static int syncCounter = 0;
    static AtomicInteger atomicCounter = new AtomicInteger(0);

    static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {

        // ────────────────
        // DEMO 1: volatile (stop flag)
        // ────────────────
        Thread worker = new Thread(() -> {
            System.out.println("Worker started...");
            while (!stop) {
                // doing work
            }
            System.out.println("Worker stopped ✔");
        });

        worker.start();
        Thread.sleep(100);
        stop = true;
        worker.join();


        // ────────────────
        // DEMO 2: synchronized counter
        // ────────────────
        Runnable syncTask = () -> {
            for (int i = 0; i < 10_000; i++) {
                synchronized (LOCK) {
                    syncCounter++;
                }
            }
        };

        Thread t1 = new Thread(syncTask);
        Thread t2 = new Thread(syncTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Synchronized Counter = " + syncCounter);


        // ────────────────
        // DEMO 3: AtomicInteger counter
        // ────────────────
        Runnable atomicTask = () -> {
            for (int i = 0; i < 10_000; i++) {
                atomicCounter.incrementAndGet();
            }
        };

        Thread t3 = new Thread(atomicTask);
        Thread t4 = new Thread(atomicTask);

        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println("Atomic Counter       = " + atomicCounter.get());


        // ────────────────
        // FINAL RESULT
        // ────────────────
        System.out.println("\nExpected value = 20000 for both counters");
    }
}