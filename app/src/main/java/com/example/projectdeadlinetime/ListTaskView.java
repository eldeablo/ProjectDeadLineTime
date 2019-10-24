package com.example.projectdeadlinetime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projectdeadlinetime.Data.ProjectData;
import com.example.projectdeadlinetime.Data.SubTasksData;

@SuppressLint({"ViewConstructor", "Registered"})
public class ListTaskView extends AppCompatActivity {

    private ProjectData data;
    private ConstraintLayout constraintLayout;
    private LinearLayout listSubTask;
    private int index;


    public ListTaskView(Context context, ProjectData data, int index) {
        this.data = data;
        this.index = index;

        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(700, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(35, 35, 0, 0);

        constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(lp);

        View _view = LayoutInflater.from(context).inflate(R.layout.layout_list_task, (ViewGroup) constraintLayout.getRootView(), false);

        listSubTask = _view.findViewById(R.id.listSubTaskData);


        if (!(data.getListTasks().get(index).getSubTasksList().size() > 1)) {
            listSubTask.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        } else {
            listSubTask.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }


        TextView nameTask = _view.findViewById(R.id.nameTask);
        nameTask.setText(data.getListTasks().get(index).getNameListTask());

        TextView _addSubTaskList = _view.findViewById(R.id.addSubTaskList);
        _addSubTaskList.setText(R.string.addListSubTask);
        _addSubTaskList.setOnClickListener(new TouchScreenEvent(this));

        constraintLayout.addView(_view);

    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public void addSubTask() {
        listSubTask.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i = data.getListTasks().get(index).getSubTasksList().size();

        data.getListTasks().get(index).getSubTasksList().add(new SubTasksData("Name Test"));
        listSubTask.addView(new ListSubTaskView(listSubTask.getContext(), data.getListTasks().get(index).getSubTasksList().get(i)).getConstraintLayout(), data.getListTasks().get(index).getCountSubTaskList());
    }

    public int getIndex() {
        return index;
    }
}
