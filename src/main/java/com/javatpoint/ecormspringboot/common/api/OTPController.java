package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.model.EmailTemplate;
import com.javatpoint.ecormspringboot.common.request.UserAccountRequest;
import com.javatpoint.ecormspringboot.common.service.imp.KeyFactoryService;
import com.javatpoint.ecormspringboot.common.service.imp.EmailService;
import com.javatpoint.ecormspringboot.common.service.imp.OTPService;
import com.javatpoint.ecormspringboot.common.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/otp")
public class OTPController {
    @Autowired
    public OTPService otpService;
    @Autowired
    public EmailService emailService;

    @Autowired
    public UserService userService;

    @Value("${spring.application.htmlPath}")
    public String htmlPath;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private KeyFactoryService keyFactoryService;
    @PostMapping("/generateOtp")
    public ResponseEntity generateOTP(@RequestBody UserAccountRequest registerAccountRequest) throws MessagingException {
        int otp = otpService.generateOTP(registerAccountRequest.getUsername());
//      Generate The Template to send OTP
        EmailTemplate template = new EmailTemplate(this.htmlPath);
        Map<String, String> replacements = new HashMap<String, String>();
        replacements.put("user", registerAccountRequest.getUsername());
        replacements.put("otpnum", String.valueOf(otp));
        String message = template.getTemplate(replacements);
        this.emailService.sendOtpMessage(registerAccountRequest.getUsername(), "OTP-ToyStore", message);
        return ResponseEntity.ok(registerAccountRequest);
    }

    @GetMapping("/validateOtp")
    public ResponseEntity<Boolean> validateOtp(@RequestParam("OTPNumber") int otpnum, @RequestParam String username) {
        boolean isValid = false;
        if (otpnum >= 0) {
            int serverOtp = otpService.getOtp(username);
            if (serverOtp > 0) {
                if (otpnum == serverOtp) {
                    otpService.clearOTP(username);
                    isValid = true;
//                    UserEntity foundUserEntity = this.userService.findByUsername(username);
//                    if(foundUserEntity == null){
//                        otpService.clearOTP(username);
//                        foundUserEntity = new UserEntity();
//                        foundUserEntity.setUsername(registerAccountRequest.getUsername());
//                        foundUserEntity.setPassword(this.passwordEncoder.encode(registerAccountRequest.getPassword()));
//                        foundUserEntity.setFullName(registerAccountRequest.getFullName());
//                        CartEntity cartEntity = new CartEntity();
//                        cartEntity.setUser(foundUserEntity);
//                        foundUserEntity.setCart(cartEntity);
//                        ShopEntity shopEntity = new ShopEntity();
//                        shopEntity.setName(foundUserEntity.getUsername());
//                        shopEntity.setUser(foundUserEntity);
//                        foundUserEntity.setShop(shopEntity);
//                    }else{
//                        System.out.println(foundUserEntity.getId());
//                        foundUserEntity.setPassword(this.passwordEncoder.encode(registerAccountRequest.getPassword()));
//                    }
//                    UserEntity savedUserEntity = this.userService.save(foundUserEntity);
                    return ResponseEntity.ok(isValid);
                } else {
                    return ResponseEntity.ok(isValid);
                }
            } else {
                return ResponseEntity.ok(isValid);
            }
        } else {
            return ResponseEntity.ok(isValid);
        }
    }
}
