package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import com.beanmapper.mapper.mapper.mapstruct.util.TokenMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T23:22:09+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
@Component
public class UserRequestToUserConverterImpl implements UserRequestToUserConverter {

    @Autowired
    private TokenMapper tokenMapper;

    @Override
    public User userRequestToUser(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setCompany( mapCompany( userRequest ) );
        user.setUsername( userRequest.getUsername() );
        user.setFirstName( userRequest.getFirstName() );
        user.setLastName( userRequest.getLastName() );
        user.setToken( tokenMapper.asString( userRequest.getToken() ) );

        initializeStatus( user );

        return user;
    }

    @Override
    public List<User> userRequestToUserList(List<UserRequest> userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userRequest.size() );
        for ( UserRequest userRequest1 : userRequest ) {
            list.add( userRequestToUser( userRequest1 ) );
        }

        return list;
    }
}
