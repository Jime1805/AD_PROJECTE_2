package com.ra34.projecte2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra34.projecte2.dto.CustomerDTO;
import com.ra34.projecte2.dto.AddressRequestDTO;
import com.ra34.projecte2.mapper.AddressMapper;
import com.ra34.projecte2.mapper.CustomerMapper;
import com.ra34.projecte2.model.Address;
import com.ra34.projecte2.model.Customer;
import com.ra34.projecte2.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    AddressMapper addressMapper;

    @Transactional
    public CustomerDTO addAddressesToCustomer(Long customerId, List<AddressRequestDTO> addressRequests) {

        Optional<Customer> existing = customerRepository.findById(customerId);
        if (!existing.isPresent()) return null;

        Customer customer = existing.get();

        for (AddressRequestDTO addressRequest : addressRequests) {
            Address address = addressMapper.toEntity(addressRequest);
            address.setCustomer(customer);
            customer.getAddresses().add(address);
        }

        return customerMapper.toDto(customerRepository.save(customer));
    }

    public CustomerDTO getCustomerById(Long customerId) {
        Optional<Customer> existing = customerRepository.findById(customerId);
        if (!existing.isPresent()) return null;

        return customerMapper.toDto(existing.get());
    }
}