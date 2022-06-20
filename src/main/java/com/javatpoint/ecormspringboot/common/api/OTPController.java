package com.javatpoint.ecormspringboot.common.api;

import com.javatpoint.ecormspringboot.common.entity.CartEntity;
import com.javatpoint.ecormspringboot.common.entity.UserEntity;
import com.javatpoint.ecormspringboot.common.model.EmailTemplate;
import com.javatpoint.ecormspringboot.common.request.RegisterAccountRequest;
import com.javatpoint.ecormspringboot.common.service.imp.EmailService;
import com.javatpoint.ecormspringboot.common.service.imp.OTPService;
import com.javatpoint.ecormspringboot.common.service.imp.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PostMapping("/generateOtp")
    public ResponseEntity generateOTP(@RequestBody RegisterAccountRequest registerAccountRequest) throws MessagingException {
        int otp = otpService.generateOTP(registerAccountRequest.getUsername());
//      Generate The Template to send OTP
        EmailTemplate template = new EmailTemplate(this.htmlPath);
        Map<String,String> replacements = new HashMap<String,String>();
        replacements.put("user", registerAccountRequest.getUsername());
        replacements.put("otpnum", String.valueOf(otp));
        String message = template.getTemplate(replacements);
        this.emailService.sendOtpMessage(registerAccountRequest.getUsername(), "OTP-ToyStore", message);
        return ResponseEntity.ok(registerAccountRequest);
    }
    @PostMapping("/validateOtp")
    public @ResponseBody
    boolean validateOtp(@RequestParam("otpnum") int otpnum, @RequestBody RegisterAccountRequest registerAccountRequest){
        boolean isValid = false;
        String username = registerAccountRequest.getUsername();
        //Validate the Otp
        if(otpnum >= 0){
            int serverOtp = otpService.getOtp(username);
            if(serverOtp > 0){
                if(otpnum == serverOtp){
                    isValid = true;
                    otpService.clearOTP(username);
                    UserEntity userEntity = new UserEntity();
                    userEntity.setUsername(registerAccountRequest.getUsername());
                    userEntity.setPassword(this.passwordEncoder.encode(registerAccountRequest.getPassword()));
                    userEntity.setFullName(registerAccountRequest.getFullName());
                    CartEntity cartEntity = new CartEntity();
                    cartEntity.setUser(userEntity);
                    userEntity.setCart(cartEntity);
                    UserEntity savedUserEntity = this.userService.save(userEntity);
                    return isValid;
                }
                else {
                    return isValid;
                }
            }else {
                return isValid;
            }
        }else {
            return isValid;
        }
    }
}
