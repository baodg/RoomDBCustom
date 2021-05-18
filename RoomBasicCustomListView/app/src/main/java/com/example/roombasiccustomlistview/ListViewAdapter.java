package com.example.roombasiccustomlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    Context ctx;
    private int layoutItem;
    List<User> lstUser;

    public ListViewAdapter(Context ctx,int layoutItem, List<User> arrayList){
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.lstUser = arrayList;
    }

    @Override
    public int getCount() {
        return lstUser.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view , ViewGroup parent) {
        view = LayoutInflater.from(ctx).inflate(layoutItem,parent,false);
        TextView txtName = view.findViewById(R.id.txtName);
        txtName.setText(lstUser.get(i).getName());
        return view;
    }
}
