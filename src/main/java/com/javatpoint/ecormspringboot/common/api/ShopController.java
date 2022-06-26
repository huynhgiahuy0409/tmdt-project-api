package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.ShopDTO;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/shop")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ObjectMapperUtils om;

    @GetMapping("user/{userId}")
    public ResponseEntity<ShopDTO> findShopByUserId(@PathVariable long userId){
        UserEntity userEntity = this.userService.findById(userId);
        ShopEntity shopEntity = userEntity.getShop();
        ShopDTO result = this.om.map(shopEntity, ShopDTO.class);
        return ResponseEntity.ok(result);
    }
}
