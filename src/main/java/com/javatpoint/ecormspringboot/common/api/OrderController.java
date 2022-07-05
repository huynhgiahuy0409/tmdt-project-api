package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.ShopDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.*;
import com.javatpoint.ecormspringboot.common.request.OrderItemRequest;
import com.javatpoint.ecormspringboot.common.request.OrderRequest;
import com.javatpoint.ecormspringboot.common.service.IOrderService;
import com.javatpoint.ecormspringboot.common.service.IProductService;
import com.javatpoint.ecormspringboot.common.service.IShopService;
import com.javatpoint.ecormspringboot.common.service.IUserService;
import com.javatpoint.ecormspringboot.common.service.imp.UserService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import com.javatpoint.ecormspringboot.common.util.constance.SystemContance;
import com.javatpoint.ecormspringboot.response.OrderResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class OrderController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IShopService shopService;

    @Autowired
    private IProductService productService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ModelMapper mp;

    @Autowired
    private ObjectMapperUtils om;

    @PostMapping("/user/{userId}/order")
    @Transactional
    public ResponseEntity<Boolean> createOrder(@PathVariable long userId, @RequestBody OrderRequest orderRequest) throws IOException {
        this.mp.getConfiguration().setFieldMatchingEnabled(true);
        this.mp.getConfiguration().setAmbiguityIgnored(true);
        UserEntity foundUser = this.userService.findById(userId);
        OrderEntity newOrder = this.mp.map(orderRequest, OrderEntity.class);
        ShopEntity foundShopEntity = this.shopService.findOne(orderRequest.getShopId());
        newOrder.setShop(foundShopEntity);
        newOrder.setStatus("1");
        List<OrderItemEntity> orderItemEntityList = new ArrayList<OrderItemEntity>();
        for (OrderItemRequest orderItemRequest : orderRequest.getOrderItems()) {
            ProductEntity foundProduct = this.productService.findById(orderItemRequest.getProductId());
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setProduct(foundProduct);
            orderItemEntity.setQuantity(orderItemRequest.getQuantity());
            orderItemEntity.setOrder(newOrder);
            orderItemEntityList.add(orderItemEntity);
        }
        newOrder.setOrderItems(orderItemEntityList);
        newOrder.setUser(foundUser);
        OrderEntity savedOrder = this.orderService.save(newOrder);
        foundUser.getOrders().add(savedOrder);
        savedOrder.setDigitBillFilename(savedOrder.getId() + "digitalBill.txt");
        File digitalBill = new File("C:\\digital-bill\\" + savedOrder.getId() + "digitalBill.txt");
        OutputStreamWriter fos = new OutputStreamWriter (new FileOutputStream(digitalBill));
        fos.write(savedOrder.getId() + "");
        fos.flush();
        fos.close();
        return ResponseEntity.ok(true);
    }

    @GetMapping("/user/{userId}/order")
    @Transactional
    public ResponseEntity<List<OrderResponse>> findAll(@PathVariable long userId){
        List<OrderEntity> foundOrderEntities = this.orderService.findAll();
        List<OrderResponse> result = this.om.mapAll(foundOrderEntities, OrderResponse.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}/order/status/{status}")
    @Transactional
    public ResponseEntity<List<OrderResponse>> findAllByStatus(@PathVariable long userId, @PathVariable String status){
        List<OrderEntity> foundOrderEntities = this.orderService.findAllByStatus(status);
        List<OrderResponse> result = this.om.mapAll(foundOrderEntities, OrderResponse.class);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/shop/{shopId}/order/status/{status}")
    @Transactional
    public ResponseEntity<List<OrderResponse>> findAllByStatusAndShop(@PathVariable long shopId, @PathVariable String status){
        ShopEntity foundShopEntity = this.shopService.findOne(shopId);
        List<OrderEntity> foundOrderEntities = this.orderService.findAllByStatusAndShop(status, foundShopEntity);
        List<OrderResponse> result = this.om.mapAll(foundOrderEntities, OrderResponse.class);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/order/{orderId}/status/{status}")
    @Transactional
    public ResponseEntity<Boolean> updateStatus(@PathVariable long orderId, @PathVariable String status){
        OrderEntity foundOrder = this.orderService.findOne(orderId);
        foundOrder.setStatus(status);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/shop/{shopId}/order")
    @Transactional
    public ResponseEntity<List<OrderResponse>> findByShop(@PathVariable long shopId){
        ShopEntity foundShop = this.shopService.findOne(shopId);
        List<OrderEntity> orderEntities = this.orderService.findAllByShop(foundShop);
        List<OrderResponse> result = this.om.mapAll(orderEntities, OrderResponse.class);
        return ResponseEntity.ok(result);
    }
}
