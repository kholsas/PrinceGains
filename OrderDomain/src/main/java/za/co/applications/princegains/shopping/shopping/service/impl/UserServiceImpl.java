package za.co.applications.princegains.shopping.shopping.service.impl;


import za.co.applications.princegains.shopping.shopping.dao.UserDao;
import za.co.applications.princegains.shopping.shopping.dao.UserDaoImpl;
import za.co.applications.princegains.shopping.shopping.model.SystemUser;
import za.co.applications.princegains.shopping.shopping.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao = UserDaoImpl.getInstance();
private static final UserService INSTANCE = new UserServiceImpl();
	public static UserService getInstance(){
		return INSTANCE;
	}

	public SystemUser findById(int id) {
		return dao.findById(id);
	}

	public SystemUser findBySso(String sso) {
		return dao.findBySSO(sso);
	}

}
