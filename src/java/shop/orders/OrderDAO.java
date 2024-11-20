/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import shop.utils.DBUtils;

/**
 *
 * @author HP
 */
public class OrderDAO {
    public List<OrderDTO> getOrderList (String userId) throws ClassNotFoundException,SQLException{
        List<OrderDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "SELECT ORDERID,DATE,TOTAL FROM TBLORDERS WHERE USERID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, userId);
                rs = stm.executeQuery();
                while(rs.next()){
                    String orderId = rs.getString("orderId");                    
                    Timestamp date = rs.getTimestamp("date");
                    double total = rs.getDouble("total");
                    List<OrderDetailList> orderDetailList = getOrderDetailList(orderId);
                    list.add(new OrderDTO(orderId, userId, date, total, true, orderDetailList));
                }
                return list;
            }
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return list;
    }
    
    public List<OrderDetailList> getOrderDetailList (String orderId) throws ClassNotFoundException,SQLException{
        List<OrderDetailList> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "SELECT p.SRCIMG,p.NAME,od.PRICE,od.QUANTITY FROM TBLORDERDETAILS od inner join tblProducts p ON od.PRODUCTID = p.PRODUCTID WHERE ORDERID = ?";
                stm = con.prepareStatement(query);
                stm.setString(1, orderId);
                rs = stm.executeQuery();
                while(rs.next()){
                    String srcImg = rs.getString("srcimg");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    list.add(new OrderDetailList(srcImg, name, price, quantity));
                }            
            }
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return list;
    }
    
    public List<OrderDTO> getAllOrderList (String userId) throws ClassNotFoundException,SQLException{
        List<OrderDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try{
            con = DBUtils.getConnection();
            if(con != null){
                String query = "SELECT ORDERID,DATE,TOTAL,USERID FROM TBLORDERS WHERE USERID LIKE ?";
                stm = con.prepareStatement(query);
                stm.setString(1, "%"+userId+"%");
                rs = stm.executeQuery();
                while(rs.next()){
                    String orderId = rs.getString("orderId");                    
                    Timestamp date = rs.getTimestamp("date");
                    double total = rs.getDouble("total");
                    String userID = rs.getString("userId");
                    List<OrderDetailList> orderDetailList = getOrderDetailList(orderId);
                    list.add(new OrderDTO(orderId, userID, date, total, true, orderDetailList));
                }
                return list;
            }
        }finally{
            if(rs != null) rs.close();
            if(stm != null) stm.close();
            if(con != null) con.close();
        }
        return list;
    }
}


