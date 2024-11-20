/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.utils;

import java.sql.SQLException;
import shop.users.UserDAO;

/**
 *
 * @author Shirakami Mishino
 */
public class ValidInputUtils {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@gmail.com";

    public boolean checkUserIDLen(String userID) {
        int len = userID.trim().length();
        boolean check = true;
        if (len < 4 || len > 50) {
            check = false;
        }
        return check;
    }

    public boolean checkPasswordLenError(String password) {
        int len = password.trim().length();
        if (len < 4) {
            return false;
        }
        return true;
    }

    public boolean checkfullNameLenError(String fullName) {
        int len = fullName.trim().length();
        if (len < 2 || len > 50) {
            return false;
        }
        return true;
    }

    public boolean checkConfirm(String password, String confirm) {
        if (!password.equals(confirm.trim())) {
            return false;
        }
        return true;
    }

    public boolean checkUserExisted(String userID)
            throws ClassNotFoundException, SQLException {
        UserDAO dao = new UserDAO();
        if (dao.checkExisted(userID.trim())) {
            return false;
        }
        return true;
    }

    public boolean checkFormatEmail(String email) {
        if (!email.trim().matches(EMAIL_REGEX)) {
            return false;
        }
        return true;
    }
}
