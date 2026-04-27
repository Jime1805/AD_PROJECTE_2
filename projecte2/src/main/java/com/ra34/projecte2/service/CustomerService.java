package com.ra34.projecte2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.dto.CustomerDTO;
import com.ra34.projecte2.mapper.CustomerMapper;
import com.ra34.projecte2.model.Customer;
import com.ra34.projecte2.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Transactional
    public CustomerDTO deleteAllAddresses(Long customerId) {
        Optional<Customer> found = customerRepository.findById(customerId);
        if (found.isEmpty()) {
            return null;
        }

        Customer customer = found.get();

        customer.getAddresses().clear();
        customerRepository.save(customer);

        return customerMapper.toDto(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }
}
