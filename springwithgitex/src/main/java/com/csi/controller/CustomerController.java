package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;


    @PostMapping("/signup")
    public ResponseEntity<Customer> signUp(@Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceImpl.signUp(customer), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{custEmailId}/{custPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String custEmailId, @PathVariable String custPassword) {
        return ResponseEntity.ok(customerServiceImpl.signIn(custEmailId, custPassword));
    }

    @GetMapping("/sortbycustaccbalance")
    public ResponseEntity<List<Customer>> sortByCustAccBalance() {
        return ResponseEntity.ok(customerServiceImpl.findAll().stream().sorted(Comparator.comparingDouble(Customer::getCustAccBalance)).toList());
    }

    @GetMapping("/findbyid/{custId}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.findById(custId));
    }

    @GetMapping("/findbycontactno/{custContactNo}")
    public ResponseEntity<Customer> findByContactNo(@PathVariable long custContactNo) {
        return ResponseEntity.ok(customerServiceImpl.findbyContactNo(custContactNo));
    }


    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerServiceImpl.findAll());
    }

    @PutMapping("/update/{custId}/{customer}")
    public ResponseEntity<Customer> update(@PathVariable int custId, @Valid @RequestBody Customer customer) {
        return new ResponseEntity<>(customerServiceImpl.update(customer), HttpStatus.CREATED);
    }


    @DeleteMapping("/deletebyid/{custId}")
    public ResponseEntity<String> deleteById(@PathVariable int custId) {
        customerServiceImpl.deleteById(custId);
        return ResponseEntity.ok("Data deleted Successfully");
    }
}
