package com.example.projectdeadlinetime;

import android.content.Intent;

import com.example.projectdeadlinetime.Activity.MainActivity;
import com.example.projectdeadlinetime.Activity.ProjectActivity;
import com.example.projectdeadlinetime.Data.ProjectData;

import static com.example.projectdeadlinetime.Activity.MainActivity.PERFORM_PROJECT_ACTIVITY;

public class ActivityIntentUtils {

    public static void performActionProject(MainActivity mainActivity, ProjectData data) {
        Intent _performProject = new Intent(mainActivity, ProjectActivity.class);
        _performProject.putExtra("projectData",data);
        mainActivity.startActivityForResult(_performProject, PERFORM_PROJECT_ACTIVITY);
    }
}
