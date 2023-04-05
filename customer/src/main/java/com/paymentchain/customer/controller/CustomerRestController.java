package com.paymentchain.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paymentchain.customer.entities.Customer;
import com.paymentchain.customer.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping()
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id) {
        Optional<Customer> find = customerRepository.findById(id);
        Customer found = new Customer();
        if (find.isPresent()) {
            found = find.get();
        }
        return found;
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody Customer input) {
        input.getProducts().forEach(producto -> producto.setCustomer(input));
        Customer save = customerRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Customer input) {
        Customer save = customerRepository.save(input);
        return ResponseEntity.ok(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Customer> find = customerRepository.findById(id);
        if (find.isPresent()) {
            customerRepository.delete(find.get());
        }
        return ResponseEntity.ok().build();
    }

}
