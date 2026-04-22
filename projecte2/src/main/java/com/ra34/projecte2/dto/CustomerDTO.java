package com.ra34.projecte2.dto;

import java.util.List;

public class CustomerDTO {

    private Long id;
    private String userEmail;
    private String firstName;
    private String lastName;
    private String phone;
    private List<AddressDTO> addresses;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String userEmail, String firstName, String lastName, String phone) {
        this.id = id;
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressDTO> addresses) {
        this.addresses = addresses;
    }
}
