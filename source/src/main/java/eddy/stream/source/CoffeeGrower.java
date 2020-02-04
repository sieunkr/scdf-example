package eddy.stream.source;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.function.Supplier;

@Configuration
@EnableScheduling
class CoffeeGrower {
    private final CoffeeGenerator generator;

    CoffeeGrower(CoffeeGenerator generator) {
        this.generator = generator;
    }

    @Scheduled(fixedRate = 1000)
    @Bean
    Supplier<WholesaleCoffee> sendCoffee() {
        return generator::generate;
    }
}