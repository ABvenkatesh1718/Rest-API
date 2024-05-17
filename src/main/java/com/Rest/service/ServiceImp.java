package com.Rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Rest.Repository.userRepo;
import com.Rest.entity.User;
import com.Rest.model.LoginModel;
import com.Rest.model.PasswordModel;

@Service
public class ServiceImp implements ServiceInfo {

	@Autowired
	userRepo repo;
	 
	
	@Override
	public void adduser(User user) {
		 repo.save(user);
		 System.out.println("user is saved");	  
		
	}

	@Override
	public String LoginChecking(LoginModel logindata) {
		 String name=logindata.getName();
		 String password=logindata.getPassword();
		 
		 List<User> list = repo.findByNameAndPassword(name, password);
		 
		 if(list.isEmpty()) {
			 return " wrong inputs "+" try again ";
		 }
		 return "login successfully";
		
	}

	@Override
	public String updatePasswordById(PasswordModel passwordmodel) {
		// TODO Auto-generated method stub
		
		int id=passwordmodel.getId();
		String password=passwordmodel.getPassword();
		
		User user= repo.findById(id).get();
		
		if(user!=null) {
			user.setPassword(password);
			repo.save(user);
			return "password is updated successfully";
		}
		
		return "wrong id ";
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user = repo.findById(id);
		
		if(user.isPresent()) {
			repo.deleteById(id);
			return "successfully deleted";
		}
		return "try again with valid id";
	}

	@Override
	public String getTheDataByid(int id) {
		// TODO Auto-generated method stub
		
		Optional<User> checking= repo.findById(id);
		
		if(checking.isPresent()) {
			User user = checking.get();
			
			return user.toString();
		}
		
		
		return "try again with valid id";
	}

	 
	 
	
	
	 

	 
	 

	 
	

}
