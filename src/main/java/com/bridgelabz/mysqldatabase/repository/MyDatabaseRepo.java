package com.bridgelabz.mysqldatabase.repository;
//JpaRepository perform to curd operation
import com.bridgelabz.mysqldatabase.model.MyDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDatabaseRepo extends JpaRepository<MyDatabase, Long> {
}
