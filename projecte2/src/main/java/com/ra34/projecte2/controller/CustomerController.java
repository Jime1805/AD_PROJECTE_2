package com.ra34.projecte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ra34.projecte2.dto.AddressRequestDTO;
import com.ra34.projecte2.dto.CustomerDTO;
import com.ra34.projecte2.dto.ErrorDTO;
import com.ra34.projecte2.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // POST /api/customer/{id}/adreces — afegeix direccions a un customer (Integrant 2 - 3a)
    @PostMapping("/customer/{id}/adreces")
    public ResponseEntity<?> addAddressesToCustomer(
            @PathVariable Long id,
            @RequestBody List<AddressRequestDTO> addresses) {

        CustomerDTO updated = customerService.addAddressesToCustomer(id, addresses);

        if (updated == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(404, "Customer no trobat amb id: " + id));
        }

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    // GET /api/customer/{id} — retorna la informació d'un customer (Integrant 2 - 3b)
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        CustomerDTO customer = customerService.getCustomerById(id);

        if (customer == null) {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorDTO(404, "Customer no trobat amb id: " + id));
        }

        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }
}