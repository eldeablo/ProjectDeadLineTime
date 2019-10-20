package com.example.projectdeadlinetime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projectdeadlinetime.Data.ProjectData;

public class ListTaskView extends ConstraintLayout {

    private ProjectData data;

    public ListTaskView(Context context, ProjectData data) {
        super(context);
        this.data = data;

        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(700, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(35, 35, 0, 0);

        setLayoutParams(lp);

        View view = LayoutInflater.from(context).inflate(R.layout.layout_list_task, (ViewGroup) getRootView(), false);

        TextView nameTask = view.findViewById(R.id.nameTask);
        nameTask.setText(data.getListTasks().get(data.getCountTask()).getNameListTask());

        addView(view);

    }
}
