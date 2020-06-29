package com.beanmapper.mapper.mapper.factory;

import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaticFactoryConverter {

    //static factory method
    public User convertUserRequestToUser(UserRequest userRequest) {
        return User.createUser(userRequest.getUsername(),userRequest.getFirstName(),userRequest.getLastName());
    }
    public User convertUserRequestToUserWithCompany(UserRequest userRequest) {
        return User.createUserWithCompany(userRequest.getUsername(),userRequest.getFirstName(),userRequest.getLastName(), userRequest.getCompany());
    }
}
