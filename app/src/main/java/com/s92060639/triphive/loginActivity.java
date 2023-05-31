package com.s92060639.triphive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class loginActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button loginBtn;
    private TextView registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBtn_onClick(v);
            }
        });
        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerBtn(v);
            }
        });
    }

    public void loginBtn_onClick(View v) {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        String username = editTextUsername.getText().toString();
        String password = editTextPassword.getText().toString();
        Account account = databaseHelper.login(username,password);
        if(account == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(R.string.invalid_acc);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();

        }else{
            Intent intent = new Intent(loginActivity.this, welcomeActivity.class);
            intent.putExtra("account", account);
            startActivity(intent);
        }
    }
    public void registerBtn(View v) {
        Intent intent = new Intent(loginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}