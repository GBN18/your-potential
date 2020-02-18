package com.example.gavrielsappv1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.gavrielsappv1.entity.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

public class TaskList extends AppCompatActivity {

    ArrayList<Task> taskList = new ArrayList<>();
    final ListView lv = (ListView) findViewById(R.id.TaskListView);
    taskListAdapter adapter = new taskListAdapter(this, R.layout.adaper_view_layout, taskList);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        lv.setAdapter(taskListAdapter);
        populateList();
    }

    protected void populateList() {
        for (Integer i = 0; i < 10; i++) {
            taskList.add(new Task(i.toString(),i.toString()));
        }
    }
}
