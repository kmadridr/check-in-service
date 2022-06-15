package com.aafcj.checkin;

import com.aafcj.checkin.entity.Price;
import com.aafcj.checkin.repository.PriceRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

public class DataLoader {

    @Bean
    public ApplicationRunner initializer(PriceRepository priceRepository) {
        return args -> priceRepository.saveAll(Arrays.asList(
                Price.builder().role(Role.GENERAL.toString()).place(Place.CABIN.toString()).fullPrice(860).build(),
                Price.builder().role(Role.ADVISOR.toString()).place(Place.CABIN.toString()).fullPrice(500).build(),
                Price.builder().role(Role.PASTOR.toString()).place(Place.CABIN.toString()).fullPrice(500).build(),
                Price.builder().role(Role.GENERAL.toString()).place(Place.CAMPING.toString()).fullPrice(750).build(),
                Price.builder().role(Role.USHER.toString()).place(Place.CABIN.toString()).fullPrice(660).build(),
                Price.builder().role(Role.GENERAL.toString()).place(Place.CAMPING.toString()).time(Time.LATE).fullPrice(550).build()
                // Casa de campar 750
                // Pastor 500
                // Viernes 550 si apartado sino acampar o si hay lugares
                // Servicio namas 100 pesos
        ));
    }
}
