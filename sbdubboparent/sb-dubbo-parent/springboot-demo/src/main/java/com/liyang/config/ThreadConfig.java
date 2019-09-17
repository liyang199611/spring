package com.liyang.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * java 线程池的配置
 */
@Configuration()
@EnableAsync(proxyTargetClass = true)//利用@EnableAsync注解开启异步任务支持
public class ThreadConfig {
    @Value("10")
    private int corePoolSize;//核心线程数

    @Value("100")
    private int maxPoolSize;//最大线程数

    @Value("1000")
    private int queueCapacity;//队列最大长度

    @Value("300")
    private int keepAliveSeconds;//线程池维护线程所允许的空闲时间

    private ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();//线程池对拒绝任务(无线程可用)的处理策略

    // 给线程定义前缀名字
    private String threadNamePrefix = "AsyncExecutorThread-";


    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setRejectedExecutionHandler(callerRunsPolicy);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(callerRunsPolicy);
        executor.initialize();
        return executor;
    }
}
