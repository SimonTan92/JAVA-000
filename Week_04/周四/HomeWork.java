package week04;

import java.util.concurrent.*;

/**
 * 思考有多少种方式，在 main 函数启动一个新线程，
 * 运行一个方法，拿到这个方法的返回值后，退出主线程？
 */
public class HomeWork {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int result = 0;
        result = method1();
        System.out.println(result);
        result = method2();
        System.out.println(result);
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }

    public static int method1() throws ExecutionException, InterruptedException {
        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // 获取结果
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return HomeWork.sum();
            }
        });
        executorService.shutdown();
        return future.get();
    }

    public static int method2() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return HomeWork.sum();
            }
        });
        new Thread(futureTask).start();
        return futureTask.get();
    }
}
