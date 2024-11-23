package cc.elvea.boot.configuration;

import cc.elvea.boot.system.commons.web.socket.DefaultWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Slf4j
@EnableWebSocket
@Configuration(proxyBeanMethods = false)
public class WebSocketAutoConfiguration implements WebSocketConfigurer {

    private final DefaultWebSocketHandler defaultWebSocketHandler;

    public WebSocketAutoConfiguration(DefaultWebSocketHandler defaultWebSocketHandler) {
        log.info("WebSocketAutoConfiguration is enabled.");
        this.defaultWebSocketHandler = defaultWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(@NonNull WebSocketHandlerRegistry registry) {
        registry.addHandler(defaultWebSocketHandler, "/ws/message")
                .setAllowedOrigins("*");
    }

}
