package org.genspark;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "org.genspark")
public class AppConfig {
    @Bean
    Integer getId() {return 627;}

    @Bean
    @Qualifier("name")
    String getName() {
        return "Leroy";
    }

    @Bean
    List<Phone> getPh() {
        List<Phone> number = new ArrayList<>();
        number.add(new Phone());
        number.get(0).setMob("(337)335-8911");
        return number;
    }

    @Bean
    Address getAdd() {
        return new Address();
    }

    @Bean(name = "getCity")
    String getCity() {
        return "Kokaua";
    }

    @Bean(name = "getState")
    String getState() {
        return "Hawaii";
    }

    @Bean(name = "getCountry")
    String getCountry() {
        return "USA";
    }

    @Bean(name = "getZip")
    String getZipCode() {
        return "96703";
    }
}
