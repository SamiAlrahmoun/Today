package fr.alma.today.models;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @BsonProperty(value = "cart_id")
    private String cartId;
    private List<Product> products = new ArrayList<Product>() ;
    private Double total ;
    private Integer size ;

    public Cart(){

    }

    public Cart(String s){
        this.cartId = s;
        this.size = 0;
        this.total = 0.0;
    }


    
    
    
    public List<Product> getItems() {
        return products;
    }
    

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    public Double cartPrice(List<Product> products){
        Double sum = 0.0;
        if (products.size()>0) {
            System.out.println("product size :"+products.size());

            for (Product product : products) {
            //    System.out.println("product size :"+product.toString());
                sum += product.getAmount();
            }
        }
        return sum;

    }

    public Double getTotal() {
        return total;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addToCart(Product item){
        this.products.add(item);
    }

    public void removeToCArt(Product item){

        this.products.removeIf(prod->prod.getId()==item.getId()
        );
    }
    public void removeAll(){
        this.getItems().clear();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cart{");
        sb.append("id=").append(cartId);
        sb.append(", total=").append(total);
        sb.append(", size=").append(size);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId) && Objects.equals(size, cart.size) && Objects.equals(total,
                cart.total) && Objects
                .equals(products, cart.cartId);
    }

    

}