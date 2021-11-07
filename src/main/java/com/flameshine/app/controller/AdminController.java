package com.flameshine.app.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.servlet.ModelAndView;

import com.flameshine.app.service.UserService;
import com.flameshine.app.util.Constants;
import com.flameshine.app.util.Pager;

/**
 * Controller for the application admin page.
 */

@Controller
@RequestMapping(Constants.ADMIN_PATH)
public class AdminController {

    private final UserService service;

    @Autowired
    public AdminController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView findAllPageable(@RequestParam("page") Optional<Integer> page) {

        var users = service.findAllPageable(
            PageRequest.of(
                page.orElse(0),
                5
            )
        );

        return new ModelAndView(Constants.ADMIN_PATH)
            .addObject("users", users)
            .addObject("pager", new Pager(users));
    }
}