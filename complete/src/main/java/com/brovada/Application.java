package com.brovada;

import com.brovada.document.Broker;
import com.brovada.document.Form;
import com.brovada.document.Quote;
import com.brovada.document.Component;
import com.brovada.document.Label;
import com.brovada.document.Panel;
import com.brovada.document.TextField;
import com.brovada.repository.BrokerRepository;
import com.brovada.repository.FormRepository;
import com.brovada.repository.QuoteRepository;
import com.google.common.collect.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.inject.Inject;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Inject
	private QuoteRepository quoteRepository;
	@Inject
	private BrokerRepository brokerRepository;
    @Inject
    private FormRepository formRepository;

    public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
	public void run(String... args) throws Exception {

        initDb();

        System.out.println("Brokers found with findAll():");
        System.out.println("-------------------------------");
        for (Broker broker : brokerRepository.findAll()) {
            System.out.println(broker);
        }
        System.out.println();
        System.out.println("Forms found with findAll():");
        System.out.println("-------------------------------");
        for (Form form : formRepository.findAll()) {
            System.out.println(form);
        }
        System.out.println();
	}

    private void initDb() {
        quoteRepository.deleteAll();

        quoteRepository.save(new Quote("Alice", "Smith"));
        quoteRepository.save(new Quote("Bob", "Smith"));
        quoteRepository.save(new Quote("Bill", "Jones"));
        quoteRepository.save(new Quote("John", "Doe"));
        quoteRepository.save(new Quote("Sally", "Smith"));
        quoteRepository.save(new Quote("Alice", "Hearth"));

        brokerRepository.deleteAll();
        brokerRepository.save(new Broker("Prince", "Fielder"));
        brokerRepository.save(new Broker("Elvis", "Presley"));
        brokerRepository.save(new Broker("Samuel", "Johnson"));
        brokerRepository.save(new Broker("Betty", "Crocker"));
        brokerRepository.save(new Broker("Patti", "Peppermint"));
        brokerRepository.save(new Broker("Lucy", "Ball"));

        formRepository.deleteAll();

        List<Component> children = Lists.newArrayList(
                new Label("name"),
                new TextField("name.first"),
                new Panel().withChildren(
                        Lists.newArrayList(new Label("subpanel"))
                )
        );

        Form f = new Form()
                .withVersion(1, 0)
                .withChildren(children)
                .withLabel("test form");

        formRepository.save(f);

    }

}
