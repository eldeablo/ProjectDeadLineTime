package com.example.projectdeadlinetime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projectdeadlinetime.Data.SubTasksData;

@SuppressLint("Registered")
public class ListSubTaskView extends AppCompatActivity {

    private SubTasksData data;
    private ConstraintLayout constraintLayout;

    public ListSubTaskView(Context context, SubTasksData data) {
        this.data = data;

        constraintLayout = new ConstraintLayout(context);

        View _view = LayoutInflater.from(context).inflate(R.layout.layout_list_subtask, (ViewGroup) constraintLayout.getRootView(), false);

        TextView _nameSubText = _view.findViewById(R.id.nameSubTask);
        _nameSubText.setText(data.getNameSubTask());

        constraintLayout.addView(_view);
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }
}
