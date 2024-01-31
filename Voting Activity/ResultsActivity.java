package com.example.labact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class ResultsActivity extends AppCompatActivity {

    TextView tv_Username;
    TextView tv_President;
    TextView tv_VicePresident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page2);

        tv_Username = findViewById(R.id.Username);
        tv_President = findViewById(R.id.President);
        tv_VicePresident = findViewById(R.id.VicePresident);

        Intent intent = getIntent();
        String username = intent.getStringExtra("Name"); // Retrieve username from MainActivity or VotingActivity
        String president = intent.getStringExtra("President"); // Retrieve president input from VotingActivity
        String vicePresident = intent.getStringExtra("VicePresident"); // Retrieve vice president input from VotingActivity

        tv_Username.setText("Hello, " + username); // Set the username TextView
        tv_President.setText("President: " + president); // Set the president TextView
        tv_VicePresident.setText("Vice President: " + vicePresident); // Set the vice president TextView
    }

    // Method to handle the EXIT button click
    public void exit(View view) {
        // Display "Thank you for voting!" message
        Toast.makeText(this, "Thank you for voting!", Toast.LENGTH_SHORT).show();

        // Return to MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        // Finish the ResultsActivity
        finish();
    }
}

