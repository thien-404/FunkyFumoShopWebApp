/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.users.UserDAO;
import shop.users.UserDTO;
import shop.users.userError;
import shop.utils.ValidInputUtils;


/**
 *
 * @author Shirakami Mishino
 */
public class RegisterController extends HttpServlet {
    
    private static final String LOGIN_PAGE = "login.jsp";
    //khi đăng kí thành công chuyển về trang login
    private static final String REGISTER_PAGE = "register.jsp";
    //khi đăng kí thất bại load lại trang register 1 lần nữa
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        userError userError = new userError();
        ValidInputUtils valid = new ValidInputUtils();
        String url = REGISTER_PAGE;
        //mac dinh tra ve trang register
        try {
            boolean checkValid = true;
            UserDAO dao = new UserDAO();
            //1.Lay cac parameter tu form gui ve
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            //2.Goi ham check cac du lieu nhap vao co dung valid hay chua
            if (!valid.checkUserIDLen(userID)) {
                checkValid = false;
                userError.setUserIDError("Please enter username length from 4 to 50");
            }
            if (!valid.checkfullNameLenError(fullName)) {
                checkValid = false;
                userError.setFullNameError("Please enter full name length from 2 to 50");
            }
            if (!valid.checkPasswordLenError(password)) {
                checkValid = false;
                userError.setPasswordError("Please enter password length longer than 4");
            }
            if (!valid.checkConfirm(password, confirm)) {
                checkValid = false;
                userError.setConfirmError("Password not match");
            }
            if (!valid.checkFormatEmail(email)) {
                checkValid = false;
                userError.setEmailError("Please enter correct format email");
            }
            if (checkValid) {
                if (!valid.checkUserExisted(userID)) {
                    userError.setiDExistedError("ID Existed");
                    request.setAttribute("USER_ERROR", userError);
                } else {
                    UserDTO user = new UserDTO(userID, fullName, password, null, email, true);
                    boolean checkCreate = dao.create(user);
                    if (checkCreate) {
                        url = LOGIN_PAGE;
                        request.setAttribute("MESSAGE", "User Created Successfully!");
                    } else {
                        userError.setUserErrorCreate("Unknown Error");
                        request.setAttribute("USER_ERROR", userError);
                    }
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            log("Error at RegisterController:" + ex.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
