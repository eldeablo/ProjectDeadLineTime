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
            visibleComponent.setVisibility(View.INVISIBLE);
        }
        textEditor.setVisibility(View.VISIBLE);
        textEditor.requestFocus();
        InputMethodManager _imm = (InputMethodManager) context.getSystemService(context.INPUT_METHOD_SERVICE);
        _imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        textEditor.setText("");
    }

    /**
     * hide keyboard
     */
    public static void hideKeyboard(View visibleComponent, EditText textEditor, Context context) {
        if (visibleComponent != null) {
            visibleComponent.setVisibility(View.VISIBLE);
        }
        textEditor.setVisibility(View.INVISIBLE);
        textEditor.clearFocus();
        InputMethodManager _imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        _imm.hideSoftInputFromWindow(textEditor.getWindowToken(), 0);
    }

    public static int getDataIsList(List<ProjectData> dataList,ProjectData projectData){
        for(int i =0;i<dataList.size();i++){
            if(dataList.contains(projectData)){
                return i;
            }
        }
        return 0;
    }
}
