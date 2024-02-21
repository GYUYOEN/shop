package com.shop.mall.dto;

import com.shop.mall.entity.Authority;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int userId;
    private String email;
    private String name;
    private String pwd;
    private String phone;
    private String gender;
    private Authority authority;
    private LocalDateTime createdDate, updatedDate;

    public void toPwdEncode(PasswordEncoder passwordEncoder) {
        this.pwd = passwordEncoder.encode(this.pwd);
    }
}
