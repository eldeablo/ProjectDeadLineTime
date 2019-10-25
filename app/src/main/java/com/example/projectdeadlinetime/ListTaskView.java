package com.example.projectdeadlinetime;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.projectdeadlinetime.Data.ProjectData;
import com.example.projectdeadlinetime.Data.SubTasksData;


@SuppressLint("Registered")
public class ListTaskView extends AppCompatActivity {

    private ProjectData data;
    private ConstraintLayout constraintLayout;
    private LinearLayout listSubTask;
    private EditText nameSubTask;
    private TextView addSubTaskList;
    private AppCompatActivity getProjectClass;
    private int index;


    public ListTaskView(Context context, ProjectData data, int index, AppCompatActivity getProjectClass) {
        this.data = data;
        this.index = index;
        this.getProjectClass = getProjectClass;

        ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(700, ConstraintLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(35, 35, 0, 0);

        constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(lp);

        View _view = LayoutInflater.from(context).inflate(R.layout.layout_list_task, (ViewGroup) constraintLayout.getRootView(), false);

        listSubTask = _view.findViewById(R.id.listSubTaskData);

        nameSubTask = _view.findViewById(R.id.nameSubTaskData);
        nameSubTask.setOnKeyListener(new TouchScreenEvent(this));


        TextView _nameTask = _view.findViewById(R.id.nameTask);
        _nameTask.setText(data.getListTasks().get(index).getNameListTask());

        addSubTaskList = _view.findViewById(R.id.addSubTaskList);
        addSubTaskList.setText(R.string.addListSubTask);
        addSubTaskList.setOnClickListener(new TouchScreenEvent(this));

        constraintLayout.addView(_view);
    }

    public ConstraintLayout getConstraintLayout() {
        return constraintLayout;
    }

    public void addSubTask() {
        if (listSubTask.getChildAt(0).getId() == R.id.out) {
            listSubTask.removeViewAt(0);
        }

        int i = data.getListTasks().get(index).getSubTasksList().size();

        data.getListTasks().get(index).getSubTasksList().add(new SubTasksData(nameSubTask.getText().toString()));

        listSubTask.addView(new ListSubTaskView(listSubTask.getContext(), data.getListTasks().get(index).getSubTasksList().get(i), getProjectClass).getConstraintLayout(), data.getListTasks().get(index).getCountSubTaskList());
        Utils.hideKeyboard(addSubTaskList, nameSubTask, listSubTask.getContext());
    }

    public EditText getNameSubTask() {
        return nameSubTask;
    }

    public TextView getNameTask() {
        return addSubTaskList;
    }

    public CardView getRootView() {
        ConstraintLayout _view = (ConstraintLayout) constraintLayout.getChildAt(0);
        LinearLayout _l = (LinearLayout) _view.getChildAt(1);
        return (CardView) _l.getChildAt(2);
    }
}
