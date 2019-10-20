package com.example.projectdeadlinetime.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubTasksData implements Serializable {
    private String nameSubTask;
    private List<CheckListTaskData> checkListTasks;

    public SubTasksData(String nameSubTask) {
        this.nameSubTask = nameSubTask;
        checkListTasks = new ArrayList<>();
    }

    public String getNameSubTask() {
        return nameSubTask;
    }

    public List<CheckListTaskData> getCheckListTasks() {
        return checkListTasks;
    }

    public int getCountCheckTask() {
        return checkListTasks.size();
    }

    public int getCountIsCheckTask() {
        int countIsClose = 0;
        for (int i = 0; i < checkListTasks.size(); i++) {
            if (checkListTasks.get(i).isClose()) {
                countIsClose++;
            }
        }
        return countIsClose;
    }


}
