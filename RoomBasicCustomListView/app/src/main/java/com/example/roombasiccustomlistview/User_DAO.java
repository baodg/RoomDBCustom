package com.example.roombasiccustomlistview;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public interface User_DAO {
    @Insert
    void addUser(User user);
    @Query("Select * from user_table")
    List<User> getAllUser();
    @Delete
    void removeUser(User user);

    @Update
    void updateUser(User user);
}
