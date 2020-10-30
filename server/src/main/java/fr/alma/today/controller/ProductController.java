package fr.alma.today.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;


@RestController
public class ProductController {
    @Autowired
    ProductService productService;
}
