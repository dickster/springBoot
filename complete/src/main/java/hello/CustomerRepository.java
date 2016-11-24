package hello;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public Customer findByFirstNameIgnoreCase(String firstName);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findByLastNameIgnoreCase(String lastName);

}
