package com.Rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Rest.entity.User;
import com.Rest.model.LoginModel;
import com.Rest.model.PasswordModel;
import com.Rest.service.ServiceInfo;



@RestController
@CrossOrigin(origins = "*")
public class MyController {
	
	@Autowired
	ServiceInfo serviceInfo;
		
	@PostMapping("user/register")
	public String Register(@RequestBody User user) {	
		System.out.println(user.toString());
		serviceInfo.adduser(user);
		
		return user.toString()+" data is added to database successfully "+" congrats ";
	}
	
	
	@PostMapping("user/login")
	public String login(@RequestBody LoginModel logindata) {
		
		String loginChecking = serviceInfo.LoginChecking(logindata);
		return loginChecking;	
	}
	
	@PostMapping("user/updatePassword")
	public String updatePasswordById(@RequestBody PasswordModel passwordmodel) {	
		
		String result=serviceInfo.updatePasswordById(passwordmodel);	
		return result;
	}
	
	
	@DeleteMapping("user/deleteById/{id}")
	public String deleteById(@PathVariable("id") int id) {
		
		String result=serviceInfo.deleteById(id);	
		return result;
		 
	}
	
	
	@GetMapping("getTheDataById/{id}")
	public String getTheDataById(@PathVariable("id") int id) {
		
		String result=serviceInfo.getTheDataByid(id);
		return result;
		
	}
	

	 
	
	
	
	
	
	
	
	

}
