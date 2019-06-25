package com.zhu.springboot.utils;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class ExecutorsUtils {
    // 最小活动线程数
    private static final Integer MIN_THREAD_NUM = 5;
    // 最大活动线程数
    private static final Integer MAN_THREAD_NUM = 40;

    private static ThreadPoolExecutor service = new ThreadPoolExecutor(MIN_THREAD_NUM,
            MAN_THREAD_NUM,
            5,
            TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.CallerRunsPolicy() {
        @Override
        public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor) {
            paramRunnable.run();
        }
    });

    public static <T> Future<T> execCommonThread(Callable<T> paramRunnable) {
        return service.submit(paramRunnable);
    }

    public static Future<?> execCommonThread(Runnable paramRunnable) {
        return service.submit(paramRunnable);
    }
}
