package com.example.gavrielsappv1;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.gavrielsappv1.entity.Task;
import com.example.gavrielsappv1.entity.TaskList;
public class taskListAdapter extends BaseAdapter {

    private TaskList taskList;
    private LayoutInflater inflter;

    public taskListAdapter(Context applicationContext, TaskList taskList) {
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
        TextView description = (TextView) view.findViewById(R.id.tvDescription);
        TextView date = (TextView) view.findViewById(R.id.tvDate);
        int mods = this.getItem(position).getMod();
        name.setText(this.getItem(position).getName());
        description.setText(this.getItem(position).getDescription());
        switch (mods) {
            case 0:
                date.setText("until: "+this.getItem(position).getDate().toString());
                break;
            case 1:
                date.setText("on: "+this.getItem(position).getDate().toString());
                break;
            case 2:
                date.setVisibility(View.GONE);
                break;
        }
        return view;
    }
}
