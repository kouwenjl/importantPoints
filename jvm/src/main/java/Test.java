import java.util.concurrent.*;

public class Test {
    ThreadLocal

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor d = new ThreadPoolExecutor(2, 4, 2000l, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>());
        ThreadFactory s = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread();
                thread.setUncaughtExceptionHandler();
                return null;
            }
        }
        Future<String> futureTask = d.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Integer.parseInt("ss");
                return null;
            }
        });
        futureTask.get();

    }
}
