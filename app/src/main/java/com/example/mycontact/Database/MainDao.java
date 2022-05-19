package com.example.mycontact.Database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mycontact.Models.ContactModel;

import java.util.List;

@Dao
public interface MainDao {

    @Insert(onConflict = REPLACE)
    void insert(ContactModel contactModel);


    @Query("SELECT * FROm contactinfo ORDER By id desc ")
    List<ContactModel> getAll();

    @Delete
    void delete(ContactModel contactModel);
    @Query("update ContactInfo set Name = :name, Number = :number where id = :id")
    void update(int id, String name, String number);
}
