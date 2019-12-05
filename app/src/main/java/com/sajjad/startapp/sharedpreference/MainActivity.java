package com.sajjad.startapp.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar mainToolbar;

    EditText userName;
    TextView userNameText;
    SaveModel saveModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainToolbar = findViewById(R.id.mainToolbar);
        setSupportActionBar(mainToolbar);

        userName = findViewById(R.id.userName);
        userNameText = findViewById(R.id.userNameText);

        saveModel = new SaveModel(this);

    }

    public void saveUserName(View view) {
        if (saveModel.saveUserName(userName.getText().toString())) {
            Toast.makeText(this, "Saved OK", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
        }
    }

    public void retrieveUserName(View view) {
        if (saveModel.getUserName().isEmpty()) {
            userNameText.setText("There is no value");
        } else {
            userNameText.setText(saveModel.getUserName());
        }
    }
}