package com.dev.service;

import com.dev.model.Category;

import java.util.List;

public interface CategoryService {
	
	public void insert(Category category);
	public void update(Category category);
	public Category getById(int id);
	public void delete(int id);
	public List<Category> getAll();
	public int getIdByName(String name);
}
