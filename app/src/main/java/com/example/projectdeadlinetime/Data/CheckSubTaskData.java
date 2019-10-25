package com.example.projectdeadlinetime.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CheckSubTaskData implements Serializable {
    private String nameCheckSubTask;
    private List<CheckListTaskData> checkListTaskData;

    public CheckSubTaskData(String nameCheckSubTask) {
        this.nameCheckSubTask = nameCheckSubTask;
        checkListTaskData = new ArrayList<>();
    }

    public String getNameCheckSubTask() {
        return nameCheckSubTask;
    }

    public List<CheckListTaskData> getCheckListTaskData() {
        return checkListTaskData;
    }

    public int[] getIsClose(){
        int _getClose = 0;
        int _isClose =0;
        for (CheckListTaskData data:checkListTaskData) {
            if(data.isClose()){
                _getClose++;
            }else{
                _isClose++;
            }
        }
        return new int[]{_getClose,_isClose};
    }
}
