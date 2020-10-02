import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> items = new ArrayList<Product>() ;

    public List<Product> getItems() {
        return items;
    }

    public void addToCart(Product item){
         this.items.add(item);
    }
    public void removeToCArt(Product item){
        this.items.removeIf(prod->prod.getId()==item.getId());
    }
}
