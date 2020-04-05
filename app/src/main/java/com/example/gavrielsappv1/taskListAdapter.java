package com.example.gavrielsappv1;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gavrielsappv1.entity.Task;

import java.util.ArrayList;

public class taskListAdapter extends BaseAdapter {

    private ArrayList<Task> taskList;
    private LayoutInflater inflter;

    taskListAdapter(Context applicationContext, ArrayList<Task> taskList) {
        this.taskList = taskList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return taskList.size();
    }

    @Override
    public Task getItem(int position) {
        return taskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return taskList.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflter.inflate(R.layout.adaper_view_layout, null);
        TextView name = (TextView) view.findViewById(R.id.tvName);
        name.setText(this.getItem(position).getName());
        TextView description = (TextView) view.findViewById(R.id.tvDescription);
        description.setText(this.getItem(position).getDescription());
        return view;
    }
}
