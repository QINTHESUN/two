package com.cp.subject.domain.config;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: q
 * @Description: TODO
 * @DateTime: 30/9/2024 上午 12:50
 **/
public class CustomNameThreadFactory implements ThreadFactory {
    //生成唯一的线程池编号
    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    //线程组，组织线程
    private final ThreadGroup group;
    //生成唯一的线程编号
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    //线程名称前缀
    private final String namePrefix;

    CustomNameThreadFactory(String name) {
        // 获取系统安全管理器
        SecurityManager s = System.getSecurityManager();
        // 设置线程组，如果有安全管理器，则使用安全管理器的线程组，否则使用当前线程的线程组
        group = (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
        if (StringUtils.isBlank(name)) {
            name = "pool";
        }
        namePrefix = name + "-" +
                poolNumber.getAndIncrement() +
                "-thread-";
    }

    @Override
    public Thread newThread(Runnable r) {
        // 创建一个新的线程，属于指定的线程组，运行指定的 Runnable 任务
        Thread t = new Thread(group, r,
                namePrefix + threadNumber.getAndIncrement(),
                0);
        // 如果新创建的线程是守护线程，则将其设置为非守护线程
        if (t.isDaemon()) {
            t.setDaemon(false);
        }
        // 如果新创建的线程优先级不是默认优先级，则将其设置为默认优先级
        if (t.getPriority() != Thread.NORM_PRIORITY) {
            t.setPriority(Thread.NORM_PRIORITY);
        }
        return t;
    }
}
