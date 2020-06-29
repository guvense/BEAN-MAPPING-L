package com.beanmapper.mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    public String retrieveCountryNameFromId(String countyId)
    {
        return countyId + "Country";
    }
}
