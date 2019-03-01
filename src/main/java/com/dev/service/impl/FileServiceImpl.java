package com.dev.service.impl;

import com.dev.dao.FileDAO;
import com.dev.model.File;
import com.dev.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDAO fileDAO;

    public void insert(File file) {
        fileDAO.addFile(file);
    }

    public int insertWithId(File file){
        return fileDAO.addFileWithId(file);
    }

    public void update(File file) {
        fileDAO.updateFile(file);
    }

    public File getById(int id) {
        return fileDAO.getFile(id);
    }

    public void delete(int id) {
        fileDAO.deleteFile(id);
    }

    public List<File> getAll() {
        return fileDAO.getFiles();
    }

}
