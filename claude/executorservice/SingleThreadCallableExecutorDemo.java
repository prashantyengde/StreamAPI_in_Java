package claude.executorservice;

import java.util.concurrent.*;

class MyTask implements Callable<Integer> {

	@Override
	public Integer call() {
		return 10 + 20;
	}
}

public class SingleThreadCallableExecutorDemo {
	public static void main(String[] args) throws Exception {

		ExecutorService executor = Executors.newSingleThreadExecutor();

		try {
			Future<Integer> future = executor.submit(new MyTask());
			System.out.println(future.get());
		} finally {
			executor.shutdown();
		}
	}

}
