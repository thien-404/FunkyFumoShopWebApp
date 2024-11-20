/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import shop.products.ProductDAO;
import shop.products.ProductDTO;
import shop.products.ProductError;

/**
 *
 * @author anhdt
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {


    private static final String ERROR = "addProduct.jsp";
    private static final String SUCCESS = "SearchProductController?siteUrl=admin.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        ProductError productError = new ProductError();
        try {
            String productID = request.getParameter("productID");
            String name = request.getParameter("name");
            String srcImg = request.getParameter("srcImg");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Boolean status = Boolean.parseBoolean(request.getParameter("status"));

            boolean check = true;
            ProductDAO dao = new ProductDAO();
            boolean checkDuplicate = dao.checkDuplicate(productID);
            if (checkDuplicate) {
                check = false;
                productError.setProductID("Duplicate productID");
            } else {
                if (name.trim().length() < 2 | name.trim().length() > 50) {
                    check = false;
                    productError.setName("Product name must be in length from 2 to 50.");
                }

                if (price <= 0) {
                    check = false;
                    productError.setPrice("Price must be positive");
                }

                if (quantity < 0) {
                    check = false;
                    productError.setQuantity("Quantity must be positive");
                }

                if (productID.trim().length() > 50) {
                    check = false;
                    productError.setProductID("Product ID length can't be more than 50!");
                }

                if (check) {
                    ProductDTO product = new ProductDTO(productID, name, srcImg, price, quantity, status);
                    boolean checkCreate = dao.addNewProduct(product);
                    if (checkCreate) {
                        url = SUCCESS;
                        request.setAttribute("MESSAGE", "Added product successfully.");
                    }
                }
            }
            request.setAttribute("PRODUCT_ERROR", productError);

        } catch (Exception e) {
            log("Error at AddProductController: " + e.toString());
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
