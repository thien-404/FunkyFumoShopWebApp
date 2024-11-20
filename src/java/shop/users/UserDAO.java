/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import shop.utils.DBUtils;

/**
 *
 * @author Shirakami Mishino
 */
public class UserDAO {

    private static final String CHECK_LOGIN = "SELECT fullName, roleID, email, status FROM tblUsers WHERE userID=? AND password=?";
    private static final String CHECK_EXISTED_USER = "SELECT userID FROM tblUsers WHERE userID = ?";
    private static final String CREATE_USER = "INSERT INTO tblUsers (userID, fullName, password, roleID, email, status)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SEARCH = "SELECT userID, fullName, roleID, email, status FROM tblUsers WHERE fullName like ?";
    private static final String UPDATE = "UPDATE tblUsers SET fullName=?, roleID=? WHERE userID=?";
    private static final String DELETE = "DELETE tblUsers WHERE userID=?";
    private static final String UPDATE_PASSWORD = "UPDATE tblUsers SET fullName=?, email=?, password=? WHERE userID=?";

    private static final String GOOGLE_LOGIN_CHECK = "SELECT userID from tblUsers where userID = ?";

    public UserDTO checkLogin(String userID, String password)
            throws SQLException, ClassNotFoundException {
        UserDTO user = null;//khoi tao cac bien
        Connection con = null;//set gia tri ban dau la null
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();//khoi tao ket noi
            if (con != null) {
                ptm = con.prepareStatement(CHECK_LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    boolean status = rs.getBoolean("status");
                    user = new UserDTO(userID, fullName, password, roleID, email, status);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();//dong cac ket noi
            }
            if (ptm != null) {
                ptm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return user;
    }

    public boolean checkExisted(String userID) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CHECK_EXISTED_USER);
                ptm.setString(1, userID);
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

    public boolean create(UserDTO user)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(CREATE_USER);
                ptm.setString(1, user.getUserID());
                ptm.setString(2, user.getFullName());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, "US");
                ptm.setString(5, user.getEmail());
                ptm.setBoolean(6, true);
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
        return check;//mac dinh tra ve false nghia la khoi tao nguoi dung moi that bai
    }

    public List<UserDTO> getListUser(String search) throws SQLException {
        List<UserDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String password = "***";
                    String roleID = rs.getString("roleID");
                    String email = rs.getString("email");
                    boolean status = rs.getBoolean("status");
                    list.add(new UserDTO(userID, fullName, password, roleID, email, status));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean update(UserDTO user) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getRoleID());
                ptm.setString(3, user.getUserID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean delete(String userID) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(DELETE);
                ptm.setString(1, userID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
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

    public boolean updateByUser(UserDTO user) throws SQLException {
        boolean check = false;
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ptm = con.prepareStatement(UPDATE_PASSWORD);
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getEmail());
                ptm.setString(3, user.getPassword());
                ptm.setString(4, user.getUserID());
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {

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

    public boolean checkExistedUser(String userID) throws ClassNotFoundException, SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GOOGLE_LOGIN_CHECK);
                ptm.setString(1, userID);
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
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

}
