package com.dev.dao.impl;

import com.dev.dao.CategoryDAO;
import com.dev.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategotyDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addCategory(Category category) {
        getCurrentSession().save(category);
    }

    public void updateCategory(Category category) {
        Category categoryUpdate = getCategory(category.getId());
        categoryUpdate.setId(category.getId());
        categoryUpdate.setName(category.getName());
        getCurrentSession().update(categoryUpdate);

    }

    public Category getCategory(int id) {
        Category category= (Category) getCurrentSession().get(Category.class, id);
        return category;
    }

    public void deleteCategory(int id) {
        Category category= getCategory(id);
        if (category != null)
            getCurrentSession().delete(category);

    }

    public int getIdByCategoryName(String categoryName){
        int id = (int) getCurrentSession().get(Category.class, categoryName);
        return  id;
    }

    @SuppressWarnings("unchecked")
    public List<Category> getCategorys() {
        return getCurrentSession().createQuery("from Category").list();
    }
}
