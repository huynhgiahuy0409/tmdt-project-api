package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.dto.BrandDTO;
import com.javatpoint.ecormspringboot.common.dto.UserDTO;
import com.javatpoint.ecormspringboot.common.entity.BrandEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.service.imp.UserService;
import com.javatpoint.ecormspringboot.common.util.ObjectMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private ObjectMapperUtils om;
    @Autowired
    private ModelMapper mp;
    @Autowired
    private UserService userService;
    @PostMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        this.mp.getConfiguration().setSkipNullEnabled(true);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity requestUser = this.mp.map(user, UserEntity.class);
        UserEntity findUser = this.userService.findByUsername(username);
        this.mp.map(requestUser, findUser);
        this.userService.save(findUser);
        UserDTO result = this.mp.map(findUser, UserDTO.class);
        return ResponseEntity.ok(result);
    }
}
