package com.brovada;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;



@SpringBootApplication
public class Application implements CommandLineRunner {

	@Inject
	private QuoteRepository quoteRepository;
	@Inject
	private BrokerRepository brokerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		quoteRepository.deleteAll();

		quoteRepository.save(new Quote("Alice", "Smith"));
		quoteRepository.save(new Quote("Bob", "Smith"));
		quoteRepository.save(new Quote("Bill", "Jones"));
		quoteRepository.save(new Quote("John", "Doe"));
		quoteRepository.save(new Quote("Sally", "Smith"));
		quoteRepository.save(new Quote("Alice", "Hearth"));

        brokerRepository.save(new Broker("Prince", "Fielder"));
        brokerRepository.save(new Broker("Elvis", "Presley"));
        brokerRepository.save(new Broker("Samuel", "Johnson"));
        brokerRepository.save(new Broker("Betty", "Crocker"));
        brokerRepository.save(new Broker("Patti", "Peppermint"));
        brokerRepository.save(new Broker("Lucy", "Ball"));

        System.out.println("Brokers found with findAll():");
        System.out.println("-------------------------------");
        for (Broker broker : brokerRepository.findAll()) {
            System.out.println(broker);
        }
        System.out.println();

	}

}
