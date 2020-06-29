package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.constant.AccountType;
import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.dto.response.UserResponse;
import com.beanmapper.mapper.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MapStructMapper {

    private final UserRequestToUserConverter userRequestToUserConverter;

    private final UserToUserResponseConverter userToUserResponseConverter;

    public User convertToUser(UserRequest userRequest) {
        User user = userRequestToUserConverter.userRequestToUser(userRequest);
        return user;
    }

    public List<User> convertToUser(List<UserRequest> userRequest) {
        List<User> users = userRequestToUserConverter.userRequestToUserList(userRequest);
        return users;
    }

    public UserResponse convertToUserResponse(User user) {
        UserResponse userResponse = userToUserResponseConverter.userToUserResponse(user, AccountType.BUYYER);
        return userResponse;
    }
}
