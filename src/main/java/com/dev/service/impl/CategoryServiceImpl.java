package com.dev.service.impl;

import com.dev.dao.CategoryDAO;
import com.dev.model.Category;
import com.dev.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDAO categoryDAO;

	public void insert(Category category) {
		categoryDAO.addCategory(category);
	}

	public void update(Category category) {
		categoryDAO.updateCategory(category);
	}

	public Category getById(int id) {
		return categoryDAO.getCategory(id);
	}

	public void delete(int id) {
		categoryDAO.deleteCategory(id);
	}

	public List<Category> getAll() {
		return categoryDAO.getCategorys();
	}

	public int getIdByName(String name){
		return categoryDAO.getIdByCategoryName(name);
	}

}
