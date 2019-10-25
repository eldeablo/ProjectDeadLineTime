package com.example.projectdeadlinetime.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectdeadlinetime.Adapters.PCardAdapter;
import com.example.projectdeadlinetime.Data.ProjectData;
import com.example.projectdeadlinetime.History;
import com.example.projectdeadlinetime.R;
import com.example.projectdeadlinetime.TouchScreenEvent;
import com.example.projectdeadlinetime.Utils;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public static final int PERFORM_PROJECT_ACTIVITY = 20;

    //View
    private EditText nameProject;

    private History history;
    private List<ProjectData> projectDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        projectDataList = new ArrayList<>();

        TouchScreenEvent touchScreenEvent = new TouchScreenEvent(this);

        PCardAdapter pCardAdapter = new PCardAdapter(this, projectDataList);
        pCardAdapter.setItemClickList(touchScreenEvent);

        BottomAppBar bottomBar = findViewById(R.id.bottomAppBar);

        RecyclerView projectList = findViewById(R.id.projectList);
        projectList.setLayoutManager(new GridLayoutManager(projectList.getContext(), 2));
        projectList.setAdapter(pCardAdapter);

        nameProject = findViewById(R.id.addNameProject);
        nameProject.setOnKeyListener(touchScreenEvent);

        FloatingActionButton addProject = findViewById(R.id.addProject);
        addProject.setOnClickListener(touchScreenEvent);

        history = new History();

        setSupportActionBar(bottomBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.history) {
            history.show(getSupportFragmentManager(), history.getTag());
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PERFORM_PROJECT_ACTIVITY) {
                ProjectData _projectData = (ProjectData) Objects.requireNonNull(data).getSerializableExtra("projectData");
                projectDataList.set(Utils.getDataIsList(projectDataList, _projectData), _projectData);
            }
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

    /**
     * Add project card
     *
     * @param name name project
     */
    public void addProjectCard(String name) {
        projectDataList.add(new ProjectData(name,false));
        Utils.hideKeyboard(null, nameProject, this);
    }

    //Getters
    public EditText getNameProject() {
        return nameProject;
    }

    public List<ProjectData> getProjectDataList() {
        return projectDataList;
    }

    public History getHistory() {
        return history;
    }
}
