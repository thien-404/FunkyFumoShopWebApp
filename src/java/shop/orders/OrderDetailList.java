/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.orders;

/**
 *
 * @author HP
 */
public class OrderDetailList {
    private String srcImg;
    private String productName;
    private double price;
    private int quantity;

    public OrderDetailList() {
    }

    public OrderDetailList(String srcImg, String productName, double price, int quantity) {
        this.srcImg = srcImg;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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
