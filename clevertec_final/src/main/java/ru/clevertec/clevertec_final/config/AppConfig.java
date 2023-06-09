package ru.clevertec.clevertec_final.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import reactor.netty.tcp.TcpClient;
import ru.clevertec.clevertec_final.security.UserDetailsUser;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
/**
 * Configuration class for the application.
 */
@Configuration
public class AppConfig {

    /**
     * Base URL for the application's users.
     */
    @Value("${app.users.path}")
    private String BASE_URL;

    /**
     * Request timeout value in milliseconds.
     */
    @Value("${app.reqTimeOut}")
    public int TIMEOUT;

    /**
     * Creates a WebClient bean with timeout settings.
     *
     * @return the configured WebClient
     */
    @Bean
    public WebClient webClientWithTimeout() {
        final var tcpClient = TcpClient
                .create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
                .doOnConnected(connection -> {
                    connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                    connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                });

        return WebClient.builder()
                .baseUrl(BASE_URL)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.from(tcpClient)))
                .build();
    }

    /**
     * Provides the name of the current auditor for auditing purposes.
     *
     * @return the auditor name provider
     */
    @Bean
    public AuditorAware<String> auditorNameProvider() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(authentication -> (UserDetails) authentication.getPrincipal())
                .map(UserDetails::getUsername);
    }

}
