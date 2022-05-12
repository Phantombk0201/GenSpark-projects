package org.genspark;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.genspark")
public class AppConfig {

    @Bean
    Integer id(){return 627;}

    @Bean
    String name(){return "Leroy";}

    @Bean
    List<Phone> phones(){
        List<Phone> number = new ArrayList<>();
        number.add(new Phone("(337)335-8911"));
        return number;
    }
    
    @Bean
    Address address(){ return new Address("Kokaua","Hawaii","USA","96703");}
}
