package com.bridgelabz.mysqldatabase.controller;

import com.bridgelabz.mysqldatabase.dto.MyDatabaseDTO;
import com.bridgelabz.mysqldatabase.dto.ResponseDTO;
import com.bridgelabz.mysqldatabase.model.MyDatabase;
import com.bridgelabz.mysqldatabase.repository.MyDatabaseRepo;
import com.bridgelabz.mysqldatabase.service.MyDatabaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyDatabaseController {

    @Autowired
    private MyDatabaseRepo myDatabaseRepo;

    @Autowired
    private MyDatabaseService myDatabaseService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addMessage(@Valid @RequestBody MyDatabaseDTO myDatabaseDTO) {
        ResponseDTO responseDTO = new ResponseDTO("Data Add Successfully", myDatabaseService.addMessage(myDatabaseDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<MyDatabase> getAllMessage() {
        return myDatabaseService.getAllMessage();
    }

    // for set data => @RequestBody Message message
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateMessage(@PathVariable long id, @Valid @RequestBody MyDatabaseDTO myDatabaseDTO) {
        MyDatabase myDatabase = myDatabaseService.updateMessage(id, myDatabaseDTO);
        ResponseDTO responseDTO = new ResponseDTO("Data Updated Successfully", myDatabase);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    // we can use @RequestParam also = @GetMapping("/getbyid")id
    // local-8090/getById?id=1
    @GetMapping("/getbyid/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable long id) {
        ResponseDTO responseDTO = new ResponseDTO("Data Fetched Successfully", myDatabaseService.getById(id));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    // we can use @RequestParam also = @GetMapping("/deleteByid")
    // local-8090/deleteById?id=1
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMessageById(@PathVariable long id) {
        boolean deleted = myDatabaseService.deleteMessageById(id);
        if (deleted) {
            return ResponseEntity.ok("Data with Id " + id + " deleted successfully");
        }
        return ResponseEntity.ok("Data Id " + id + " Not Found");
    }
}
