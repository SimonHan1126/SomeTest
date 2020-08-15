package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
	public static void main(String[] args) {
		FutureTask<String> future = new FutureTask<String>(new RealData("a"));
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.submit(future);
		
		System.out.println("请求完毕");
		
		try {
			Thread.sleep(2000);
			System.out.println("data:" + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
