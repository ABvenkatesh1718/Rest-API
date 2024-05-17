package com.Rest.service;




import org.springframework.stereotype.Service;

import com.Rest.entity.User;
import com.Rest.model.LoginModel;
import com.Rest.model.PasswordModel;



@Service
public interface ServiceInfo {

	public void adduser(User user);

	public String LoginChecking(LoginModel logindata);

	public String updatePasswordById(PasswordModel passwordmodel);

	public String deleteById(int id);

	public String getTheDataByid(int id);

	 
	 

	 
 

	 

	 

	 

}
