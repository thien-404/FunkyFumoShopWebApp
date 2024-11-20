package shop.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;
import shop.users.UserDAO;
import shop.users.UserDTO;

/**
 *
 * @author SonLe
 */
@WebServlet(name = "GoogleLoginController", urlPatterns = {"/GoogleLoginController"})
public class GoogleLoginController extends HttpServlet {

    private static final String GOOGLE_CLIENT_ID = "201948420053-6olu5k7oc8omtnf6mvl1vhjm3a1v9d4m.apps.googleusercontent.com";
    private static final String GOOGLE_CLIENT_SECRET = "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";
    private static final String GOOGLE_REDIRECT_URI = "http://localhost:8084/Assignment_Block3W/GoogleLoginController";
    private static final String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
    private static final String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
    private static final String GOOGLE_GRANT_TYPE = "authorization_code";
    private static final String DEFAULT_ROLEID = "US";
    private static final String SUCCESS_NEWUSER = "register.jsp";
    private static final String SUCCESS_OLDUSER = "shopping.jsp";
    private static final String ERROR = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String code = request.getParameter("code");
            String accessToken = getToken(code);
            UserDTO user = getUserInfo(accessToken);
            if (user != null) {
                UserDAO dao = new UserDAO();
                boolean checkExistedUser = dao.checkExistedUser(user.getUserID());
                if (!checkExistedUser) {
                    request.setAttribute("NEW_USER_GOOGLE", user);
                    url = SUCCESS_NEWUSER;
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("LOGIN_USER", user);
                    url = SUCCESS_OLDUSER;
                }

            }
        } catch (Exception e) {
            log("Error at GoogleLoginController. Error detail: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }

    }

    public static String getToken(String code) throws ClientProtocolException, IOException {
        String response = Request.Post(GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", GOOGLE_CLIENT_ID)
                        .add("client_secret", GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
        String link = GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String userID = jobj.get("id").getAsString(); //maybe later use lmeow
        String fullName = jobj.get("name").getAsString();
        String email = jobj.get("email").getAsString();
        String roleID = DEFAULT_ROLEID;
        UserDTO googlePojo = new UserDTO(email, fullName,"", roleID, email,true);

        return googlePojo;
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
