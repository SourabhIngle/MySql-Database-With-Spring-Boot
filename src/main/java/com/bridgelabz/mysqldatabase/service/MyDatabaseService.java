package com.bridgelabz.mysqldatabase.service;


import com.bridgelabz.mysqldatabase.dto.MyDatabaseDTO;
import com.bridgelabz.mysqldatabase.exception.CustomException;
import com.bridgelabz.mysqldatabase.model.MyDatabase;
import com.bridgelabz.mysqldatabase.repository.MyDatabaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyDatabaseService {

    @Autowired
    private MyDatabaseRepo myDatabaseRepo;

    public MyDatabase addMessage(MyDatabaseDTO myDatabaseDTO) {
        MyDatabase myDatabaseData = new MyDatabase(myDatabaseDTO);
        return myDatabaseRepo.save(myDatabaseData);
    }

    public MyDatabase getById(long id) {
        return myDatabaseRepo.findById(id).orElseThrow(() -> new CustomException("Message with id: " + id + " Not Present"));
    }

    public MyDatabase updateMessage(long id, MyDatabaseDTO myDatabaseDTO) {
        MyDatabase myDatabaseData = getById(id);
        if (myDatabaseData != null) {
            myDatabaseData.updateMessage(myDatabaseDTO);
            return myDatabaseRepo.save(myDatabaseData);
        }
        return null;
    }

    public List<MyDatabase> getAllMessage() {
        return myDatabaseRepo.findAll();
    }


    public boolean deleteMessageById(long id) {
        if (myDatabaseRepo.existsById(id)) {
            myDatabaseRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
