package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.constant.Status;
import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import com.beanmapper.mapper.mapper.mapstruct.util.TokenMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class UserRequestToUserConverterTest {

    @Spy
    private TokenMapper tokenMapper;

    @InjectMocks
    private UserRequestToUserConverter userRequestToUserConverter = Mappers.getMapper(UserRequestToUserConverter.class);

    @Test
    public void should_convert_user_request_to_user(){
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setLastName("lastname");
        userRequest.setFirstName("firstname");
        userRequest.setToken(1L);
        userRequest.setCompany("iyzico");
        userRequest.setUsername("username");

        //when
        User user = userRequestToUserConverter.userRequestToUser(userRequest);

        //then
        assertEquals("username", user.getUsername());
        assertEquals("iyzico Company", user.getCompany());
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals("1",user.getToken());
        assertEquals(Status.ACTIVE, user.getStatus());
    }

    @Test
    public void should_convert_user_request_list_to_user_list(){
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setLastName("lastname");
        userRequest.setFirstName("firstname");
        userRequest.setToken(1L);
        userRequest.setCompany("iyzico");
        userRequest.setUsername("username");
        List<UserRequest> userRequests = List.of(userRequest);

        //when
        List<User> users = userRequestToUserConverter.userRequestToUserList(userRequests);

        //then
        User user = users.get(0);
        assertEquals(1,users.size());
        assertNotNull(user);
        assertEquals("username", user.getUsername());
        assertEquals("iyzico Company", user.getCompany());
        assertEquals("firstname", user.getFirstName());
        assertEquals("lastname", user.getLastName());
        assertEquals("1",user.getToken());
        assertEquals(Status.ACTIVE, user.getStatus());
    }
}