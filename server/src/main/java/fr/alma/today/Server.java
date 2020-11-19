package fr.alma.today;

import fr.alma.today.shopMethods.ShopMethods;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Server   {




    public static void main(String[] args){


//            String url = "rmi://" + InetAddress.getLocalHost().getHostAddress()+"/authentication" ;
//            Registry rgsty = LocateRegistry.createRegistry(5000);
//            AuthMethods authentication = new AuthMethods();
//            ShopMethods shopping = new ShopMethods();
//            rgsty.rebind("authenticate", authentication);
            try {
                Registry registry = LocateRegistry.createRegistry(5099);
                registry.bind("today", new ShopMethods());
                System.out.println("Server is connected and waiting for the client");
            }
            catch(Exception e) {
                System.out.println("Server could not connect: "+e);
            }

    }


    }

