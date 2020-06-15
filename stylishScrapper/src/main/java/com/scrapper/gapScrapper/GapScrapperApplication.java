package com.scrapper.gapScrapper;

import com.scrapper.gapScrapper.services.Scrape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GapScrapperApplication implements CommandLineRunner {

	@Autowired
	Scrape scrape;

	public static void main(String[] args) {
		SpringApplication.run(GapScrapperApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		scrape.run();
	}
}
