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
import hello.view.CustomerView;


@RestController
public class CustomerController {

    @Autowired
    private Mapper mapper;

    @Autowired
    private CustomerMoRepository cMoRepository;

    @Autowired
    private CustomerRepository cRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/customers")
    public List<CustomerMo> findAll() {
        List<CustomerMo> target = new ArrayList<>();
        cMoRepository.findAll().forEach(target::add);
        return target;
    }

    @RequestMapping("/mapped-customers")
    public List<CustomerView> mappedFindAll() {
        List<CustomerView> target = new ArrayList<>();
        for (CustomerMo c : cMoRepository.findAll()) {
            target.add(mapper.map(c, CustomerView.class));
        }
        return target;
    }
    
    @RequestMapping("/moewller-customers")
    public List<Customer> moewllerFindAll() {
        List<Customer> target = new ArrayList<>();
        for (CustomerMo c : cMoRepository.findAll()) {
            target.add(mapper.map(c, Customer.class));
        }
        return target;
    }

}
