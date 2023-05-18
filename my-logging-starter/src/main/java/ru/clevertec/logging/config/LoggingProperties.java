package ru.clevertec.logging.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Slf4j
@NoArgsConstructor
@ConfigurationProperties(prefix = "app.my.logger")
public class LoggingProperties {
    /*
    to enable logging
     */
    private boolean enabled;

}
