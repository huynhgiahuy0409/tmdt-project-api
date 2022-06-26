package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.buyer.products.model.Product;
import com.javatpoint.ecormspringboot.common.dto.CartDTO;
import com.javatpoint.ecormspringboot.common.dto.PendingItemDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.*;
import com.javatpoint.ecormspringboot.common.request.PendingItemRequest;
import com.javatpoint.ecormspringboot.common.service.*;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import javax.xml.ws.Response;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/cart")
@Transactional
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
    private ICartItemService cartItemService;
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

    @PostMapping("/{cartId}/cartItem")
    private ResponseEntity<CartDTO> flushCart(@PathVariable long cartId, @RequestBody PendingItemRequest pendingItemRequest) {
        /* targer: edit PendingItem in CartItem*/
        try {
            ProductEntity foundRequestProduct = this.productService.findById(pendingItemRequest.getProductId());
            ShopEntity shopEntity = foundRequestProduct.getShop();
            CartEntity cartEntity = this.cartService.findById(cartId);
            CartItemEntity cartItemEntity = this.cartItemService.findByCartAndShop(cartEntity, shopEntity);
            if (cartItemEntity != null) {
                PendingItemEntity foundPendingItem = this.pendingItemService.findByCartItemAndProduct(cartItemEntity, foundRequestProduct);
                if (foundPendingItem != null) {
                    foundPendingItem.setQuantity(foundPendingItem.getQuantity() + pendingItemRequest.getQuantity());
                } else {
                    foundPendingItem = new PendingItemEntity();
                    foundPendingItem.setProduct(foundRequestProduct);
                    foundPendingItem.setQuantity(pendingItemRequest.getQuantity());
                    foundPendingItem.setCartItem(cartItemEntity);
                    cartItemEntity.getPendingItems().add(foundPendingItem);
                }
                this.pendingItemService.save(foundPendingItem);
            } else {
                System.out.println("not exist cart item");
                cartItemEntity = new CartItemEntity();
                cartItemEntity.setShop(shopEntity);
                cartItemEntity.setCart(cartEntity);
                PendingItemEntity pendingItem = new PendingItemEntity();
                pendingItem.setProduct(foundRequestProduct);
                pendingItem.setQuantity(pendingItemRequest.getQuantity());
                pendingItem.setCartItem(cartItemEntity);
                cartItemEntity.getPendingItems().add(pendingItem);
                cartItemService.save(cartItemEntity);
            }
            CartEntity foundCartEntity = this.cartService.findById(cartEntity.getId());
            return ResponseEntity.ok(this.mp.map(foundCartEntity, CartDTO.class));
        }
        catch(Exception e) {
            //  Block of code to handle errors
            throw new RuntimeException("Error Occurred");
        }
    }
}
