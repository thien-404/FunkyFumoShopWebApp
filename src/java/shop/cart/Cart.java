/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.cart;

import java.util.HashMap;
import shop.products.ProductDTO;

/**
 *
 * @author SonLe
 */
public class Cart {

    private HashMap<String, CartItem> cart;

    public Cart(HashMap<String, CartItem> cart) {
        this.cart = cart;
    }

    public Cart() {
    }

    public HashMap<String, CartItem> getCart() {
        return cart;
    }

    public boolean add(ProductDTO product, int quantity) {
        boolean check = false;
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }

        if (this.cart.containsKey(product.getProductID())) {
            this.cart.get(product.getProductID()).setQuantity(this.cart.get(product.getProductID()).getQuantity() + quantity);
            check = true;
        } else {
            CartItem cartItem = new CartItem(product.getProductID(), product.getName(), product.getSrcImg(), product.getPrice(), quantity);
            this.cart.put(cartItem.getProductID(), cartItem);
            check = true;
        }
        return check;
    }

    public boolean update(ProductDTO product, int quantity) {
        boolean check = false;
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }

        if (this.cart.containsKey(product.getProductID())) {
            this.cart.get(product.getProductID()).setQuantity(quantity);
            check = true;
        }
        return check;
    }

    public boolean remove(String id) {
        boolean check = false;
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
            check = true;
        }
        return check;
    }
}
