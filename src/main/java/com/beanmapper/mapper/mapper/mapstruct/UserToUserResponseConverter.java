package com.beanmapper.mapper.mapper.mapstruct;

import com.beanmapper.mapper.constant.AccountType;
import com.beanmapper.mapper.dto.response.UserResponse;
import com.beanmapper.mapper.entity.User;
import com.beanmapper.mapper.service.CountryService;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE,
        componentModel = "spring")
public abstract class UserToUserResponseConverter {

    @Autowired
    protected CountryService countryService;

    @Mappings({
            @Mapping(target = "countryName", expression = "java(countryService.retrieveCountryNameFromId(user.getCountryId()))"),
    })
    abstract UserResponse userToUserResponse(User user, @Context AccountType accountType);

    @AfterMapping
    void initializeStatus(@MappingTarget UserResponse userResponse, @Context AccountType accountType) {
        userResponse.setAccountType(accountType);
    }
}
