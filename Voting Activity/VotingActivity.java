package com.example.labact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class VotingActivity extends AppCompatActivity {

    EditText et_President;
    EditText et_VicePresident;
    TextView tv_Username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);

        et_President = findViewById(R.id.President);
        et_VicePresident = findViewById(R.id.VicePresident);
        tv_Username = findViewById(R.id.Username);
    }

    public void submit(View view) {
        String president = et_President.getText().toString().trim();
        String vicePresident = et_VicePresident.getText().toString().trim();
        String username = tv_Username.getText().toString().trim(); // Retrieve username from EditText

        if (president.isEmpty() && vicePresident.isEmpty()) {
            Toast.makeText(this, "Please enter President and Vice President.", Toast.LENGTH_SHORT).show();
        } else if (president.isEmpty()) {
            Toast.makeText(this, "Please enter President.", Toast.LENGTH_SHORT).show();
        } else if (vicePresident.isEmpty()) {
            Toast.makeText(this, "Please enter Vice President.", Toast.LENGTH_SHORT).show();
        } else {
            // Redirect to ResultsActivity and pass data
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("Name", username);
            intent.putExtra("President", president);
            intent.putExtra("VicePresident", vicePresident);
            startActivity(intent);
            Toast.makeText(this, "Vote submitted successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}

