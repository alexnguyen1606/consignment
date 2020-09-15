package com.consignment.security;

import lombok.Getter;
import lombok.Setter;

/**
 * @author:Nguyen Anh Tuan
 * <p>
 * May 14,2020
 */
@Getter
@Setter
public class AuthToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }
}
