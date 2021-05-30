package javaKampSpring.northwind.core.dateAcces;

import org.springframework.data.jpa.repository.JpaRepository;

import javaKampSpring.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User getByEmail(String email);
	

}
