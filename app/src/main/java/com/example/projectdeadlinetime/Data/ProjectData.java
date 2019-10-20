package com.example.projectdeadlinetime.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProjectData implements Serializable {

    private String nameProject;
    private List<ListTaskData> listTasks;
    private boolean isCloseProject;

    public ProjectData(String nameProject,boolean isCloseProject) {
        this.nameProject = nameProject;
        this.isCloseProject = isCloseProject;

        listTasks = new ArrayList<>();
    }

    public String getNameProject() {
        return nameProject;
    }

    public boolean isCloseProject() {
        return isCloseProject;
    }

    public void setCloseProject(boolean closeProject) {
        isCloseProject = closeProject;
    }

    public List<ListTaskData> getListTasks() {
        return listTasks;
    }

    public int getCountTask(){
        return listTasks.size() -1;
    }


}



