package test180105;

import java.util.concurrent.*;

/**
 *
 * @author hanshihui
 * @date 2018/1/5
 */
public class ThreadPoolTestOne {
//    private static Executor executor = Executors.newFixedThreadPool(10);

    private static ExecutorService executorService = new ThreadPoolExecutor(10, 10,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            executorService.execute(new Task());
        }
    }

    static class Task implements Runnable
    {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
