package com.example.roombasiccustomlistview;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class ConnectDB extends RoomDatabase {
   private  static final String DATABASE_NAME ="UserDB";
   private static ConnectDB instance;
   public static synchronized ConnectDB getInstance(Context ctx){
       if(instance==null){
           instance = Room.databaseBuilder(ctx.getApplicationContext(),
                   ConnectDB.class,DATABASE_NAME)
                   .allowMainThreadQueries()
                   .build();
       }
       return instance;

   }
   public abstract User_DAO userDao();
}
