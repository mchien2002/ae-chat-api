package com.ae_chat.aechatapi.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import com.ae_chat.aechatapi.route.RouteConstant;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(RouteConstant.SERVER1).withSockJS();
    }
   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker(RouteConstant.TOPIC);
    registry.setApplicationDestinationPrefixes(RouteConstant.APP);
   } 

}
