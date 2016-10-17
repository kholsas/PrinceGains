package za.co.orionencoded.security;

import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.service.UserService;
import za.co.applications.princegains.shopping.shopping.service.impl.UserServiceImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kholofelo on 2016/10/17.
 */
public class CustomWebSecurity {

    private static final Map<String, LoginSession> loginSessionsByUsername = new HashMap<>();
    private static final UserService USER_SERVICE = UserServiceImpl.getInstance();

    public LoginUser loginUser(LoginUser loginUser) {

        SystemUser systemUser = USER_SERVICE.findBySso(loginUser.getUsername());

        if (systemUser != null) {
            if (systemUser.getPassword().equals(loginUser.getPassword())) {
                System.out.println("login success");
                loginUser.setLoggedIn(true);
                loginUser.setPassword(null);
                loginUser.setToken(getNewToken(loginUser.getUsername()));

                LoginSession loginSession = new LoginSession();
                loginSession.setToken(loginUser.getToken());
                loginSession.setLoginUser(loginUser);
                loginSession.setStartDate(new Date());
                loginSession.setEndDate(new Date(loginSession.getStartDate().getTime() + getSessionExpiryDuration()));
                loginSessionsByUsername.put(loginUser.getUsername(), loginSession);
            } else {
                System.out.println("Login failed");
                loginUser.setLoggedIn(false);
            }
        }
        return loginUser;
    }

    public LoginUser logoutUser(LoginUser loginUser) {
        LoginSession loginSession = loginSessionsByUsername.remove(loginUser.getUsername());
        resetLoginSession(loginSession);
        return loginSession.getLoginUser();
    }

    public boolean isAuthenticated(String username) {
        LoginSession loginSession = loginSessionsByUsername.get(username);


        if (loginSession == null) {
            return false;
        }
        if (loginSession.hasExpired()) {
            logoutUser(loginSession.getLoginUser());
            return false;
        }
        return true;
    }

    private void resetLoginSession(LoginSession loginSession) {
        loginSession.getLoginUser().setPassword(null);
        loginSession.getLoginUser().setToken(null);
        loginSession.getLoginUser().setLoggedIn(false);
        loginSession.setToken(null);
        loginSession.setStartDate(null);
        loginSession.setEndDate(null);
    }

    private int getSessionExpiryDuration() {
        return 10 * 60 * 1000; // 10 minutes
    }

    /**
     * @param username
     * @return unique string. Username is always unique, so is time
     */
    private String getNewToken(String username) {
        return DigestMD5.digest(username + (new Date().toString()));
    }
}
