package ir.digixo._01_rabbit_server;

import ir.digixo._01_rabbit_server.config.C03MessageProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"ir.digixo._01_rabbit_server"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(C03MessageProducer c03MessageProducer) {
        return args -> {
            c03MessageProducer.sendMessage("Hello From Rabbit Message Producer", "myexchange", "mykey");
            System.out.println("The message was sent : Hello From Rabbit Message Producer");
        };
    }
}
