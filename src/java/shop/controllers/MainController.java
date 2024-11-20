/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SonLe
 */
public class MainController extends HttpServlet {

    //default welcome
    private static final String WELCOME = "login.jsp";

    //cookie
    private static final String COOKIE_CONTROLLER = "CookieController";

    //login
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";

    //logout
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";

    //register
    private static final String REGISTER_PAGE = "RegisterPage";
    private static final String REGISTER_PAGE_VIEW = "register.jsp";
    private static final String REGISTER = "Register";
    private static final String REGISTER_CONTROLLER = "RegisterController";

    //search user
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";

    //update user
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "UpdateController";

    //delete user
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteController";

    //search product
    private static final String SEARCH_PRODUCT = "SearchProduct";
    private static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";

    //delete product
    private static final String DELETE_PRODUCT = "DeleteProduct";
    private static final String DELETE_PRODUCT_CONTROLLER = "DeleteProductController";

    //update product
    private static final String UPDATE_PRODUCT = "UpdateProduct";
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";

    //add product
    private static final String ADD_PRODUCT_PAGE = "AddProductPage";
    private static final String ADD_PRODUCT_PAGE_VIEW = "addProduct.jsp";
    private static final String ADD_PRODUCT = "AddProduct";
    private static final String ADD_PRODUCT_CONTROLLER = "AddProductController";

    //user profile
    private static final String USER_PROFILE_PAGE = "UserProfile";
    private static final String USER_PAGE_VIEW = "user.jsp";

    //update user
    private static final String UPDATE_USER_INFO = "UpdateUserInfo";
    private static final String UPDATE_USER_INFO_CONTROLLER = "UpdateUserInfoController";
    
    //view order detail (MOI ADD)
    private static final String VIEW_USER_ORDER = "viewUserOrder";
    private static final String VIEW_USER_ORDER_CONTROLLER = "ViewUserOrderController";
    
    //view cart
    private static final String VIEW_CART = "ViewCart";
    private static final String VIEW_CART_PAGE = "viewCart.jsp";

    //add to cart
    private static final String ADD_TO_CART = "AddToCart";
    private static final String ADD_TO_CART_CONTROLLER = "AddToCartController";

    //update cart
    private static final String UPDATE_CART = "UpdateCart";
    private static final String UPDATE_CART_CONTROLLER = "UpdateCartController";

    //remove cart
    private static final String REMOVE_CART = "RemoveCart";
    private static final String REMOVE_CART_CONTROLLER = "RemoveCartController";
    
    //viewOrderAdmin
    private static final String VIEW_ORDER_ADMIN = "SearchOrder";
    private static final String VIEW_ORDER_ADMIN_CONTROLLER = "ViewOrderAdminController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = COOKIE_CONTROLLER;
        try {
            String action = request.getParameter("action");
            if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                url = LOGOUT_CONTROLLER;
            } else if (REGISTER_PAGE.equals(action)) {
                url = REGISTER_PAGE_VIEW;
            } else if (REGISTER.equals(action)) {
                url = REGISTER_CONTROLLER;
            } else if (SEARCH_PRODUCT.equals(action)) {
                url = SEARCH_PRODUCT_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (UPDATE_PRODUCT.equals(action)) {
                url = UPDATE_PRODUCT_CONTROLLER;
            } else if (DELETE_PRODUCT.equals(action)) {
                url = DELETE_PRODUCT_CONTROLLER;
            } else if (ADD_PRODUCT_PAGE.equals(action)) {
                url = ADD_PRODUCT_PAGE_VIEW;
            } else if (ADD_PRODUCT.equals(action)) {
                url = ADD_PRODUCT_CONTROLLER;
            } else if (USER_PROFILE_PAGE.equals(action)) {
                url = USER_PAGE_VIEW;
            } else if (UPDATE_USER_INFO.equals(action)) {
                url = UPDATE_USER_INFO_CONTROLLER;
            } else if (VIEW_CART.equals(action)) {
                url = VIEW_CART_PAGE;
            } else if (ADD_TO_CART.equals(action)) {
                url = ADD_TO_CART_CONTROLLER;
            } else if (UPDATE_CART.equals(action)) {
                url = UPDATE_CART_CONTROLLER;
            } else if (REMOVE_CART.equals(action)) {
                url = REMOVE_CART_CONTROLLER;
            } else if(VIEW_USER_ORDER.equals(action)){ //moi add
                url = VIEW_USER_ORDER_CONTROLLER;
            } else if(VIEW_ORDER_ADMIN.equals(action)){
                url = VIEW_ORDER_ADMIN_CONTROLLER;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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
