package com.Rest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Rest.entity.User;




@Repository
public interface userRepo extends JpaRepository<User, Integer> {
	
	
	
	List<User>findByNameAndPassword(String name,String password);
	
	
	List<User> findByName(String name);

}
