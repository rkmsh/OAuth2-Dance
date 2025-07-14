package com.example.authresource.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
class AppController {

    @GetMapping("/me")
    public String me(Principal principal) {
        return principal.getName();
    }
}
