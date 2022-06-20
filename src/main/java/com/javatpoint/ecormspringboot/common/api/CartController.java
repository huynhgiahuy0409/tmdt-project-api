package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.buyer.products.model.Product;
import com.javatpoint.ecormspringboot.common.dto.CartDTO;
import com.javatpoint.ecormspringboot.common.dto.PendingItemDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.entity.ProductEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.request.PendingItemRequest;
import com.javatpoint.ecormspringboot.common.service.ICartService;
import com.javatpoint.ecormspringboot.common.service.IPendingItemService;
import com.javatpoint.ecormspringboot.common.service.IProductService;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICartService cartService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IPendingItemService pendingItemService;
    @Autowired
    private ObjectMapperUtils om;
    @Autowired
    private ModelMapper mp;
    @GetMapping()
    private ResponseEntity getCartByUserId(@RequestParam long userId) {
        UserEntity userEntity = this.userService.findById(userId);
        UserDTO userDTO = this.mp.map(userEntity, UserDTO.class);
        System.out.println(userDTO);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/add")
    private ResponseEntity<CartDTO> flushCart(@RequestBody PendingItemRequest pendingItemRequest){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity userEntity = this.userService.findByUsername(username);
        CartEntity cartEntity = userEntity.getCart();
        Set<PendingItemEntity> pendingItemEntities = cartEntity.getPendingOrders();
        pendingItemEntities.forEach(pendingItemEntity -> {
            if(pendingItemEntity.getProduct().getId() == pendingItemRequest.getProductId()){
                pendingItemEntity.setQuantity(pendingItemEntity.getQuantity() + pendingItemRequest.getQuantity());
                return;
            }
        });
        boolean isExist = pendingItemEntities.stream().anyMatch(pendingItemEntity -> pendingItemEntity.getProduct().getId() == pendingItemRequest.getProductId());
        if(isExist == false){
            ProductEntity p = this.productService.findById(pendingItemRequest.getProductId());
            PendingItemEntity pendingItem = new PendingItemEntity();
            pendingItem.setProduct(p);
            pendingItem.setQuantity(1);
            pendingItem.setCart(cartEntity);
            pendingItemEntities.add(pendingItem);
            cartEntity.setPendingOrders(pendingItemEntities);
        }
        CartEntity updatedCart = this.cartService.save(cartEntity);
        CartDTO result = this.om.map(updatedCart, CartDTO.class);
        return ResponseEntity.ok(result);
    }
}
