package com.example.m2_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    // Declare TextInputEditText variables for email and password input fields
    private TextInputEditText emailEditText;
    private TextInputEditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set the content view to the XML layout defined in activity_login.xml
        // Initialize the TextInputEditText fields by finding them from the layout
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
    }

    // Method to handle the login button click event
    public void onLoginClicked(View view) {
        // Extract and trim the email and password from the input fields
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        // Basic validation to check if the email and password inputs are not empty and email contains "@"

        if (email.isEmpty() || !email.contains("@") || password.isEmpty()) {
            Toast.makeText(this, "Please enter valid email and password.", Toast.LENGTH_SHORT).show();
        } else {
            // Assume validation success
            Toast.makeText(this, "Login successful.", Toast.LENGTH_SHORT).show();
            // Intent to transition to your app's main activity goes here
        }
    }

    // Method to navigate to the RegisterActivity when the register button is clicked
    public void onRegisterClicked(View view) {
        // Intent to start RegisterActivity
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
