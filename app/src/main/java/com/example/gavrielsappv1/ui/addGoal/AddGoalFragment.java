package com.example.gavrielsappv1.ui.addGoal;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.gavrielsappv1.R;
import com.example.gavrielsappv1.TaskListView;

import java.util.Calendar;

public class AddGoalFragment extends Fragment {

    private AddGoalViewModel addGoalViewModel;
    EditText addName;
    EditText addDescription;
    Button modButton;
    Button addButton;
    TextView TVMod;
    TextView addDate;
    DatePickerDialog.OnDateSetListener mDateSetListener;
    int mods = 0;
    String dates = "0/0/0";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        addGoalViewModel = ViewModelProviders.of(this).get(AddGoalViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_add_goal, container, false);
        addName = root.findViewById(R.id.addName);
        addDescription = root.findViewById(R.id.addDescription);
        modButton = root.findViewById(R.id.modButton);
        addButton = root.findViewById(R.id.addButton);
        TVMod = root.findViewById(R.id.TVMod);
        addDate = root.findViewById(R.id.addDate);

        setMod();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!addName.getText().toString().matches("") && !addDescription.getText().toString().matches(""))
                    if (mods != 2)
                        ((TaskListView) getActivity()).add(addName.getText().toString(), addDescription.getText().toString(), dates, mods);
                    else
                        ((TaskListView) getActivity()).add(addName.getText().toString(), addDescription.getText().toString(), "-1", mods);
            }
        });
        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mods < 2) {
                    mods++;
                    setMod();
                } else {
                    mods = 0;
                    setMod();
                }
            }
        });
        addDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(root.getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month++;

                dates = day + "/" + month + "/" + year;
                addDate.setText(dates);
            }
        };

        return root;
    }

    private void setMod() {
        switch (mods) {
            case 0:
                TVMod.setText("until Date:");
                addDate.setVisibility(View.VISIBLE);
                break;
            case 1:
                TVMod.setText("on Date:");
                addDate.setVisibility(View.VISIBLE);
                break;
            case 2:
                TVMod.setText("unlimited:");
                addDate.setVisibility(View.GONE);
                break;
        }
    }
}