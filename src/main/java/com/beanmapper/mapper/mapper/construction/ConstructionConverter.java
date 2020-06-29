package com.beanmapper.mapper.mapper.construction;

import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ConstructionConverter {


    public User convert(UserRequest userRequest) {
        return new User(
                userRequest.getUsername(),
                userRequest.getFirstName(),
                userRequest.getLastName());
    }

    public User convertWithCompany(UserRequest userRequest) {
        return new User(
                userRequest.getUsername(),
                userRequest.getFirstName(),
                userRequest.getLastName(),
                userRequest.getCompany());
    }
}
