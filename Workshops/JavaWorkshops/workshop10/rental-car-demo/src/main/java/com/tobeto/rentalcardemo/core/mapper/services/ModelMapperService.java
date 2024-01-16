package com.tobeto.rentalcardemo.core.mapper.services;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();


}