package hello.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.github.dozermapper.core.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hello.model.CustomerMo;
import hello.model.CustomerMoRepository;
import hello.moewller.Customer;
import hello.moewller.CustomerRepository;
import hello.view.Greeting;
import hello.view.CustomerView;


@RestController
public class GreetingController {

    @Autowired
    private Mapper mapper;

    @Autowired
    private CustomerRepository cRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/customers")
    public List<Customer> findAll() {
        List<Customer> target = new ArrayList<>();
        cRepository.findAll().forEach(target::add);
        return target;
    }

    @RequestMapping("/mapped-customers")
    public List<CustomerView> mappedFindAll() {
        List<CustomerView> target = new ArrayList<>();
        for (Customer c : cRepository.findAll()) {
            target.add(mapper.map(c, CustomerView.class));
        }
        return target;
    }
    
    @RequestMapping("/moewller-customers")
    public List<Customer> moewllerFindAll() {
        List<Customer> target = new ArrayList<>();
        cRepository.findAll().forEach(target::add);
        return target;
    }

}
