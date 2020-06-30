package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.constant.AccountType;
import com.beanmapper.mapper.dto.response.UserResponse;
import com.beanmapper.mapper.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-30T23:22:09+0300",
    comments = "version: 1.3.0.Beta2, compiler: javac, environment: Java 11.0.3 (JetBrains s.r.o)"
)
@Component
public class UserToUserResponseConverterImpl extends UserToUserResponseConverter {

    @Override
    UserResponse userToUserResponse(User user, AccountType accountType) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        userResponse.setUsername( user.getUsername() );
        userResponse.setFirstName( user.getFirstName() );
        userResponse.setLastName( user.getLastName() );
        userResponse.setCompany( user.getCompany() );

        userResponse.setCountryName( countryService.retrieveCountryNameFromId(user.getCountryId()) );

        initializeStatus( userResponse, accountType );

        return userResponse;
    }
}
