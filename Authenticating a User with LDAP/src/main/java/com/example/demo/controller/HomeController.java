/**
 * Copyright (C) 2017 IFlyTek. All rights reserved.
 */
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * <code>HomeController</code>
 * </p>
 * Description:
 *
 * @author Mcchu
 * @date 2018/2/23 16:25
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }
}
