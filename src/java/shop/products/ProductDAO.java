/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shop.utils.DBUtils;

/**
 *
 * @author anhdt
 */
public class ProductDAO {

    private static final String SEARCH = "SELECT * FROM tblProducts WHERE name like ?";
    private static final String DELETE = "DELETE tblProducts WHERE productID=?";
    private static final String UPDATE = "UPDATE tblProducts SET name=?, srcImg=?, price=?, quantity=? WHERE productID=?";
    private static final String CHECK_DUPLICATE = "SELECT name FROM tblProducts WHERE productID=?";
    private static final String CREATE = "INSERT INTO tblProducts(productID, name, srcImg, price, quantity, status) VALUES(?,?,?,?,?,?)";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM tblProducts WHERE productID = ?";

    public List<ProductDTO> getListProduct(String searchProduct) throws SQLException, ClassNotFoundException {
        List<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH);
                ptm.setString(1, "%" + searchProduct + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String name = rs.getString("name");
                    String srcImg = rs.getString("srcImg");
                    Double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    list.add(new ProductDTO(productID, name, srcImg, price, quantity, status));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean delete(String productID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(DELETE);
                ptm.setString(1, productID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean updateProduct(ProductDTO product) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE);
                ptm.setString(1, product.getName());
                ptm.setString(2, product.getSrcImg());
                ptm.setDouble(3, product.getPrice());
                ptm.setInt(4, product.getQuantity());
                ptm.setString(5, product.getProductID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean checkDuplicate(String productID) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public boolean addNewProduct(ProductDTO product) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE);
                ptm.setString(1, product.getProductID());
                ptm.setString(2, product.getName());
                ptm.setString(3, product.getSrcImg());
                ptm.setDouble(4, product.getPrice());
                ptm.setInt(5, product.getQuantity());
                ptm.setBoolean(6, product.isStatus());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    public ProductDTO getProductByID(String id) throws ClassNotFoundException, SQLException {
        ProductDTO product = null;
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(GET_PRODUCT_BY_ID);
                ptm.setString(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String srcImg = rs.getString("srcImg");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    product = new ProductDTO(id, name, srcImg, price, quantity, status);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return product;
    }

}
