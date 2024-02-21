package com.shop.mall.controller;

import com.shop.mall.dto.MemberDTO;
import com.shop.mall.dto.TokenDTO;
import com.shop.mall.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberDTO> signup(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(authService.signup(memberDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(authService.login(memberDTO));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDTO> reissue(@RequestBody TokenDTO tokenDTO) {
        return ResponseEntity.ok(authService.reissue(tokenDTO));
    }
}
