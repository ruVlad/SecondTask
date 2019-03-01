package com.dev.dao;

import com.dev.model.File;

import java.util.List;


public interface FileDAO{

    public void addFile(File file);
    public int addFileWithId(File file);
    public void updateFile(File file);
    public File getFile(int id);
    public void deleteFile(int id);
    public List<File> getFiles();

}
