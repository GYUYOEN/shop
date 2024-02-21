package com.shop.mall.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Authority {
    ROLE_USER(0, "user"),
    ROLE_ADMIN(1, "admin");

    private Integer code;
    private String value;

    Authority(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

}
