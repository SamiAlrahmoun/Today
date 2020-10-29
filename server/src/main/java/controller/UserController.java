package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userService;
        }

