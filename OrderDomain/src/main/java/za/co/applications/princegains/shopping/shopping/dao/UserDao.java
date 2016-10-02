package za.co.applications.princegains.shopping.shopping.dao;


import za.co.applications.princegains.shopping.shopping.model.SystemUser;

public interface UserDao {

	SystemUser findById(int id);
	
	SystemUser findBySSO(String sso);

	SystemUser createUser(SystemUser systemUser);
}

