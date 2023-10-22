package com.management.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String test(){
        return " testing successfully done!";
    }
}
