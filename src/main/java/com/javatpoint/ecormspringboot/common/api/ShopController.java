package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.ShopDTO;
import com.javatpoint.ecormspringboot.common.entity.ShopEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.service.IShopService;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.service.imp.VerifyDigitalBillService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Transactional
@CrossOrigin(origins = "http://localhost:4200")
public class ShopController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IShopService shopService;

    @Autowired
    private VerifyDigitalBillService verifyDigitalBillService;

    @Autowired
    private ObjectMapperUtils om;

    @GetMapping("/shop/user/{userId}")
    public ResponseEntity<ShopDTO> findShopByUserId(@PathVariable long userId){
        UserEntity userEntity = this.userService.findById(userId);
        ShopEntity shopEntity = userEntity.getShop();
        ShopDTO result = this.om.map(shopEntity, ShopDTO.class);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/shop/{shopId}")
    public ResponseEntity<ShopDTO> findShopById(@PathVariable long shopId){
        ShopEntity shopEntity = shopService.findOne(shopId);
        ShopDTO result = this.om.map(shopEntity, ShopDTO.class);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/search/{shopName}/shop")
    public ResponseEntity<List<ShopDTO>> findShopByShopName(@PathVariable String shopName) throws IOException {
        List<ShopEntity> foundShopEntities = this.shopService.findByNameContaining(shopName);
        System.out.println(verifyDigitalBillService.findDigitalBillPath("filename"));
        return ResponseEntity.ok(this.om.mapAll(foundShopEntities, ShopDTO.class));
    }
}
