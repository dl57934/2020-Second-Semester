package com.example.addressbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<UserInfo> elements;

    public MyAdapter(Context context, ArrayList<UserInfo> data) {
        mContext = context;
        elements = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return elements.size();
    }

    @Override
    public Object getItem(int i) {
        return elements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int pos, View view2, ViewGroup viewGroup) {
        View view = mLayoutInflater.inflate(R.layout.listview_item, null);

        TextView nameText = view.findViewById(R.id.nameText);
        TextView ageText = view.findViewById(R.id.ageText);
        TextView phoneText = view.findViewById(R.id.phoneText);

        nameText.setText(elements.get(pos).getName());
        ageText.setText(String.valueOf(elements.get(pos).getAge()));
        phoneText.setText(elements.get(pos).getPhoneNumber());
        return view;
    }
}
