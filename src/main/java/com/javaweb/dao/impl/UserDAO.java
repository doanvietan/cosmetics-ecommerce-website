package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaweb.dao.IUserDAO;
import com.javaweb.model.UserModel;

public class UserDAO implements IUserDAO{

	@Override
	public UserModel findByUsernameAndPassword(String userName, String passWord) {
		UserModel user = null;
		try {
            Connection conn = DatabaseDAO.getConnection();
            String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassWord(rs.getString(4));
                user.setPhoneNumber(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setRole(rs.getString(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
	}

	@Override
	public UserModel findById(int userId) {
		UserModel user = null;
		try {
            Connection conn = DatabaseDAO.getConnection();
            String sql = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setPassWord(rs.getString(4));
                user.setPhoneNumber(rs.getString(5));
                user.setAddress(rs.getString(6));
                user.setRole(rs.getString(7));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
	}
	
	@Override
	public List<UserModel> findAllUser() {
	    List<UserModel> users = new ArrayList<>();
	    try {
	        Connection conn = DatabaseDAO.getConnection();
	        String sql = "SELECT * FROM users";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            UserModel user = new UserModel();
	            user.setUserId(rs.getInt("user_id"));
	            user.setUserName(rs.getString("user_name"));
	            user.setEmail(rs.getString("email"));
	            user.setPassWord(rs.getString("password"));
	            user.setPhoneNumber(rs.getString("phone_number"));
	            user.setAddress(rs.getString("address"));
	            user.setRole(rs.getString("role"));
	            users.add(user);
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return users;
	}
	
	@Override
	public void insertUser(UserModel user) {
	    try (Connection conn = DatabaseDAO.getConnection()) {
	        String sql = "INSERT INTO users (user_name, email, password, phone_number, address, role) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getUserName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassWord());
	        ps.setString(4, user.getPhoneNumber());
	        ps.setString(5, user.getAddress());
	        ps.setString(6, user.getRole());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public void updateUser(UserModel user) {
	    try (Connection conn = DatabaseDAO.getConnection()) {
	        String sql = "UPDATE users SET user_name=?, email=?, password=?, phone_number=?, address=?, role=? WHERE user_id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, user.getUserName());
	        ps.setString(2, user.getEmail());
	        ps.setString(3, user.getPassWord());
	        ps.setString(4, user.getPhoneNumber());
	        ps.setString(5, user.getAddress());
	        ps.setString(6, user.getRole());
	        ps.setInt(7, user.getUserId());
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public boolean deleteUser(int userId) {
	    String sql = "DELETE FROM users WHERE user_id = ?";
	    try (Connection conn = DatabaseDAO.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setInt(1, userId);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false; // lỗi xảy ra thì trả về false
	    }
	}



}
