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
import javax.servlet.http.HttpSession;
import shop.users.UserDAO;
import shop.users.UserDTO;
import shop.users.userError;
import shop.utils.ValidInputUtils;


public class UpdateUserInfoController extends HttpServlet {

    
    
    private static final String USER_PROFILE_PAGE_VIEW = "user.jsp";
    private static final String LOGIN_PAGE = "login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
        response.setContentType("text/html;charset=UTF-8");
        userError userError = new userError();
        ValidInputUtils valid = new ValidInputUtils();
        String url = USER_PROFILE_PAGE_VIEW;
        try {
            boolean checkValid = true;
            UserDAO dao = new UserDAO();       
            HttpSession session = request.getSession();
            UserDTO LOGIN_USER =(UserDTO) session.getAttribute("LOGIN_USER");
            
            String userID = LOGIN_USER.getUserID();
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String currentPassword = request.getParameter("currentPassword");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirm");
            
            if (!currentPassword.equals(LOGIN_USER.getPassword())){
                checkValid = false;
                userError.setConfirmError("Please enter correct password");
            }
            if (!valid.checkfullNameLenError(fullName)) {
                checkValid = false;
                userError.setFullNameError("Please enter full name length from 2 to 50");
            }            
            if (!valid.checkFormatEmail(email)) {
                checkValid = false;
                userError.setEmailError("Please enter correct format email");
            }
            if(!password.isEmpty() || !confirmPassword.isEmpty()){
                if (!valid.checkPasswordLenError(password)) {
                    checkValid = false;
                    userError.setPasswordError("Please enter password length longer than 4");
                }
                if (!valid.checkConfirm(password, confirmPassword)) {
                    checkValid = false;
                    userError.setConfirmError("Password not match");
                }
                if(checkValid){
                    UserDTO user = new UserDTO(userID, fullName, password, "US", email, true);
                    boolean checkUpdate = dao.updateByUser(user);
                    if (checkUpdate) {
                        url = LOGIN_PAGE;
                        request.setAttribute("MESSAGE", "Updated Successfully. Please login again.");
                    } else {
                        userError.setUserErrorCreate("Unknown Error");
                        request.setAttribute("USER_ERROR", userError);
                    }
                }else{
                    request.setAttribute("USER_ERROR", userError);
                }
            }else if(checkValid){
                UserDTO user = new UserDTO(userID, fullName, LOGIN_USER.getPassword(), "US", email, true);
                    boolean checkUpdate = dao.updateByUser(user);
                    if (checkUpdate) {
                        session.setAttribute("LOGIN_USER", user);
                        request.setAttribute("MESSAGE", "User Updated Successfully!");
                    } else {
                        userError.setUserErrorCreate("Unknown Error");
                        request.setAttribute("USER_ERROR", userError);
                    }
            }else{
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (SQLException ex) {
            log("Error at RegisterController:" + ex.toString());
        }finally{
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
