//this may need to go to the parking lot for now since we are having the admin set up the user in order to control
//their role.  How do we have the admin assign a temp pw?

package com.digitalfilingcabinet.demo.models.dto;

public class RegisterFormDTO extends LoginFormDTO{

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
