package id.co.bcafinance.msthreadasync.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
@Slf4j
public class AsyncConfig implements AsyncConfigurer {

    // Log executor
    @Value("${async.log.core-pool-size}")
    private int logCorePoolSize;
    @Value("${async.log.max-pool-size}")
    private int logMaxPoolSize;
    @Value("${async.log.queue-capacity}")
    private int logQueueCapacity;

    @Bean(name = "logExecutor")
    public Executor logExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(logCorePoolSize);
        executor.setMaxPoolSize(logMaxPoolSize);
        executor.setQueueCapacity(logQueueCapacity);
        executor.setThreadNamePrefix("LogExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (ex, method, params) ->
                log.error("Async error in method: {} with params {}", method.getName(), params, ex);
    }
}
