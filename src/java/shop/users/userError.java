/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop.users;

import java.sql.SQLException;
import shop.users.UserDAO;

/**
 *
 * @author Shirakami Mishino
 */
public class userError {
    private String userIDError;
    private String fullNameError;
    private String passwordError;
    private String confirmError;
    private String emailError;
    private String iDExistedError;
    private String userErrorCreate;

    public userError(){
        this.userIDError = "";
        this.fullNameError = "";
        this.passwordError = "";
        this.confirmError = "";
        this.emailError = "";
        this.iDExistedError = "";
        this.userErrorCreate = "";
    }

    public userError(String userIDError, String fullNameError, String passwordError, String confirmError, String EmailError, String IDExistedError, String UserError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.emailError = EmailError;
        this.iDExistedError = IDExistedError;
        this.userErrorCreate = UserError;
    }

    /**
     * @return the userIDError
     */
    public String getUserIDError() {
        return userIDError;
    }

    /**
     * @param userIDError the userIDError to set
     */
    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    /**
     * @return the fullNameError
     */
    public String getFullNameError() {
        return fullNameError;
    }

    /**
     * @param fullNameError the fullNameError to set
     */
    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    /**
     * @return the passwordError
     */
    public String getPasswordError() {
        return passwordError;
    }

    /**
     * @param passwordError the passwordError to set
     */
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    /**
     * @return the confirmError
     */
    public String getConfirmError() {
        return confirmError;
    }

    /**
     * @param confirmError the confirmError to set
     */
    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    /**
     * @return the emailError
     */
    public String getEmailError() {
        return emailError;
    }

    /**
     * @param emailError the emailError to set
     */
    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    /**
     * @return the iDExistedError
     */
    public String getiDExistedError() {
        return iDExistedError;
    }

    /**
     * @param iDExistedError the iDExistedError to set
     */
    public void setiDExistedError(String iDExistedError) {
        this.iDExistedError = iDExistedError;
    }

    /**
     * @return the userErrorCreate
     */
    public String getUserErrorCreate() {
        return userErrorCreate;
    }

    /**
     * @param userErrorCreate the userErrorCreate to set
     */
    public void setUserErrorCreate(String userErrorCreate) {
        this.userErrorCreate = userErrorCreate;
    }
    
}