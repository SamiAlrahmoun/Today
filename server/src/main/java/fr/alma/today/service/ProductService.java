package fr.alma.today.service;


import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.repository.OrderRepository;

import java.util.List;

public class ProductService {
private OrderRepository orderRepository ;
   public List<Product> getProductList(Product product) {
        return null;
    }

   public Product getProductById(String productId) {
        return null;
    }

   public List<Product> getProductByName(String name) {
        return null;
    }

   public boolean addProduct(Product product) {
        return false;
    }

   public boolean modifyProduct(Product product) {
        return false;
    }
    public Order buy (Order order){
      return orderRepository.save(order);
    }

   public boolean deleteProduct(int productId) {
        return false;
    }


   public List<Product> sortByProduct() {
        return null;
    }

   public List<Product> sortByProductDesc() {
        return null;
    }
}
