package com.javatpoint.ecormspringboot.common.repository.specification;

import com.javatpoint.ecormspringboot.buyer.products.model.Product;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.repository.specification.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class ProductSpecification implements Specification<ProductEntity> {
    private SearchCriteria criteria;

    public ProductSpecification(SearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        String param = this.criteria.getKey();
        String operator = this.criteria.getOperator();
        Object value = this.criteria.getValue();
        if(operator.equals("like")){
            System.out.println(operator);
            return criteriaBuilder.like(root.get(param),"%" + value.toString() + "%");
        }else if (operator.equals("in-equals")){
            Join<Product, Object> join = root.join(param);
            return criteriaBuilder.equal(join.get("id"),value);
        }else if (operator.equals("between")){
            Long[] ranges = (Long[]) value;
            long source =  ranges[0];
            long dest =  ranges[1];
            return criteriaBuilder.between(root.get(param), source, dest);
        }
        return null;
    }

}
