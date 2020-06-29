package com.beanmapper.mapper.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String username;
    private String firstName;
    private String lastName;
    private String company;
    private String city;
    protected Long token;


}
