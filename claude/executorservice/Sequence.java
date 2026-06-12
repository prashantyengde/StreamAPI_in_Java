package claude.executorservice;

class SequenceDemo {

    private int num = 1;

    public synchronized void print(int threadId) {

        while (num <= 10) {

            while (num <= 10 && num % 3 != threadId) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            if (num <= 10) {
                System.out.println(
                        Thread.currentThread().getName() + " : " + num++);
                notifyAll();
            }
        }
    }
}

public class Sequence {

    public static void main(String[] args) {

        SequenceDemo sequence = new SequenceDemo();

        Thread t1 = new Thread(() -> sequence.print(1), "Thread-1");
        Thread t2 = new Thread(() -> sequence.print(2), "Thread-2");
        Thread t3 = new Thread(() -> sequence.print(0), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}