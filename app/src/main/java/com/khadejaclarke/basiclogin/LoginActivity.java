package com.khadejaclarke.basiclogin;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.text.TextUtils;
import android.widget.Button;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity{
    TextInputEditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        login = findViewById(R.id.login);
        login.setOnClickListener(v -> {
            String text_email = email.getText().toString().trim();
            String text_password = password.getText().toString();

            if (TextUtils.isEmpty(text_email) && TextUtils.isEmpty(text_password)) {
                email.setError("Field cannot be blank");
                password.setError("Field cannot be blank");
                email.requestFocus();

            } else if (TextUtils.isEmpty(text_email)) {
                email.setError("Field cannot be blank");
                email.requestFocus();

            } else if (TextUtils.isEmpty(text_password)) {
                password.setError("Field cannot be blank");
                password.requestFocus();

            } else if (isValidEmail(text_email)) {
                Intent intent = new Intent();
                setResult(100, intent);
                finish();

            } else {
                email.setError("Invalid email address");
                email.requestFocus();
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        return Pattern.compile(emailRegex).matcher(email).matches();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);

    }
}
