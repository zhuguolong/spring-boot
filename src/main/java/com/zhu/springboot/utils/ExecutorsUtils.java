package com.zhu.springboot.utils;

import java.util.concurrent.*;

/**
 * 线程池
 * 1、提交一个任务，线程池里存活的核心线程数小于线程数corePoolSize时，线程池会创建一个核心线程去处理提交的任务。
 * 2、如果线程池核心线程数已满，即线程数已经等于corePoolSize，一个新提交的任务，会被放进任务队列workQueue排队等待执行。
 * 3、当线程池里面存活的线程数已经等于corePoolSize了,并且任务队列workQueue也满，判断线程数是否达到maximumPoolSize，
 *    即最大线程数是否已满，如果没到达，创建一个非核心线程执行提交的任务。
 * 4、如果当前的线程数达到了maximumPoolSize，还有新的任务过来的话，直接采用拒绝策略处理。
 *
 * 作者：Jay_huaxiao
 * 链接：https://juejin.im/post/5d1882b1f265da1ba84aa676
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ExecutorsUtils {
    // 核心线程数
    private static final Integer MIN_THREAD_NUM = 5;
    // 非核心线程数
    private static final Integer MAN_THREAD_NUM = 40;

    /**
     * @param corePoolSize 核心线程数
     * @param maximumPoolSize 非核心线程数
     * @param keepAliveTime 空闲的非核心线程存活时间
     * @param unit 非核心线程空闲存活时间单位
     * @param workQueue 存放任务的阻塞队列
     * @param handler 线城池的饱和策略事件，主要有四种类型：
     * AbortPolicy(抛出一个异常，默认的)
     * DiscardPolicy(直接丢弃任务)
     * DiscardOldestPolicy（丢弃队列里最老的任务，将当前这个任务继续提交给线程池）
     * CallerRunsPolicy（交给线程池调用所在的线程进行处理)
     */
    private static ThreadPoolExecutor service = new ThreadPoolExecutor(MIN_THREAD_NUM,
            MAN_THREAD_NUM,
            5,
            TimeUnit.SECONDS,
            new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy() {
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
