package com.example.projectdeadlinetime.Data;

import java.io.Serializable;

public class CheckListTaskData implements Serializable {
    private String nameCheckTask;
    private boolean isClose;

    public CheckListTaskData(String nameCheckTask, boolean isClose) {
        this.nameCheckTask = nameCheckTask;
        this.isClose = isClose;
    }

    public String getNameCheckTask() {
        return nameCheckTask;
    }

    public boolean isClose() {
        return isClose;
    }

    public void setClose(boolean close) {
        isClose = close;
    }

}
