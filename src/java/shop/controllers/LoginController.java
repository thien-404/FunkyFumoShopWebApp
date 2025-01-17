/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import shop.users.UserDAO;
import shop.users.UserDTO;


/**
 *
 * @author Shirakami Mishino
 */
public class LoginController extends HttpServlet {


    private static final String LOGIN_PAGE="login.jsp";
    private static final String USER_PAGE="SearchProductController";
    private static final String ADMIN_PAGE="admin.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= LOGIN_PAGE;
        try{
            String userID= request.getParameter("userID");
            String password= request.getParameter("password");
            UserDAO dao= new UserDAO();
            UserDTO loginUser= dao.checkLogin(userID, password);
            if(loginUser!=null){
                //tra ve null khi userID hay password sai
                if("AD".equals(loginUser.getRoleID())){
                    url=ADMIN_PAGE;
                }else if("US".equals(loginUser.getRoleID())){
                    url=USER_PAGE;
                }
                HttpSession session = request.getSession(true);
                session.setAttribute("LOGIN_USER",loginUser);
                    Cookie c_userID = new Cookie("USER_ID",userID);
                    Cookie c_password = new Cookie("PASSWORD",password);
                    response.addCookie(c_userID);
                    response.addCookie(c_password);             
            }else
            {
                request.setAttribute("MESSAGE", "Wrong userID/Password");
            }
        }catch(Exception e){
            log("Error at LoginController"+e.toString());
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
