package com.zee.zee5app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Register;

@RestController
@RequestMapping("/api/users")
public class UserController {
@PostMapping("/addUser")
public String addUser(@RequestBody Register register) {
return register.toString();
}
}