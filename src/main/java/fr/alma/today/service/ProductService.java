package fr.alma.today.service;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.UpdateResult;
import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;

import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class ProductService {

    public void saveProduct(Product product, MongoDatabase database){
        MongoCollection<Product> products = database.getCollection("Product", Product.class);
        products.insertOne(product);
        // database.getCollection("Cart").find(Filters.eq("_id", cart)).first().toJson()
        System.out.println("Cart inserted.");

        // return cartRepository.save(cart);
    }
    public Product getProduct(String prod, MongoDatabase database){
        return database.getCollection("Product", Product.class).find(Filters.eq("product_id", prod)).first();
    }

   public ArrayList<Product> getProductList(MongoDatabase db) {
       ArrayList<Product> products = new ArrayList<>();
     FindIterable<Product> product1 = db.getCollection("Product", Product.class).find();
       MongoCursor<Product> product = product1.iterator();

       while (product.hasNext()) {
           System.out.println("p& :"+product.next().toString());
           if ((product ==null)){
               break;
           }else {
               products.add(product.tryNext());
           }
       }
       return products;
   }



   public Product modifyProduct(Product product, MongoDatabase database) {
       MongoCollection<Product> products = database.getCollection("Product", Product.class);

       // find this grade.
      // Product pro = products.find(eq("product_id", product.getId())).first();
       //System.out.println("Product found:\t" + pro);

       Bson update1 = set("name", product.getName()); // increment x by 10. As x doesn't exist yet, x=10.
       Bson update2 = set("description", product.getDescription()); // rename variable "class_id" in "new_class_id".
       Bson update3 = set("amount", product.getAmount()); // creating an array with a comment.
       Bson update4 = set("quantity", product.getQuantity());
       Bson updates = combine(update1, update2, update3,update4);
       FindOneAndUpdateOptions optionAfter = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
       Product updatedProduct= database.getCollection("Product", Product.class).findOneAndUpdate(eq("product_id",product.getId()),updates,optionAfter);

      // System.out.println("Grade replaced:\t" + updatedProduct);

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


   public Product deleteProduct(String productId, MongoDatabase database) {
       FindOneAndUpdateOptions optionAfter = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
 return database.getCollection("Product", Product.class).findOneAndUpdate(eq("product_id", productId),set("quantity",0),optionAfter);

//System.out.println(product.toString());

   }


   public List<Product> sortByProduct() {
        return null;
    }

   public List<Product> sortByProductDesc() {
        return null;
    }
}
