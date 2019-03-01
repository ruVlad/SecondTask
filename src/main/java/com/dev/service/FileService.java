package com.dev.service;

import com.dev.model.File;

import java.util.List;

public interface FileService {

    public void insert(File file);
    public int insertWithId(File file);
    public void update(File file);
    public File getById(int id);
    public void delete(int id);
    public List<File> getAll();
}
