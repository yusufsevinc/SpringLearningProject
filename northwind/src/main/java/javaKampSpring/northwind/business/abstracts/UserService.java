package javaKampSpring.northwind.business.abstracts;

import javaKampSpring.northwind.core.entities.User;
import javaKampSpring.northwind.core.utilities.results.DataResult;
import javaKampSpring.northwind.core.utilities.results.Result;

public interface UserService {
	Result add(User user);
	DataResult<User> getByEmail(String email);
}
