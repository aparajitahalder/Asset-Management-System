package service;

import java.util.List;

import beans.User;
import dao.UserDao;
import dao.UserDaoImpl;
import Exceptions.EmailAlreadyExistsException;
import Exceptions.UserNotFoundException;

public class UserInterfaceImpl implements UserInterface {
	
	UserDao dao;
	public UserInterfaceImpl(){
		dao=new UserDaoImpl();
	}

	@Override
	public int RegisterUser(User user) throws EmailAlreadyExistsException {
		int status=dao.registerUser(user);
		return status;
	}

	@Override
	public int LoginUser(String email, String password) throws EmailAlreadyExistsException, UserNotFoundException {
		int status=dao.loginUser(email, password);
		return status;
	}

	@Override
	public int uploadArrayOfUsers(String path) throws Exception {
		int status=dao.importUser(path);
		return status;
	}

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		User user=dao.displayUserWithId(id);
		return user;
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		List<User>users=dao.displayAllUser();
		return users;
	}

}
