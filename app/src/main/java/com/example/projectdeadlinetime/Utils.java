package com.example.projectdeadlinetime;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.projectdeadlinetime.Data.ProjectData;

import java.util.List;

public class Utils {

    /**
     * Show keyboard
     */
    public static void showKeyboard(View visibleComponent, EditText textEditor, Context context) {
        if (visibleComponent != null) {
            hideComponent(visibleComponent);
        }
        showComponent(textEditor);
        textEditor.requestFocus();
        InputMethodManager _imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        _imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        textEditor.setText("");
    }

    /**
     * Hide keyboard
     */
    public static void hideKeyboard(View visibleComponent, EditText textEditor, Context context) {
        if (visibleComponent != null) {
            showComponent(visibleComponent);
        }
        hideComponent(textEditor);
        textEditor.clearFocus();
        InputMethodManager _imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        _imm.hideSoftInputFromWindow(textEditor.getWindowToken(), 0);
    }

    /**
     * Show view component
     *
     * @param view get component
     */
    public static void showComponent(View view) {
        view.setVisibility(View.VISIBLE);
    }

    /**
     * Hide view component
     *
     * @param view get component
     */
    public static void hideComponent(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    /**
     * Get data is list data
     *
     * @param dataList    array data
     * @param projectData get data find
     */
    public static int getDataIsList(List<ProjectData> dataList, ProjectData projectData) {
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.contains(projectData)) {
                return i;
            }
        }
        return 0;
    }
}
