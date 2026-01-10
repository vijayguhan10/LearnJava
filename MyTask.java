import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask extends Thread {
    @Override
    public void run() {
        System.out.println(
                "Running in thread: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(110);

        for (int i = 0; i < 2000; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName());
            });
        }

        executor.shutdown();



    }
}
