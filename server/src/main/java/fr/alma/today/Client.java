package fr.alma.today;



import com.mongodb.client.MongoDatabase;
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

public class Client{

    public static void main(String[] args){

        try {
          ShopInterfarce today=(ShopInterfarce)Naming.lookup("rmi://localhost:1099/today");

            User user = today.register("Marvel","darkmarvel@gmail.com","123456789");
            // Calling the remote method using the obtained object
     System.out.println(user.toString());
            // System.out.println(list);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

}