
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Storehouse {
//    private int price;
//    private int stock;
//    private String product;
    private Map<String, Integer> store; 
    private Map<String, Integer> store_stocks;
    
    
    public Storehouse() {
        this.store = new HashMap<String, Integer>();
        this.store_stocks = new HashMap<String, Integer>();
    }
    public void addProduct(String product, int price, int stock) {
        this.store.put(product, price);
        this.store_stocks.put(product, stock);
       
    }
    
    public int price(String product) {
        if (this.store.containsKey(product)) {
            return this.store.get(product);
        } else {
            return -99;
        }
    }
    
    public int stock(String product) {
        if (this.store_stocks.containsKey(product)) {
            return this.store_stocks.get(product);
    } else {
    return 0;
    }
    }
    
 
    public boolean take(String product) {
        int temp = 0;
        if (this.store.containsKey(product)) {
            if (this.store_stocks.get(product) > 0) {
                temp = this.store_stocks.get(product);
                temp --;
                this.store_stocks.replace(product, temp);
                return true;
            }
            return false;
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> products = this.store.keySet();
        
        return products;
    }
}
