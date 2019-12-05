package com.sajjad.startapp.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

class SaveModel {

    private SharedPreferences preferences;
    private Context context;

    SaveModel(Context context) {
        preferences = context.getSharedPreferences(context.getString(R.string.user_info), Context.MODE_PRIVATE);
        this.context = context;
    }

    boolean saveUserName(String userName) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(context.getString(R.string.user_name_key), userName);
        return editor.commit();
    }

    String getUserName() {
        return preferences.getString(context.getString(R.string.user_name_key), "");
    }
}