package com.brovada;

import com.google.common.collect.Lists;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface BrokerRepository extends MongoRepository<Broker, String>, QueryDslPredicateExecutor<Broker> {

    public Broker findByFirstName(String firstName);
    public Broker findByFirstNameIgnoreCase(String firstName);
    public List<Broker> findByLastName(String lastName);
    public List<Broker> findByLastNameIgnoreCase(String lastName);
    public List<Broker> findTop30ByLastName(String lastName);

    default public List<Broker> find(String name) {
        QBroker broker = new QBroker("x");

        if (name!=null && name.length()>0) {
            Iterable<Broker> result = findAll(
                    broker.firstName.containsIgnoreCase(name).
                            or(broker.lastName.containsIgnoreCase(name))
            );
            return Lists.newArrayList(result);
        }
        else {
            return Lists.newArrayList();
        }
    }

}
