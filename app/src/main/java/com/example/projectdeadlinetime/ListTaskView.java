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

@SuppressLint({"ViewConstructor", "Registered"})
public class ListTaskView extends AppCompatActivity {

    private ProjectData data;
    private ConstraintLayout constraintLayout;
    private LinearLayout listSubTask;
    private EditText nameSubTask;
    private TextView addSubTaskList;
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

        nameSubTask = _view.findViewById(R.id.nameCheckTask);
        nameSubTask.setOnKeyListener(new TouchScreenEvent(this));

        if (!(data.getListTasks().get(index).getSubTasksList().size() > 1)) {
            listSubTask.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        } else {
            listSubTask.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }


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
        listSubTask.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        int i = data.getListTasks().get(index).getSubTasksList().size();
        System.out.println(nameSubTask.getText().toString());

        data.getListTasks().get(index).getSubTasksList().add(new SubTasksData(nameSubTask.getText().toString()));

        listSubTask.addView(new ListSubTaskView(listSubTask.getContext(), data.getListTasks().get(index).getSubTasksList().get(i)).getConstraintLayout(), data.getListTasks().get(index).getCountSubTaskList());
        Utils.hideKeyboard(addSubTaskList, nameSubTask, listSubTask.getContext());
    }

    public LinearLayout getListSubTask() {
        return listSubTask;
    }

    public EditText getNameSubTask() {
        return nameSubTask;
    }

    public TextView getNameTask() {
        return addSubTaskList;
    }

    public int getIndex() {
        return index;
    }

    public CardView getRootView() {
        ConstraintLayout _view = (ConstraintLayout) constraintLayout.getChildAt(0);
        LinearLayout _l = (LinearLayout) _view.getChildAt(1);
        return (CardView) _l.getChildAt(2);
    }
}
