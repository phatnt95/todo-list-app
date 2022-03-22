package com.example.demo.controller;

import com.example.demo.security.jwt.JwtTokenProvider;
import com.example.demo.model.Account;
import com.example.demo.model.Role;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.response.JwtAuthenticationResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("api")
public class LoginController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    //Login admin
    @PostMapping("login-admin")
    public ResponseEntity<?> authenticateAdmin(@RequestBody LoginRequest loginRequest) {
        //Tạo chuỗi authentication từ username và password (object LoginRequest - file này chỉ là 1 class bình thường, chứa 2 trường username và password)
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
        );

        //Set chuỗi authentication đó cho UserPrincipal
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Account accountLogin = accountService.getAccountByUsername(loginRequest.getUserName());
        Set<Role> roles = accountLogin.getRoles();
        boolean isAdmin = false;
        for (Role role : roles) {
            if (role.getRoleName().equals("ADMIN")) {
                isAdmin = true;
            }
        }
        if (authentication != null && isAdmin) {
            String jwt = tokenProvider.generateToken(authentication);
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt).toString()); //Trả về chuỗi jwt(authentication string)
        }
        return ResponseEntity.ok(new MessageResponse("fail"));
    }
}
