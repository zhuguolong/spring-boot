package com.zhu.springboot.threadpoolexecutor;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author zhugu
 * @version 1.0
 * @Date 2019/4/29 9:30
 */
public class ThreadPoolExecutorQuestion {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Set<Thread> threadContainer = new HashSet<>();
        setThreadFactory(executorService, threadContainer);

        for (int i = 0; i < 9; i++) {
            executorService.submit(() -> {
            });
        }

        // 线程池等待3秒
        executorService.awaitTermination(3, TimeUnit.MILLISECONDS);

        threadContainer.stream()
                .filter(Thread::isAlive)
                .forEach(thread -> {
            System.out.println("线程池创建的线程：" + thread);
        });

        // 关闭线程池
        executorService.shutdown();
    }

    private static void setThreadFactory(ExecutorService executorService, Set<Thread> threadContainer) {
        if (executorService instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
            ThreadFactory oldThreadFactory = threadPoolExecutor.getThreadFactory();
            threadPoolExecutor.setThreadFactory(new DelegatingThreadFactory(oldThreadFactory, threadContainer));
        }
    }

    private static class DelegatingThreadFactory implements ThreadFactory {

        private final ThreadFactory delegate;
        private final Set<Thread> threadContainer;

        private DelegatingThreadFactory(ThreadFactory delegate, Set<Thread> threadContainer) {
            this.delegate = delegate;
            this.threadContainer = threadContainer;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = delegate.newThread(r);
            threadContainer.add(thread);
            return thread;
        }
    }
}
