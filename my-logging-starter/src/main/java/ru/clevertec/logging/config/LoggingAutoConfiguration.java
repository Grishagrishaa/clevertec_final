package ru.clevertec.logging.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.event.Level;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.clevertec.logging.aop.ApplicationLogging;
import ru.clevertec.logging.aop.CommonPointcuts;
import ru.clevertec.logging.aop.ControllersLogging;

@Slf4j
@AutoConfiguration
@EnableConfigurationProperties(LoggingProperties.class)
@ConditionalOnProperty(prefix = "app.my.logger", name = "enabled", havingValue = "true")
public class LoggingAutoConfiguration {


    @Bean
    @ConditionalOnMissingBean
    public ApplicationLogging applicationLogging(){
        return new ApplicationLogging();
    }

    @Bean
    @ConditionalOnMissingBean
    public CommonPointcuts commonPointcuts(){
        return new CommonPointcuts();
    }

    @Bean
    @ConditionalOnMissingBean
    public ControllersLogging controllersLogging(){
        return new ControllersLogging();
    }
}
