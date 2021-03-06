package com.flameshine.store.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.flameshine.store.util.Constants;

/**
 * Login page controller.
 */

@Controller
public class LoginController {

    @GetMapping(Constants.LOGIN_PATH)
    public String login(Principal principal) {
        return principal != null ? Constants.HOME_PATH : Constants.LOGIN_PATH;
    }
}