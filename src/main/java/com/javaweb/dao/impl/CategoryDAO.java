package com.javaweb.dao.impl;

import java.sql.*;
import java.util.*;
import com.javaweb.dao.ICategoryDAO;
import com.javaweb.model.CategoryModel;

public class CategoryDAO implements ICategoryDAO {


    @Override
    public List<CategoryModel> findAllCategory() {
        List<CategoryModel> list = new ArrayList<>();
        String sql = "SELECT * FROM categories";

        try (Connection conn = DatabaseDAO.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setCategoryId(rs.getInt("category_id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                list.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
