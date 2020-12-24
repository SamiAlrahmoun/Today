package fr.alma.today.models;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.util.List;


public class Order  {
    //private static final long serialVersionUID = -3819883511505235030L;

    private ObjectId id;
    @BsonProperty(value = "order_id")
    /*private Set<ProductInOrder> products = new HashSet<>();*/
    private String username;
    private String email;
    private String address;
    private List<Product> products;
    private Double price;
    private Integer quantity;

    /*
    @NotNull
    private BigDecimal orderAmount;
    @NotNull
    @ColumnDefault("0")
    private Integer orderStatus;
    */
    public Order(User user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
            /*this.orderAmount = user.getCart().getProducts().stream().map(item -> item.getProductPrice().multiply(new BigDecimal(item.getCount())))
                    .reduce(BigDecimal::add)
                    .orElse(new BigDecimal(0));
            this.orderStatus = 0;*/

    }
    public Order (String username,String email, String address, List<Product> products, Double price, Integer quantity){
        this.username =username;
        this.email =  email;
        this.address = address;
        this.products = products;
        this.price = price;
        this.quantity = quantity;

    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ObjectId getId() {
        return id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

}

