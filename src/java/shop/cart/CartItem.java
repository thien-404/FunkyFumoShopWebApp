/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.cart;

import java.io.Serializable;

/**
 *
 * @author SonLe
 */
public class CartItem implements Serializable{
    private String productID;
    private String name;
    private String srcImg;
    private double price;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String productID, String name, String srcImg, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.srcImg = srcImg;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
