package service;

import model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProductList();

    List<Product> getProductById(int productId);

    List<Product> getProductByName(String name);

    boolean addProduct(Product product);

    boolean modifyProduct(Product product);

    boolean deleteProduct(int productId);

    int countProduct();

    List<Product> sortByProduct();

    List<Product> sortByProductDesc();
}
