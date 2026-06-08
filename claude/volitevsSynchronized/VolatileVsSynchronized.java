package claude.volitevsSynchronized;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileVsSynchronized {

	// 1. volatile — visibility only (good for flags)
	static volatile boolean stopFlag = false;

	// 2. volatile counter — UNSAFE for i++ (race condition)
	static volatile int volatileCounter = 0;

	// 3. synchronized counter — SAFE
	static int syncCounter = 0;
	static final Object LOCK = new Object();

	// 4. AtomicInteger — lock-free and SAFE
	static AtomicInteger atomicCounter = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {

		// ── DEMO 1: volatile stop flag ──
		Thread worker = new Thread(() -> {
			int c = 0;
			while (!stopFlag)
				c++;
			System.out.println("DEMO1 | Worker stopped at count=" + c + " ✓");
		});
		worker.start();
		Thread.sleep(50);
		stopFlag = true;
		worker.join();

		// ── DEMO 2: volatile i++ — race condition ──
		Runnable vIncrement = () -> {
			for (int i = 0; i < 10_000; i++)
				volatileCounter++;
		};
		Thread t1 = new Thread(vIncrement), t2 = new Thread(vIncrement);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("DEMO2 | volatile  counter → expected 20000, got " + volatileCounter + " ✗ (race!)");

		// ── DEMO 3: synchronized i++ — safe ──
		Runnable sIncrement = () -> {
			for (int i = 0; i < 10_000; i++) {
				synchronized (LOCK) {
					syncCounter++;
				}
			}
		};
		Thread t3 = new Thread(sIncrement), t4 = new Thread(sIncrement);
		t3.start();
		t4.start();
		t3.join();
		t4.join();
		System.out.println("DEMO3 | sync      counter → expected 20000, got " + syncCounter + " ✓");

		// ── DEMO 4: AtomicInteger — safe + lock-free ──
		Runnable aIncrement = () -> {
			for (int i = 0; i < 10_000; i++)
				atomicCounter.incrementAndGet();
		};
		Thread t5 = new Thread(aIncrement), t6 = new Thread(aIncrement);
		t5.start();
		t6.start();
		t5.join();
		t6.join();
		System.out.println("DEMO4 | Atomic    counter → expected 20000, got " + atomicCounter.get() + " ✓");

		System.out.println("\n── SUMMARY ──");
		System.out.println("volatile      → visibility ✓ | atomicity ✗ | use: stop flags");
		System.out.println("synchronized  → visibility ✓ | atomicity ✓ | use: compound ops");
		System.out.println("AtomicInteger → visibility ✓ | atomicity ✓ | use: counters (faster than sync)");
	}
}