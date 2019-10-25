package com.example.projectdeadlinetime;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectdeadlinetime.Activity.MainActivity;
import com.example.projectdeadlinetime.Activity.ProjectActivity;
import com.example.projectdeadlinetime.Adapters.PCardAdapter;

public class TouchScreenEvent implements View.OnClickListener, View.OnKeyListener, View.OnLongClickListener, PCardAdapter.ItemClickList {

    private AppCompatActivity appCompatActivity;

    public TouchScreenEvent(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    //Click event
    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.addProject: {
                MainActivity _mainActivity = (MainActivity) appCompatActivity;
                Utils.showKeyboard(null, _mainActivity.getNameProject(), _mainActivity);
                break;
            }
            case R.id.addTask: {
                ProjectActivity _projectAct = (ProjectActivity) appCompatActivity;
                Utils.showKeyboard(_projectAct.getAddTask().getChildAt(1), (EditText) _projectAct.getAddTask().getChildAt(0), _projectAct.getAddTask().getContext());
                break;
            }
            case R.id.addSubTaskList:{
                ListTaskView _listTaskView = (ListTaskView)appCompatActivity;
                Utils.showKeyboard(_listTaskView.getNameTask(),_listTaskView.getNameSubTask(),_listTaskView.getRootView().getContext());
                break;
            }
        }
    }

    //Key event
    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        int id = view.getId();

        switch (id) {
            case R.id.addNameProject: {
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    MainActivity _mainActivity = (MainActivity) appCompatActivity;
                    _mainActivity.addProjectCard(_mainActivity.getNameProject().getText().toString());
                    break;
                }
            }
            case R.id.nameSubTask: {
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    ProjectActivity _projectAct = (ProjectActivity) appCompatActivity;
                    _projectAct.addTaskData();
                    break;
                }

            }
            case R.id.nameCheckTask:{
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    ListTaskView _taskView = (ListTaskView) appCompatActivity;
                    _taskView.addSubTask();
                    break;
                }

            }
            default: {
                System.out.println(id);
            }
        }

        return true;
    }

    //Long event
    @Override
    public boolean onLongClick(View view) {
        int id = view.getId();
        return false;
    }

    //Item click Adapter
    @Override
    public void ItemClickList(View view, int position) {
        MainActivity _mainActivity = (MainActivity) appCompatActivity;
        ActivityIntentUtils.performActionProject(_mainActivity, _mainActivity.getProjectDataList().get(position));
    }
}
