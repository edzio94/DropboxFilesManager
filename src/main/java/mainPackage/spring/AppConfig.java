package mainPackage.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lukasz on 12.12.15.
 */
@Configuration
@ComponentScan(basePackages = "mainPackage")
@EnableWebMvc
@EnableAsync
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor()
    {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();

        pool.setMaxPoolSize(100);
        pool.setCorePoolSize(10);
        //pool.setQueueCapacity(100);
        //pool.setKeepAliveSeconds(4);
        pool.setWaitForTasksToCompleteOnShutdown(true);


        return pool;
    }
}
