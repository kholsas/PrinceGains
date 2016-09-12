package za.co.applications.princegains.shopping.shopping.service;


import za.co.applications.princegains.shopping.shopping.model.SystemUser;

public interface UserService {

	SystemUser findById(int id);
	
	SystemUser findBySso(String sso);
	
}