package com.example.projectdeadlinetime;

import android.content.Intent;

import com.example.projectdeadlinetime.Activity.MainActivity;
import com.example.projectdeadlinetime.Activity.ProjectActivity;
import com.example.projectdeadlinetime.Activity.SubTaskActivity;
import com.example.projectdeadlinetime.Data.ProjectData;

import static com.example.projectdeadlinetime.Activity.MainActivity.PERFORM_PROJECT_ACTIVITY;
import static com.example.projectdeadlinetime.Activity.MainActivity.PERFORM_SUB_TASK_ACTIVITY;

class ActivityIntentUtils {
    private static Intent perform;

    /**
     * Perform project
     *
     * @param mainActivity get main class
     * @param data         put data is class projectActivity
     */
    static void performActionProject(MainActivity mainActivity, ProjectData data) {
        perform = new Intent(mainActivity, ProjectActivity.class);
        perform.putExtra("projectData", data);
        mainActivity.startActivityForResult(perform, PERFORM_PROJECT_ACTIVITY);
    }

    /**
     * Perform CheckSubTask
     *
     * @param projectActivity get projectActivity class
     * @param data            put Project data
     */
    static void performActionCheckSubTask(ProjectActivity projectActivity, ProjectData data) {
        perform = new Intent(projectActivity, SubTaskActivity.class);
        perform.putExtra("projectData", data);
        projectActivity.startActivityForResult(perform, PERFORM_SUB_TASK_ACTIVITY);

    }
}
