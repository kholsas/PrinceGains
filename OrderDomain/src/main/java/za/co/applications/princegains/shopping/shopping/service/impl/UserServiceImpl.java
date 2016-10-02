package za.co.applications.princegains.shopping.shopping.service.impl;


import za.co.applications.princegains.shopping.shopping.dao.UserDao;
import za.co.applications.princegains.shopping.shopping.dao.UserDaoImpl;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao dao = UserDaoImpl.getInstance();
    private static final UserService INSTANCE = new UserServiceImpl();
    private static Map<String, Boolean> listOfAuthenticatedUsers = new HashMap<>();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public SystemUser findById(int id) {
        return dao.findById(id);
    }

    public SystemUser findBySso(String sso) {
        return dao.findBySSO(sso);
    }

    @Override
    public SystemUser logIn(String username, String password) {
        SystemUser systemUser = dao.findBySSO(username);
        if (systemUser != null) {
            if (systemUser.getPassword() != null && systemUser.getPassword().equalsIgnoreCase(password)) {
                listOfAuthenticatedUsers.put(username, true);
                return systemUser;
            }
        }
        return null;
    }

    @Override
    public void logoff(String username) {
        listOfAuthenticatedUsers.remove(username);
    }

    @Override
    public Boolean isAuthenticated(String username) {
        return listOfAuthenticatedUsers.get(username);
    }

    @Override
    public SystemUser createUser(SystemUser systemUser){
        return dao.createUser(systemUser);
    }
}
