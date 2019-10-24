package com.example.projectdeadlinetime.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.projectdeadlinetime.Data.ListTaskData;
import com.example.projectdeadlinetime.Data.ProjectData;
import com.example.projectdeadlinetime.ListTaskView;
import com.example.projectdeadlinetime.R;
import com.example.projectdeadlinetime.TouchScreenEvent;
import com.example.projectdeadlinetime.Utils;

import java.util.Objects;

public class ProjectActivity extends AppCompatActivity {

    private LinearLayout listTask;
    private CardView addTask;

    private ProjectData data;
    private int indexData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_activity);

        TouchScreenEvent touchScreenEvent = new TouchScreenEvent(this);

        Intent _getData = getIntent();

        data = (ProjectData) Objects.requireNonNull(_getData.getExtras()).getSerializable("projectData");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(data.getNameProject());

        listTask = findViewById(R.id.listSubTaskData);

        addTask = findViewById(R.id.addTask);
        addTask.setOnClickListener(touchScreenEvent);
        addTask.getChildAt(0).setOnKeyListener(touchScreenEvent);

        if (Objects.requireNonNull(data).getListTasks().size() > 0) {
            loadingData();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onBackPressed() {
        Intent s = new Intent();
        s.putExtra("projectData", data);
        setResult(RESULT_OK, s);
        finish();
    }

    public void addTaskData() {
        EditText _nameTask = (EditText) addTask.getChildAt(0);

        data.getListTasks().add(new ListTaskData(_nameTask.getText().toString()));

        listTask.addView(new ListTaskView(listTask.getContext(), data, indexData).getConstraintLayout(), data.getCountTask());

        Utils.hideKeyboard(addTask.getChildAt(1), _nameTask, addTask.getContext());

        indexData += 1;
    }

    private void loadingData() {
        indexData = data.getListTasks().size();

        for (int i = 0; i < indexData; i++) {
            listTask.addView(new ListTaskView(listTask.getContext(), data, indexData).getConstraintLayout(), i);
        }
    }

    public CardView getAddTask() {
        return addTask;
    }
}
