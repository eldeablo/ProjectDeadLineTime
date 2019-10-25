package com.example.projectdeadlinetime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projectdeadlinetime.Data.SubTasksData;

@SuppressLint("Registered")
public class ListSubTaskView extends AppCompatActivity {

    private SubTasksData data;
    private ConstraintLayout constraintLayout;

    public ListSubTaskView(Context context, SubTasksData data,AppCompatActivity appCompatActivity) {
        this.data = data;

        ConstraintLayout.LayoutParams _clp = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        _clp.setMargins(0,10,0,0);

        constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(_clp);

        View _view = LayoutInflater.from(context).inflate(R.layout.sub_task_data, (ViewGroup) constraintLayout.getRootView(), false);

        CardView _subTask = _view.findViewById(R.id.subTaskCard);
        _subTask.setOnClickListener(new TouchScreenEvent(appCompatActivity));

        TextView _nameSubText = _view.findViewById(R.id.nameCheckList);
        _nameSubText.setText(data.getNameSubTask());

        constraintLayout.addView(_view);
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }
}
