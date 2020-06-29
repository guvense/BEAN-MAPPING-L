package com.beanmapper.mapper.entity;

import com.beanmapper.mapper.constant.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Long id;
    private String username;
    private String firstName;
    private String company;
    private String lastName;
    private String address;
    private Status status;
    private String token;
    private String countryId;

    public static User createUser(String username,String firstName, String lastName) {
        return new User(username,firstName,lastName);
    }

    public static User createUserWithCompany(String username,String firstName, String lastName, String company) {
        return new User(username,firstName,lastName, company);
    }

    public User() { }


    // Telescoping Constructor
    public User(String username, String firstName, String lastName, String company) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.id = 1L;
    }

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = 1L;
    }

}

