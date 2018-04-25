package com.example.macpro.newproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Contact{

    public int _id;
    public String _name;
    public String _phone_number;
    public String _email;
    public String _img_path;

    public Contact() {
    } //for getAllContacts

    public Contact(int _id) {// for delete
        this._id = _id;

    }
}
