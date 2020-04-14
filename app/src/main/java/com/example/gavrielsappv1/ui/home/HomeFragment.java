package com.example.gavrielsappv1.ui.home;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.gavrielsappv1.R;
import com.example.gavrielsappv1.TaskListView;
import com.example.gavrielsappv1.entity.TaskList;
import com.example.gavrielsappv1.taskListAdapter;
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        final TaskList list = ((TaskListView)getActivity()).getTaskList();
        taskListAdapter adapter = new taskListAdapter(homeView.getContext(), list);
        final ListView lv = (ListView) homeView.findViewById(R.id.TaskListView);
        lv.setAdapter(adapter);

        return homeView;
    }
}