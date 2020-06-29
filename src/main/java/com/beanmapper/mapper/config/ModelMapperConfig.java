package com.beanmapper.mapper.config;

import com.beanmapper.mapper.dto.request.UserRequest;
import com.beanmapper.mapper.entity.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {

        Converter<String, String> convertCompany = new AbstractConverter<>() {
            protected String convert(String source) {
                return source == null ? null : String.join(" ",source,"Company");
            }
        };

        Converter<String, String> convertCompanyLambda =
                source -> source == null ? null : String.join(" ",source.getSource(),"Company");


        ModelMapper modelMapper = new ModelMapper();

        TypeMap<UserRequest, User> typeMap =
                modelMapper.createTypeMap(UserRequest.class, User.class);
        typeMap.addMapping(UserRequest::getCity, User::setAddress);

        typeMap.addMappings(mapper -> {
            mapper .using(convertCompany)
                   .map(UserRequest::getCompany, User::setCompany);
        });
        return modelMapper;
    }
}
