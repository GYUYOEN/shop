package com.shop.mall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "user_id")
    private int userId;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "pwd")
    private String pwd;

    @Column(nullable = false, name = "phone")
    private String phone;

    @Column(nullable = false, name = "gender")
    private String gender;

    @Column(name = "withdraw_check")
    private String withdrawCheck;

    @Column(name = "withdraw_date")
    private LocalDateTime withdrawDate;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @OneToOne
    @JoinTable(
            name = "refresh_token",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rt_id")
    )
    private RefreshToken refreshToken;
}
