package com.javatpoint.ecormspringboot.common.dto;

import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.model.ShopUser;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class ShopDTO {
    private long id;
    private String name;
    private ImageDTO image;
    private ShopUser shopUser;
    private Set<ProductDTO> products;
}
