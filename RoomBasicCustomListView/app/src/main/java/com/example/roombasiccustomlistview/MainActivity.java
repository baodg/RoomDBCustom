package com.example.roombasiccustomlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lstView;
    ListViewAdapter adt;
    public static ArrayList<User> lstUser;
    public static List<User> list;
    User_DAO userDao;
    Button btnAdd;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        lstView = findViewById(R.id.lstViewUser);
        editText = findViewById(R.id.edtName);
        btnAdd = findViewById(R.id.btnAdd);

        lstView.setAdapter(adt);

        list = ConnectDB.getInstance(this).userDao().getAllUser();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                ConnectDB.getInstance(MainActivity.this).userDao().addUser(new User(name));

                list = ConnectDB.getInstance(MainActivity.this).userDao().getAllUser();

                adt=new ListViewAdapter(MainActivity.this,R.layout.itemlistview,list);
                lstView.setAdapter(adt);
                editText.setText("");
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getApplicationWindowToken(),0);
            }
        });

    }


    }


