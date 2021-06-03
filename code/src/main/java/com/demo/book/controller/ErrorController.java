package com.demo.book.controller;

import com.demo.book.service.BulletinService;
import com.demo.book.service.UserService;
import com.demo.book.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class ErrorController {

    private final UserService userService;

    private final BulletinService bulletinService;

    public ErrorController(UserService userService, BulletinService bulletinService) {
        this.userService = userService;
        this.bulletinService = bulletinService;
    }

    @GetMapping("/404")
    public String error404(Model model, HttpServletRequest request) {
        Tools.setLayout(userService, bulletinService, model, request, true);

        return "error/404";
    }
}
