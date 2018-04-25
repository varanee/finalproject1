package com.example.macpro.newproject;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import java.util.List;

public class UserManage {

    private DatabaseHandler db;
    private List<Users> users;

    public UserManage(Context context) {
        db = new DatabaseHandler(context);
    }

    public boolean checkLoginValidate(String username, String password) {

        users = db.getAllUsers();

        String[] user = new String[users.size()];
        String[] pass = new String[users.size()];

        for (int i = 0; i < user.length; i++) {
            user[i] = users.get(i)._users_name;
            pass[i] = users.get(i)._password;

            if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && username.equalsIgnoreCase(user[i]) && password.equalsIgnoreCase(pass[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean registerUser(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            return false;
        }
        Users user = new Users();
        user._users_name = username;
        user._password = password;
        db.addUsers(user);
        return true;
    }
}
