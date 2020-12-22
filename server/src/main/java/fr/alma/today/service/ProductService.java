package fr.alma.today.service;


import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.repository.OrderRepository;
import fr.alma.today.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

   public List<Product> getProductList(Product product) {
     return  productRepository.findAll();
    }

   public Product getProductById(Integer productId) {
        return productRepository.findProductById(productId);
    }

   public List<Product> getProductByName(String name) {
        return null;
    }

   public boolean addProduct(Product product) {
        return false;
    }

   public Product modifyProduct(Product product) {
      return  productRepository.save(product);
    }

   public boolean deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
        Product product = productRepository.findProductById(productId);
        if(product.getId() != null) {
            return true;
        }else{
            return false;
        }
   }


   public List<Product> sortByProduct() {
        return null;
    }

   public List<Product> sortByProductDesc() {
        return null;
    }
}
