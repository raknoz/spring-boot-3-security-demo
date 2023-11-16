package com.example.demo.controllers;

import com.example.demo.requests.ChangePasswordRequest;
import com.example.demo.servicies.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private final UserService service;

  public UserController(final UserService service) {
    this.service = service;
  }

  @PatchMapping
  public ResponseEntity<?> changePassword(
      @RequestBody ChangePasswordRequest request, Principal connectedUser) {
    service.changePassword(request, connectedUser);
    return ResponseEntity.ok().build();
  }
}
