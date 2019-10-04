
import java.util.HashMap;
import java.util.Map;


public class ShoppingBasket {
    private Map<String, Purchase> shoppingBasket = new HashMap<String, Purchase>();
    
    public ShoppingBasket() {
    }
    
    public void add(String product, int price) {
        if (this.shoppingBasket.containsKey(product)) {
            this.shoppingBasket.get(product).increaseAmount();
        } else {
        Purchase temp = new Purchase(product, 1, price);
        this.shoppingBasket.put(product, temp);
        }
    }
    
    public int price() {
        int price = 0;
        for (Purchase x: this.shoppingBasket.values()) {
            price += x.price();
        }
        return price;
    }
    
    public void print() {
        for (Purchase x: this.shoppingBasket.values()) {
            System.out.println(x);
        }
    }
 }
