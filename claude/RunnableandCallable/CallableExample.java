package claude.RunnableandCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum; // returning result
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);

        Thread t1 = new Thread(futureTask);
        t1.start();

        // get result (blocks until result is ready)
        Integer result = futureTask.get();

        System.out.println("Sum = " + result);
    }
}