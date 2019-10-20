package com.example.projectdeadlinetime.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListTaskData implements Serializable {

    private String nameListTask;
    private List<SubTasksData> subTasksList;


    public ListTaskData(String nameListTask) {
        this.nameListTask = nameListTask;
        subTasksList = new ArrayList<>();
    }

    public String getNameListTask() {
        return nameListTask;
    }

    public int getSubTasks() {
        return subTasksList.size();
    }
}
