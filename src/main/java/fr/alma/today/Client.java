package fr.alma.today;





import fr.alma.today.models.User;
import fr.alma.today.shopMethods.ShopInterfarce;
import java.rmi.Naming;
import java.rmi.RemoteException;


public class Client {

    public static void main(String[] args){

        try {
          ShopInterfarce today=(ShopInterfarce)Naming.lookup("rmi://localhost:1099/today");

          //register user
          //  User user = today.register("Marvel","darkmarvel@gmail.com","123456789");
          //  System.out.println(user.toString());
            //login user
          //  User user = today.login("Marvel","123456789");
            // System.out.println(user.getEmail());
            //adding a product
          // Product product = today.addProduct("darkmarvel@gmail.com","shoes", "Stan Smith Addidas",120,2);
          //  Product product = today.addProduct("Jeans","Jean droit 501", "Jean bleu Levi's ",89,2);
          //  System.out.println(product.toString());
            //add to cart
           // System.out.println(today.addToCart("darkmarvel@gmail.com","Jeans-be3d8c5a-bf54-4e3e-b29b-26808cd9ceb0").toString());
            //remove from the cart
            ///System.out.println( today.removeFromCart("darkmarvel@gmail.com","Jeans-610cf477-248b-45c4-b81e-f251a15e8ac2"));
            // edit product
        //   System.out.println(today.EditProduct("Jeans-be3d8c5a-bf54-4e3e-b29b-26808cd9ceb0","Jean droit 501","Jean noir Levi's ",100,1).toString());
            // Calling the remote method using the obtained object
            //delet a produc
            // System.out.println(today.removeProduct("Jeans-be3d8c5a-bf54-4e3e-b29b-26808cd9ceb0"));
           //get all elements
            //System.out.println(today.getAllProduct());
          //  System.out.println(today.buy("darkmarvel@gmail.com",""));
            //buy item
           // System.out.println(today.buy("darkmarvel@gmail.com","15 Avenue de avenue felix vincent"));
            // Create client thread
            Thread client1 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try {
                        // user creation
                       // today.register("Marvel","darkmarvel@gmail.com","123456789");
                        User user = today.login("Marvel","123456789");
                        System.out.println(user.toString());
                    }
                    catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });

            // Create client thread
            Thread client2 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try {
                        // user creation
                       // today.register("Sami","sami@gmail.com","123456789");
                        User user = today.login("Sami","123456789");
                        System.out.println(user.toString());
                    }
                    catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            // Create client thread
            Thread client3 = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try {

                        // user creation
                       // today.register("Oury","oury@gmail.com","123456789");
                        User user = today.login("Oury","123456789");
                        System.out.println(user.toString());
                    }
                    catch (  RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            // Create client thread
            Thread producer = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try {
                        // Producer creation
                        //today.register("Producer","producer@gmail.com","123456789");
                        User user = today.login("Producer","123456789");
                        System.out.println(user.toString());
                    }
                    catch ( RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            client1.start();
            client2.start();
            client3.start();
            producer.start();

            // t1 finishes before t2
            //t1.join();
            //t2.join();
            // t1 finishes before t2
            //t1.join();
            //t2.join();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }


}