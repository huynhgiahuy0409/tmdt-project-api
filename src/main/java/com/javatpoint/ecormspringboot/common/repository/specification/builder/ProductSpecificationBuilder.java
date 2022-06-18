package com.javatpoint.ecormspringboot.common.repository.specification.builder;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.repository.specification.ProductSpecification;
import com.javatpoint.ecormspringboot.common.repository.specification.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductSpecificationBuilder {
    private List<SearchCriteria> params;

    public ProductSpecificationBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
    public ProductSpecificationBuilder with(String key, Object value, String operator){
        params.add(new SearchCriteria(key, value, operator));
        return this;
    }
    public Specification<ProductEntity> build() {
        if (params.size() == 0) {
            return null;
        }
        List<Specification<ProductEntity>> specs = params.stream().map(ProductSpecification::new)
                .collect(Collectors.toList());
        Specification<ProductEntity> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            result = Specifications.where(result).and(specs.get(i));
        }
        return result;
    }
}
