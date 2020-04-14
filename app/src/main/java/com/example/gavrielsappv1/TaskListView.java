package com.example.gavrielsappv1;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.gavrielsappv1.entity.Task;
import com.example.gavrielsappv1.entity.TaskList;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TaskListView extends AppCompatActivity {

    TaskList taskList = new TaskList();

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

        taskList.addTask(new Task("lol", "XD", "111", 0));
        taskList.addTask(new Task("lol2", "XD", "222", 0));
    }

    public TaskList getTaskList() {
        return this.taskList;
    }
    public void add(String name,String description,String date,int mod) {
        taskList.add(name, description, date, mod);
    }
}
