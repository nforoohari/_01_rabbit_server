package ir.digixo._01_rabbit_server.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class C01Init {

    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.queue}")
    private String queue;
    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    @Bean
    public TopicExchange getExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Queue getQueue() {
        return new Queue(queue);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(getQueue())
                .to(getExchange())
                .with(routingKey);
    }

}
