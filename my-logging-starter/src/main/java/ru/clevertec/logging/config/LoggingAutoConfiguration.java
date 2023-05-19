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

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Auto-configuration class for logging.
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(LoggingProperties.class)
@ConditionalOnProperty(prefix = "app.my.logger", name = "enabled", havingValue = "true")
public class LoggingAutoConfiguration {

    /**
     * Creates the ApplicationLogging bean if it's missing.
     *
     * @return the ApplicationLogging bean
     */
    @Bean
    @ConditionalOnMissingBean
    public ApplicationLogging applicationLogging() {
        return new ApplicationLogging();
    }

    /**
     * Creates the CommonPointcuts bean if it's missing.
     *
     * @return the CommonPointcuts bean
     */
    @Bean
    @ConditionalOnMissingBean
    public CommonPointcuts commonPointcuts() {
        return new CommonPointcuts();
    }

    /**
     * Creates the ControllersLogging bean if it's missing.
     *
     * @return the ControllersLogging bean
     */
    @Bean
    @ConditionalOnMissingBean
    public ControllersLogging controllersLogging() {
        return new ControllersLogging();
    }
}
