package com.beanmapper.mapper.mapper.java.beans;

import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import org.springframework.stereotype.Component;

@Component
public class BeanConventionConverter {

    // Java beans convention
    public User convertWithCompany(UserRequest userRequest) {
        User user =  new User();
        user.setCompany(userRequest.getCompany());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setUsername(userRequest.getUsername());
        return user;
    }
}
