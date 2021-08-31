package com.example.listview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<ContactModel> listContacts;
    private Activity activity;

    public ContactAdapter(List<ContactModel> listContacts, Activity activity) {
        this.listContacts = listContacts;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int i) {
        return listContacts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.itemt_contact,viewGroup,false);
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) view.findViewById(R.id.tvName);
            holder.tvPhone = (TextView) view.findViewById(R.id.tvPhone);
            holder.ivAvatar = (ImageView) view.findViewById(R.id.ivAvatar);
            view.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        ContactModel model = listContacts.get(i);
        holder.tvPhone.setText(model.getPhone());
        holder.tvName.setText(model.getName());
        holder.ivAvatar.setImageResource(model.getImage());
        return view;
    }
    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
    }
}
