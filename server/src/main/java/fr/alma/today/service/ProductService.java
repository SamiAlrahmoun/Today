package fr.alma.today.service;


import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.repository.OrderRepository;
import fr.alma.today.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
private ProductRepository productRepository;
private OrderRepository orderRepository;
   public List<Product> getProductList(Product product) {
     return  productRepository.findAll();
    }

   public Product getProductById(String productId) {
        return productRepository.findById(productId);
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

   public boolean deleteProduct(String productId) {
        productRepository.deleteById(productId);
        Product product = productRepository.findById(productId);
        if(product.getId().isEmpty()) {
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
