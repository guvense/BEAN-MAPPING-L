package com.beanmapper.mapper.mapper.mapstruct.util;

import org.springframework.stereotype.Component;

@Component
public class TokenMapper {
    public String asString(Long token) {
        return token == null ? null : token.toString();
    }
}
