package com.dev.dao.impl;

import com.dev.dao.FileDAO;
import com.dev.model.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileDAOImpl implements FileDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void addFile(File file) {
        getCurrentSession().save(file);
    }

    public void updateFile(File file) {
        File fileUpdate = getFile(file.getId());
        fileUpdate.setId(file.getId());
        fileUpdate.setFileName(file.getFileName());
        getCurrentSession().update(fileUpdate);

    }

    public File getFile(int id) {
        File file = (File) getCurrentSession().get(File.class, id);
        return file;
    }

    public void deleteFile(int id) {
        File file= getFile(id);
        if (file != null)
            getCurrentSession().delete(file);

    }
    public int addFileWithId(File file){
        int id = (int)getCurrentSession().save(file);
        System.out.println(id);
        return id;
    }

    @SuppressWarnings("unchecked")
    public List<File> getFiles() {
        return getCurrentSession().createQuery("from File").list();
    }
}
