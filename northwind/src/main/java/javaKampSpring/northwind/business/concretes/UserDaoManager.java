package javaKampSpring.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaKampSpring.northwind.business.abstracts.UserService;
import javaKampSpring.northwind.core.dateAcces.UserDao;
import javaKampSpring.northwind.core.entities.User;
import javaKampSpring.northwind.core.utilities.results.DataResult;
import javaKampSpring.northwind.core.utilities.results.Result;
import javaKampSpring.northwind.core.utilities.results.SuccesDataResult;
import javaKampSpring.northwind.core.utilities.results.SuccessResult;

@Service
public class UserDaoManager implements UserService{

	private UserDao userDao;
	
	
	@Autowired
	public UserDaoManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi..");
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
		return new SuccesDataResult<User>(this.userDao.getByEmail(email),"Kullanıcı bulundu..");
	}

}
