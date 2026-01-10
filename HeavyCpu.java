import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HeavyCpu {

    static void heavyBusinessLogic(int taskId) {
        long start = System.currentTimeMillis();

        double result = 1.0;

        // VERY heavy math load
        for (long i = 1; i < 8_00_000_000L; i++) {
            result += Math.sqrt(i) * Math.log(i);
            if (result > 1e12) {
                result = result / 2; // avoid overflow
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(
            "Task " + taskId +
            " | Thread: " + Thread.currentThread().getName() +
            " | Time(ms): " + (end - start)
        );
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Detected CPU cores: " + cores);

        // Try values: cores, cores*2, cores*4
        ExecutorService pool = Executors.newFixedThreadPool(32);

        for (int i = 1; i <= 32; i++) {
            int taskId = i;
            pool.submit(() -> heavyBusinessLogic(taskId));
        }

        pool.shutdown();
    }
}
