package com.aafcj.checkin;

import com.aafcj.checkin.dto.CabinDTO;
import com.aafcj.checkin.dto.MemberDTO;
import com.aafcj.checkin.entity.CabinEntity;
import com.aafcj.checkin.entity.PriceEntity;
import com.aafcj.checkin.repository.CabinRepository;
import com.aafcj.checkin.repository.MemberRepository;
import com.aafcj.checkin.repository.PriceRepository;
import com.aafcj.checkin.service.CabinService;
import com.aafcj.checkin.service.MemberService;
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
	public CommandLineRunner preLoadedData(PriceRepository priceRepository, CabinService cabinService, MemberService memberService) {
		return (args) -> {
//			priceRepository.saveAll(Arrays.asList(
//					PriceEntity.builder().role(Role.GENERAL.toString()).place(Place.CABIN.toString()).time(Time.ON_TIME).fullPrice(860).build(),
//					PriceEntity.builder().role(Role.ADVISOR.toString()).place(Place.CABIN.toString()).time(Time.ON_TIME).fullPrice(500).build(),
//					PriceEntity.builder().role(Role.PASTOR.toString()).place(Place.CABIN.toString()).time(Time.ON_TIME).fullPrice(500).build(),
//					PriceEntity.builder().role(Role.GENERAL.toString()).place(Place.CAMPING.toString()).time(Time.ON_TIME).fullPrice(750).build(),
//					PriceEntity.builder().role(Role.USHER.toString()).place(Place.CABIN.toString()).time(Time.ON_TIME).fullPrice(660).build(),
//					PriceEntity.builder().role(Role.GENERAL.toString()).place(Place.CAMPING.toString()).time(Time.LATE).fullPrice(550).build()
//			));

			memberService.saveAll(Arrays.asList(
					MemberDTO.builder().name("Kevin").gender(Gender.MALE).lastName("Madrid").role(Role.GENERAL).build()
			));

			cabinService.saveAll(Arrays.asList(
					CabinDTO.builder().capacity(4).gender(Gender.MALE).name("A1").build(),
					CabinDTO.builder().capacity(6).gender(Gender.FEMALE).name("A2").build()
			));

		};
	}

}
