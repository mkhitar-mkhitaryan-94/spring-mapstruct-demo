package com.example.springmapstructdemo.mapper;

import com.example.springmapstructdemo.dto.ProductDto;
import com.example.springmapstructdemo.model.Product;
import com.example.springmapstructdemo.validator.ProductValidationException;
import com.example.springmapstructdemo.validator.ProductValidator;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {ProductValidator.class}, componentModel = "spring")
public interface ProductMapper {


    ProductDto modelTODto(Product product) throws ProductValidationException;

    List<ProductDto> modelsTODto(List<Product> product) throws ProductValidationException;


    @InheritInverseConfiguration
    Product dtoTOModel(ProductDto productDto) throws ProductValidationException;

}
