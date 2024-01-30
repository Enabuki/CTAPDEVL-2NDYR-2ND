package com.example.labact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int int_age;
    EditText et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_age = findViewById(R.id.age);
    }



    public void submit(View view){

        if (et_age.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter your age.", Toast.LENGTH_SHORT).show();
        }
        else {
            int_age = Integer.parseInt(et_age.getText().toString());
            if (int_age <= 17){
                Toast.makeText(this, "You are not elligable to vote.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "You are elligable to vote.", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
