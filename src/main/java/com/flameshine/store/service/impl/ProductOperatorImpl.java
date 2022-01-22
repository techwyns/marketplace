package com.flameshine.store.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.flameshine.store.service.ProductOperator;
import com.flameshine.store.repository.ProductRepository;
import com.flameshine.store.entity.Product;

/**
 * Implementation of {@link com.flameshine.store.service.ProductOperator}.
 */

@Service
@Transactional
public class ProductOperatorImpl implements ProductOperator {

    private final ProductRepository repository;

    @Autowired
    public ProductOperatorImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Product> findAllPageable(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }
}