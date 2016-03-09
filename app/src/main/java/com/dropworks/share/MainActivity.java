package com.dropworks.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        myText = (TextView) findViewById(R.id.myText);
    }


    //Save user's login info
    public void saveClicked(View view){
        SharedPreferences prefs = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor zedit = prefs.edit();
        zedit.putString("username", username.getText().toString());
        zedit.putString("password", password.getText().toString());
        zedit.apply();

        Toast.makeText(this, "Data saved.", Toast.LENGTH_SHORT).show();
    }

    //Print out saved data
    public void loadClicked(View view){
        SharedPreferences prefs = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        String name = prefs.getString("username", "");
        String pw = prefs.getString("password", "");

        myText.setText(name + ", " + pw);
    }

}
