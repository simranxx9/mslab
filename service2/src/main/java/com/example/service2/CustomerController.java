package com.example.service2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import java.util.List;
@RequestMapping("/customers")
@RestController
public class CustomerController {
    private final List<Customer> Customers = Arrays.asList(
            new Customer(1, 1, "Product A"),
            new Customer(2, 1, "Product B"),
            new Customer(3, 2, "Product C"),
            new Customer(4, 1, "Product D"),
            new Customer(5, 2, "Product E"));

    @GetMapping
    public List<Customer> getAllCustomers() {
        return Customers;
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return Customers.stream()
                     .filter(Customer -> Customer.getId() == id)
                     .findFirst()
                     .orElseThrow(IllegalArgumentException::new);
    }
}
