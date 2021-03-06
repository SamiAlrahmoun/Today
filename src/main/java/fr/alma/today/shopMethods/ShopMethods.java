package fr.alma.today.shopMethods;

import fr.alma.today.models.Cart;
import fr.alma.today.models.Order;
import fr.alma.today.models.Product;
import fr.alma.today.models.User;

import fr.alma.today.service.CartService;
import fr.alma.today.service.OrderService;
import fr.alma.today.service.ProductService;
import com.mongodb.client.MongoDatabase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ShopMethods extends UnicastRemoteObject implements ShopInterfarce {

    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();
    private OrderService orderService = new OrderService();
    private MongoDatabase database;
    private AuthMethods auth;
    public ShopMethods(MongoDatabase database) throws RemoteException {
        super();
        this.database = database;
        this.auth =  new AuthMethods(database);
    }


    public User login(String username, String password){
       return this.auth.login(username,password);
    }


    public User register(String username, String email, String password){
        System.out.println(username+" Called register");
        return this.auth.register(username,email,password);
    }



    //to block of synchronisation
    public Product readProduct(String productId){
       return productService.getProduct(productId, this.database );
    }
    //to block of synchronisation
    public List<Cart> readCart(String cardId){
        return (List<Cart>) cartService.getCart(cardId, this.database);
    }



    public synchronized Order buy( String cardId, String Address)throws RemoteException{

        Cart cart  =  cartService.getCart(cardId,this.database);
        ///lock all products in cart
        lockedCartProduct(cart.getProducts());
        Order newOrder = orderService.buy(cardId,Address,this.database);
        //release all products after buy for the remaining quantity
        newOrder.getProducts().forEach(product -> {
            unlockedProduct(product);
        });
        return newOrder;

    }


    //to do block of synchromisation
    public synchronized Cart addToCart(String cartId, String productID) throws InterruptedException {

        while (isLocked(productID)){
            wait();
        }
        //si le produit est 0 on ne peux pas l'ajouter dans le panier
        if (productService.getProduct(productID,this.database).getQuantity()==0){
            return   cartService.getCart(cartId, this.database);
        }else {
            return   cartService.addToCart(cartId, productID, this.database);
        }


    }
    public synchronized Cart removeFromCart(String cartId, String productID){
        if(isLocked(productID)){
            System.out.println("the product is lock can't remove from the cart");
            return cartService.getCart(cartId, this.database);
        }else{
            return cartService.removeToCart(cartId, productID, this.database);
        }

    }

    public Product addProduct (String productID, String name, String description, double price, Integer quantity){
        Product product = new Product(productID,name,description,price, quantity);
    this.productService.saveProduct(product,this.database);
    return product;
    }

    //block of synchronisation
    public synchronized Product EditProduct(String productID,String name,String description, double price, Integer quantity){
        if(isLocked(productID)){
            System.out.println("the product is lock can't edit");
            return null;
        }else{

            Product product = new Product(productID,name,description,price,quantity);
            product.setId(productID);
            lockedProduct(product);// lock product
            Product newProduct =  productService.modifyProduct(product, database);
            unlockedProduct(newProduct);// release product
            return newProduct;
        }
    }

    public ArrayList<Product> getAllProduct(){
      return productService.getProductList(this.database);
    }

    //block of synchronisation
    public synchronized Product removeProduct(String productId) throws RemoteException{
        Product product = productService.getProduct(productId,this.database);

            if(!isLocked(productId)){
                return productService.deleteProduct(productId,this.database );
            }else{
                System.out.println(product.getName()+" product is lock");
                return product;
            }


    }

   public void lockedCartProduct(List<Product> products){
       for (Product product:products) {
           lockedProduct(product);
       }
   }
   public void lockedProduct(Product product){
       product.setLocked(true);
       productService.modifyProduct(product,this.database);
   }
    public void unlockedProduct(Product product){
        product.setLocked(false);
        notifyAll();// notify all product is available
        productService.modifyProduct(product,this.database);
    }
   public boolean isLocked (String productId){
       /// System.out.println("isLock:"+ productService.getProduct(productId,this.database).isLocked());
      return   productService.getProduct(productId,this.database).isLocked();
   }

}
