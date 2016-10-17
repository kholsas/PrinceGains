package za.co.orionencoded.security;

import java.util.Date;

/**
 * Created by kholofelo on 2016/10/17.
 */
public class LoginSession {

    private LoginUser loginUser;
    private Date startDate;
    private Date endDate;
    private String token;

    public LoginUser getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(LoginUser loginUser) {
        this.loginUser = loginUser;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean hasExpired() {
        return new Date().after(this.endDate);
    }
}
