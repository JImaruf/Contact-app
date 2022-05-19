package com.example.mycontact.Models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "ContactInfo")
public class ContactModel implements Serializable {


    @PrimaryKey(autoGenerate = true)
    int id = 0;

    @ColumnInfo(name = "Name")
    String ContactName="";

    @ColumnInfo(name = "Number")
    String ContactNumber="";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }
}
