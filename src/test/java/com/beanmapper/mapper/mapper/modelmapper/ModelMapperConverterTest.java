package com.beanmapper.mapper.mapper.modelmapper;

import com.beanmapper.mapper.config.ModelMapperConfig;
import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class ModelMapperConverterTest {

    private ModelMapper modelMapper;

    @Before
    public void setup(){
        Converter<String, String> markAsUser =
                source -> source == null ? null : String.join(" ",source.getSource(),"Company");
        modelMapper = new ModelMapper();

        TypeMap<UserRequest, User> typeMap =
                modelMapper.createTypeMap(UserRequest.class, User.class);
        typeMap.addMapping(UserRequest::getCity, User::setAddress);

        typeMap.addMappings(mapper -> {
            mapper .using(markAsUser)
                    .map(UserRequest::getCompany, User::setCompany);
        });
    }

    @Test
    public void should_convert_user_request_to_user_with_company(){
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("user");
        userRequest.setCity("istanbul");
        userRequest.setCompany("iyzico");
        userRequest.setFirstName("firstname");
        userRequest.setLastName("lastname");
        userRequest.setToken(1L);

        //when
        User user = modelMapper.map(userRequest, User.class);

        assertEquals("user", user.getUsername());
        assertEquals("istanbul", user.getAddress());
        assertEquals("iyzico Company", user.getCompany());
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals("1",user.getToken()); // It can understand from type
    }
}