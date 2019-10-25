package com.example.projectdeadlinetime.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubTasksData implements Serializable {
    private String nameSubTask;
    private List<CheckSubTaskData> checkListTasks;

    public SubTasksData(String nameSubTask) {
        this.nameSubTask = nameSubTask;
        checkListTasks = new ArrayList<>();
    }

    public String getNameSubTask() {
        return nameSubTask;
    }

    public List<CheckSubTaskData> getCheckListTasks() {
        return checkListTasks;
    }

    public int getCountCheckTask() {
        return checkListTasks.size();
    }


}
