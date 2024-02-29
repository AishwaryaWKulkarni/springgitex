package com.csi.service;

import com.csi.model.Customer;
import com.csi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepositoryImpl;

    public Customer signUp(Customer customer) {
        return customerRepositoryImpl.save(customer);
    }

    public boolean signIn(String custEmailId, String custPassword) {
        boolean flag = false;

        Customer customer = customerRepositoryImpl.findByCustEmailIdAndCustPassword(custEmailId, custPassword);

        if (customer != null && customer.getCustEmailId().equals(custEmailId) && customer.getCustPassword().equals(custPassword)) {
            flag = true;
        }

        return flag;
    }

    public Customer findbyContactNo(long custContactNo) {
        return customerRepositoryImpl.findByCustContactNo(custContactNo);

    }

    public Optional<Customer> findById(int custId) {
        return customerRepositoryImpl.findById(custId);
    }

    public List<Customer> findAll() {
        return customerRepositoryImpl.findAll();
    }

    public Customer update(Customer customer) {
        return customerRepositoryImpl.save(customer);
    }

    public void deleteById(int custId) {
        customerRepositoryImpl.deleteById(custId);
    }



}


