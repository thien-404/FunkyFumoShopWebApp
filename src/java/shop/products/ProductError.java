/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.products;

/**
 *
 * @author anhdt
 */
public class ProductError {
    private String productID;
    private String name;
    private String srcImg;
    private String price;
    private String quantity;
    private String status;
    private String error;

    public ProductError() {
        this.productID = "";
        this.name = "";
        this.srcImg = "";
        this.price = "";
        this.quantity = "";
        this.status = "";
        this.error = "";
    }

    public ProductError(String productID, String name, String srcImg, String price, String quantity, String status, String error) {
        this.productID = productID;
        this.name = name;
        this.srcImg = srcImg;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.error = error;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    
    
    
}
