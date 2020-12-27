package fr.alma.today;




import com.mongodb.client.MongoDatabase;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;
import fr.alma.today.shopMethods.ShopInterfarce;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args){

        try {
          ShopInterfarce today=(ShopInterfarce)Naming.lookup("rmi://localhost:1099/today");

          //register user
           // User user = today.register("Marvel","darkmarvel@gmail.com","123456789");
            //login user
          //  User user = today.login("Marvel","123456789");
            // System.out.println(user.getEmail());
            //adding a product
          // Product product = today.addProduct("darkmarvel@gmail.com","shoes", "Stan Smith Addidas",120,2);
          //  Product product = today.addProduct("Jeans","Jean droit 501", "Jean bleu Levi's ",89,2);
          //  System.out.println(product.toString());
            System.out.println(today.addToCart("darkmarvel@gmail.com","Jeans-be3d8c5a-bf54-4e3e-b29b-26808cd9ceb0").toString());
          //  today.addToCart("darkmarvel@gmail.com","Jeans-be3d8c5a-bf54-4e3e-b29b-26808cd9ceb0");

            // Calling the remote method using the obtained object

            // System.out.println(list);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }


}