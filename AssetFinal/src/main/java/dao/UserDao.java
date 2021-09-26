package dao;

import java.util.List;

import beans.User;
import Exceptions.EmailAlreadyExistsException;
import Exceptions.UserNotFoundException;

public interface UserDao {

	public int loginUser(String unmae, String pswd) throws UserNotFoundException;

	public int registerUser(User u) throws EmailAlreadyExistsException;

	public int importUser(String path) throws Exception;

	public List<User> displayAllUser();

	public User displayUserWithId(int id) throws UserNotFoundException;

}
