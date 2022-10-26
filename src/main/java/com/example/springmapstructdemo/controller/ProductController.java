package com.example.springmapstructdemo.controller;

import com.example.springmapstructdemo.dto.ProductDto;
import com.example.springmapstructdemo.mapper.ProductMapper;
import com.example.springmapstructdemo.model.Product;
import com.example.springmapstructdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productRepository.save(
                productMapper.dtoTOModel(productDto)), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> findAll() {
        return new ResponseEntity<>(productMapper.modelsTODto(productRepository.findAll()), HttpStatus.OK);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(productMapper.modelTODto(productRepository.findById(id).get()), HttpStatus.OK);

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Integer id) {
        ProductDto productDto = productMapper.modelTODto(productRepository.findById(id).get());
        productRepository.deleteById(productDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
