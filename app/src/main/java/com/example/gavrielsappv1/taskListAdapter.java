package com.example.gavrielsappv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.gavrielsappv1.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class taskListAdapter extends ArrayAdapter<Task> {
    private static final String TAG = "taskListAdapter";
    private Context mContext;
    int mResource;

    public taskListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Task> objects, Context mContext) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String name = getItem(position).getName();
        String description = getItem(position).getDescription();

        Task task = new Task(name, description);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.tvDescription);

        tvName.setText(name);
        tvDescription.setText(description);

        return convertView;
    }
}
