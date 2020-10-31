package fr.alma.today.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;

@Document(collection = "Orders")
public class Order implements Serializable {
    private static final long serialVersionUID = -3819883511505235030L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "orderMain")
    /*private Set<ProductInOrder> products = new HashSet<>();*/
    private String username;
    private String email;
    private String address;
    private List<Product> products;

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
    public Order (String username,String email, String address, List<Product> products){
        this.username =username;
        this.email =  email;
        this.address = address;
        this.products = products;
    }

}

