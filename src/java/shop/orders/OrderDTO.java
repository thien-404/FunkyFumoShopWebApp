/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.orders;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author HP
 */
public class OrderDTO {
    private String orderId;
    private String userId;
    private Timestamp date;
    private double total;
    private boolean status;
    private List<OrderDetailList> list;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String userId, Timestamp date, double total, boolean status, List<OrderDetailList> list) {
        this.orderId = orderId;
        this.userId = userId;
        this.date = date;
        this.total = total;
        this.status = status;
        this.list = list;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<OrderDetailList> getList() {
        return list;
    }

    public void setList(List<OrderDetailList> list) {
        this.list = list;
    }
    
    
}
