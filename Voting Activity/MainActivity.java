package com.example.labact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.labact.VotingActivity; // Add this import statement

public class MainActivity extends AppCompatActivity {

    EditText et_age;
    EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_age = findViewById(R.id.age);
        et_name = findViewById(R.id.name);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Clear the EditText fields
        et_name.setText("");
        et_age.setText("");
    }

    public void submit(View view) {
        String name = et_name.getText().toString().trim();
        String ageText = et_age.getText().toString().trim();

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show();
        } else if (ageText.isEmpty()) {
            Toast.makeText(this, "Please enter your age.", Toast.LENGTH_SHORT).show();
        } else {
            int age = Integer.parseInt(ageText);
            if (age < 18) {
                Toast.makeText(this, "You are not eligible to vote.", Toast.LENGTH_SHORT).show();
            } else if (age > 99) {
                Toast.makeText(this, "Please enter a valid age.", Toast.LENGTH_SHORT).show();
            } else {
                // Redirect to VotingActivity
                Intent intent = new Intent(this, VotingActivity.class);
                intent.putExtra("Name", name);
                intent.putExtra("Age", age);
                startActivity(intent);
            }
        }
    }
}
