package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.entity.CartItemEntity;
import com.javatpoint.ecormspringboot.common.entity.PendingItemEntity;
import com.javatpoint.ecormspringboot.common.service.ICartItemService;
import com.javatpoint.ecormspringboot.common.service.IPendingItemService;
import org.hibernate.annotations.Nationalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "http://localhost:4200")
public class PendingItemController {

    @Autowired
    private IPendingItemService pendingItemService;

    @Autowired
    private ICartItemService cartItemService;

    @Transactional
    @PutMapping("/pendingItem/{pendingItemId}")
    public ResponseEntity<Boolean> updatePendingItem(@PathVariable int pendingItemId, @RequestBody int quantity) {
        PendingItemEntity pendingItemEntity = this.pendingItemService.findOne(pendingItemId);
        if (pendingItemEntity != null) {
            pendingItemEntity.setQuantity(quantity);
            pendingItemEntity.getCartItem().setModifiedDate(new Date());
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
    @Transactional
    @DeleteMapping("/pendingItem/{pendingItemId}")
    public void removePendingItem(@PathVariable int pendingItemId) {
        this.pendingItemService.removeById(pendingItemId);
    }
}
