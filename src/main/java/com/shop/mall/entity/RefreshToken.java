package com.shop.mall.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.sql.rowset.Joinable;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "rt_id")
    private int id;

    @Column(name = "rt_value")
    private String refreshToken;

    @Builder
    public RefreshToken(int id, String value) {
        this.id = id;
        this.refreshToken = value;
    }

    public RefreshToken updateValue(String token) {
        this.refreshToken = token;
        return this;
    }
}
