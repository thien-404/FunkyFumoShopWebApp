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
public class CookieController extends HttpServlet {

    private final static String LOGIN_PAGE = "login.jsp";
    private static final String USER_PAGE = "user.jsp";
    private static final String ADMIN_PAGE = "admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = LOGIN_PAGE;
        try {
            Cookie[] cookies = request.getCookies();
            String username = null;
            String password = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String key = cookie.getName();
                    String value = cookie.getValue();
                    if ("USER_ID".equals(key)) {
                        username = value;
                    }
                    if ("PASSWORD".equals(key)) {
                        password = value;
                    }
                }
                if (username != null && password != null) {
                    UserDAO dao = new UserDAO();
                    UserDTO user = dao.checkLogin(username, password);
                    String role = user.getRoleID();
                    if (user != null) {
                        if (role.equals("AD")) {
                            url = ADMIN_PAGE;
                        } else if (role.equals("US")) {
                            url = USER_PAGE;
                        }
                        //tao HttpSession de luu thong tin account lau dai'
                        //tham so tru co nghia la neu chua co session thi tao moi
                        HttpSession session = request.getSession(true);
                        //dinh du lieu vao session
                        session.setAttribute("LOGIN_USER", user);
                    }
                }
            }
        } catch (Exception e) {
            log("Error at CookieController : " + e.toString());
        } finally {
            response.sendRedirect(url);
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
