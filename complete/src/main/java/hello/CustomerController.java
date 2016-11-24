package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class CustomerController {

    private static final String template = "Hello, %s!";

    private @Inject CustomerRepository repository;

    @RequestMapping(value = "/customer/{id}")
    public Customer employee(@PathVariable String id) {
        return repository.findOne(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer employeeByName(@RequestParam(value="name", defaultValue="alice") String name) {
        return repository.findByFirstNameIgnoreCase(name);
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST)
    ResponseEntity<?> add(@RequestBody Customer input) {
        System.out.println(input);
        Customer x = this.repository.save(input);
        System.out.println(x);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

}

