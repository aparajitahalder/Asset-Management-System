package service;

import java.util.List;

import beans.User;
import Exceptions.EmailAlreadyExistsException;
import Exceptions.UserNotFoundException;

public interface UserInterface {
	
	// method that will register user for the first time in database
	public int RegisterUser(User user) throws  EmailAlreadyExistsException;
	// method that will login existing user in database
	public int LoginUser(String email,String password) throws  EmailAlreadyExistsException, UserNotFoundException;
	// method that will give access to admin to import a list of valid users in database
	public int uploadArrayOfUsers(String path) throws Exception;
	// method to get user by id
	public User getUserById(int id) throws UserNotFoundException;
	// method to get all users
	public List<User> getAllUsers() throws UserNotFoundException;
	
	
	

}
