package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.constant.Status;
import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import com.beanmapper.mapper.mapper.mapstruct.util.TokenMapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = {TokenMapper.class})
public interface UserRequestToUserConverter {

    @Mappings({
            @Mapping(source = "userRequest", target = "company", qualifiedByName = "companyMapper")
    })
    User userRequestToUser(UserRequest userRequest);

    List<User> userRequestToUserList(List<UserRequest> userRequest);

    @AfterMapping
    default void initializeStatus(@MappingTarget User user) {
        user.setStatus(Status.ACTIVE);
    }

    @Named("companyMapper")
    default String mapCompany(UserRequest userRequest ) {
        return userRequest.getCompany() + " Company";
    }
}
