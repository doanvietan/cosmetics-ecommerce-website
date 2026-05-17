package com.javaweb.dao;


import com.javaweb.model.UserModel;
import java.util.List;


public interface IUserDAO {
	UserModel findByUsernameAndPassword(String userName, String passWord);
	UserModel findById(int userId);
	List<UserModel> findAllUser();
	void updateUser(UserModel user);
	boolean deleteUser(int userId);
	void insertUser(UserModel user);
}
