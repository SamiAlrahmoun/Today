package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import service.CartService;


@RestController
public class CartController {
    @Autowired
    CartService cartService;
}
