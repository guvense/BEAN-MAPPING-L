package com.beanmapper.mapper.dto.response;

import com.beanmapper.mapper.constant.AccountType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    public String countryName;
    public AccountType accountType;
}
