package com.aafcj.checkin;

import com.aafcj.checkin.entity.Price;
import com.aafcj.checkin.repository.PriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CheckInApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckInApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PriceRepository repository) {
		return (args) -> {
			repository.saveAll(Arrays.asList(
					Price.builder().role(Role.GENERAL.toString()).place(Place.CABIN.toString()).fullPrice(860).build(),
					Price.builder().role(Role.ADVISOR.toString()).place(Place.CABIN.toString()).fullPrice(500).build(),
					Price.builder().role(Role.PASTOR.toString()).place(Place.CABIN.toString()).fullPrice(500).build(),
					Price.builder().role(Role.GENERAL.toString()).place(Place.CAMPING.toString()).fullPrice(750).build(),
					Price.builder().role(Role.USHER.toString()).place(Place.CABIN.toString()).fullPrice(660).build(),
					Price.builder().role(Role.GENERAL.toString()).place(Place.CAMPING.toString()).time(Time.LATE).fullPrice(550).build()
			));
		};
	}

}
