package com.example.m2_project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    // Define member variables for each input field
    private TextInputEditText firstName, lastName, email, password, dateOfBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Set the content view to the layout defined for registration
        // Initialize each input field by finding them by ID from the layout
        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        dateOfBirth = findViewById(R.id.dateOfBirth);
    }

    // This method is called when the Register button is clicked
    public void onRegisterSubmitClicked(View view) {
        if (validateInput()) {
            // If validation passes, extract the text from each field
            String firstNameStr = firstName.getText().toString().trim();
            String lastNameStr = lastName.getText().toString().trim();
            String emailStr = email.getText().toString().trim();
            String passwordStr = password.getText().toString().trim();
            String dateOfBirthStr = dateOfBirth.getText().toString().trim();

            // Save the registration data using SharedPreferences
            saveRegistrationData(firstNameStr, lastNameStr, emailStr);

            // Show a toast message indicating successful registration
            Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();
            finish(); // Consider returning a result instead of just closing if this activity was started for a result
        }
    }

    // Validates the user's input for each field
    private boolean validateInput() {
        boolean isValid = true;


        if (TextUtils.isEmpty(firstName.getText())) {
            firstName.setError("First name is required");
            isValid = false;
        } else if (firstName.getText().toString().trim().length() < 3 || firstName.getText().toString().trim().length() > 30) {
            firstName.setError("First name must be between 3 and 30 characters");
            isValid = false;
        }


        if (TextUtils.isEmpty(lastName.getText())) {
            lastName.setError("Last name is required");
            isValid = false;
        }


        if (TextUtils.isEmpty(email.getText()) || !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString().trim()).matches()) {
            email.setError("Please enter a valid email address");
            isValid = false;
        }


        if (TextUtils.isEmpty(password.getText())) {
            password.setError("Password is required");
            isValid = false;
        } else if (password.getText().toString().trim().length() < 8) {
            password.setError("Password must be at least 8 characters long");
            isValid = false;
        }


        if (TextUtils.isEmpty(dateOfBirth.getText())) {
            dateOfBirth.setError("Date of birth is required");
            isValid = false;
        } else {

        }

        return isValid;
    }

    // Saves registration data using SharedPreferences
    private void saveRegistrationData(String firstNameStr, String lastNameStr, String emailStr) {
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("FirstName", firstNameStr);
        editor.putString("LastName", lastNameStr);
        editor.putString("Email", emailStr);
        editor.apply(); // Consider using commit() if you need an immediate return value indicating success/failure
    }
}
