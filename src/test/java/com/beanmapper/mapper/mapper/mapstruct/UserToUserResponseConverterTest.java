package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.constant.AccountType;
import com.beanmapper.mapper.dto.response.UserResponse;
import com.beanmapper.mapper.entity.User;
import com.beanmapper.mapper.service.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserToUserResponseConverterTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private UserToUserResponseConverter userToUserResponseConverter = Mappers.getMapper(UserToUserResponseConverter.class);

    @Test
    public void should_convert_user_to_user_response() {
        //given
        String turkeyCountyId = "1";
        User user = new User();
        user.setLastName("lastname");
        user.setFirstName("firstname");
        user.setCompany("Iyzico Company");
        user.setCountryId(turkeyCountyId);

        when(countryService.retrieveCountryNameFromId(turkeyCountyId)).thenReturn("Turkey");

        //when
        UserResponse userResponse = userToUserResponseConverter.userToUserResponse(user, AccountType.BUYYER);

        assertEquals("Turkey", userResponse.getCountryName());
        assertEquals(AccountType.BUYYER, userResponse.getAccountType());
        assertEquals("firstname", userResponse.getFirstName());
        assertEquals("lastname", userResponse.getLastName());
        assertEquals("Iyzico Company", userResponse.getCompany());
    }
}