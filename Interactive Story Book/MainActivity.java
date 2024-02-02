package com.example.interactivestoryapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText et_MainCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_MainCharacter = findViewById(R.id.MainCharacter);
    }

    public void proceed(View view) {
        String mainCharacter = et_MainCharacter.getText().toString().trim();

        if (mainCharacter.isEmpty()) {
            // If main character is empty, show toast and return
            Toast.makeText(this, "Please Enter your Main Character", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Main Character set as: " + mainCharacter , Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, page1.class);
        i.putExtra("pangalan", mainCharacter);
        startActivity(i);
    }

}
