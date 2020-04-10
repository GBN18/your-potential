package com.example.gavrielsappv1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.gavrielsappv1.R;
import com.example.gavrielsappv1.entity.Task;
import com.example.gavrielsappv1.taskListAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    ArrayList<Task> taskList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        taskList.add(new Task("lol","XD"));
        taskList.add(new Task("lol2","XD"));
        taskListAdapter adapter = new taskListAdapter(homeView.getContext(), taskList);
        final ListView lv = (ListView) homeView.findViewById(R.id.TaskListView);
        lv.setAdapter(adapter);

        return homeView;
    }
}