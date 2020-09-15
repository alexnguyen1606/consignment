package com.consignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author:Nguyen Anh Tuan
 *     <p>May 15,2020
 */
@RestController
public class AuthenticationApi {
  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private TokenProvider jwtTokenUtil;

  @PostMapping("/api/consignment/authentication")
  public ResponseEntity<?> register(@Valid @RequestBody UserModel userDTO)
      throws AuthenticationException {

    final Authentication authentication =
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    final String token = jwtTokenUtil.generateToken(authentication);
    return new ResponseEntity<>(new AuthToken(token), HttpStatus.OK);
  }
}
