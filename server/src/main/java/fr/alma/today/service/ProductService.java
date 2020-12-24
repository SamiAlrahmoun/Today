package fr.alma.today.service;


import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.UpdateResult;
import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.repository.OrderRepository;
import fr.alma.today.repository.ProductRepository;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class ProductService {
    @Autowired


    private ProductRepository productRepository;


    public void saveProduct(Product product, MongoDatabase database){
        MongoCollection<Product> products = database.getCollection("Product", Product.class);
        products.insertOne(product);
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Cart inserted.");

        // return cartRepository.save(cart);
    }
    public Product getProduct(String prod, MongoDatabase database){
        return database.getCollection("Product", Product.class).find(Filters.eq("user_id", prod)).first();
    }

   public List<Product> getProductList(MongoDatabase db) {
     return (List<Product>) db.getCollection("Product", Product.class).find();
    }



   public Product modifyProduct(Product product, MongoDatabase database) {
       MongoCollection<Product> products = database.getCollection("Product", Product.class);

       // find this grade.
       Product pro = products.find(eq("product_id", product.getId())).first();
       System.out.println("Product found:\t" + pro);


       Document filterByProductId = new Document("product_id", product.getId());
       FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
       Product updatedProduct = products.findOneAndReplace(filterByProductId, product, returnDocAfterReplace);


       System.out.println("Grade replaced:\t" + updatedProduct);

       // delete this grade
     //  System.out.println("Grade deleted:\t" + grades.deleteOne(filterByGradeId));


        return  updatedProduct;
    }

    public Product updatedProduct(Product product,MongoDatabase database){
        MongoCollection<Product> products = database.getCollection("Product", Product.class);
        // find this grade.
        Product pro = products.find(eq("product_id", product.getId())).first();
        System.out.println("Product found:\t" + pro);

        Document filterByProductId = new Document("product_id", product.getId());
        FindOneAndReplaceOptions returnDocAfterReplace = new FindOneAndReplaceOptions().returnDocument(ReturnDocument.AFTER);
        Product updatedProduct = products.findOneAndReplace(filterByProductId, product, returnDocAfterReplace);

        System.out.println("Grade replaced:\t" + updatedProduct);
        return updatedProduct;
    }


   public boolean deleteProduct(String productId, MongoDatabase database) {

       Document filterByProductId = new Document("product_id", productId);
       MongoCollection<Product> products = database.getCollection("grades", Product.class);
       System.out.println("Grade deleted:\t" + products.deleteOne(filterByProductId));
 Product product = getProduct(productId, database);

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
