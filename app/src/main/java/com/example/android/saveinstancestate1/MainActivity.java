package com.example.android.saveinstancestate1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int mCounter = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Activity is created", Toast.LENGTH_SHORT).show();
        Log.v("MainActivity", "onCreate");

        if (savedInstanceState != null){
            mCounter = savedInstanceState.getInt("MyCounter");
        } else {
            mCounter = 0;
        }

        final TextView no =  findViewById(R.id.txt_counter);
        no.setText(String.valueOf(mCounter));

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCounter = mCounter + 1;
                no.setText(String.valueOf(mCounter));
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("MyCounter", mCounter);


    }
}