
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author woohoo
 */
public class Storehouse {
    private Map<String, Integer> stock;
    private Map<String, Integer> prices;

    public Storehouse() {
        this.prices = new HashMap<String, Integer>();
        this.stock = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        if (!(this.stock.containsKey(product))) {
            this.stock.put(product, stock);
            this.prices.put(product, price);
        } else {
            int totalStock = stock + this.stock.get(product);
            this.stock.put(product, totalStock);
        }
    }
    
    public int price(String product) {
        if (!this.prices.containsKey(product)) {
            return -99;
        }
        return this.prices.get(product);
    }
    
    public int stock(String product) {
        if (!this.stock.containsKey(product)) {
            return 0;
        }
        return this.stock.get(product);
    }
    
    public boolean take(String product) {
        if (this.stock.containsKey(product) && this.stock.get(product) - 1 >= 0) {
            this.stock.put(product, this.stock.get(product)-1);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
       return new HashSet<String>(this.stock.keySet());
    }
}
