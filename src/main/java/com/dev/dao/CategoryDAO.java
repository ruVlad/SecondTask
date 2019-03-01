package com.dev.dao;

import com.dev.model.Category;

import java.util.List;


public interface CategoryDAO {

    public void addCategory(Category category);
    public void updateCategory(Category category);
    public Category getCategory(int id);
    public void deleteCategory(int id);
    public List<Category> getCategorys();

    public int getIdByCategoryName(String categoryName);

}