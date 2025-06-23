package ir.digixo._01_rabbit_server.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class C03MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    public C03MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Object payload,String exchange,String routingKey) {
        rabbitTemplate.convertAndSend(exchange,routingKey,payload);
    }
}
