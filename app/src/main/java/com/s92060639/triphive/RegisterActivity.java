package com.s92060639.triphive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextEmail, editTextFullName, editTextPhone;
    private Button RegBtn;
    private TextView logBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle(R.string.signup);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextPhone = findViewById(R.id.editTextPhone);
        RegBtn = findViewById(R.id.RegBtn);
        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegBtn_onClick(v);
            }
        });
        logBtn = findViewById(R.id.logBtn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

    }
    public void RegBtn_onClick(View v) {
        try{
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            Account account = new Account();
            account.setEmail(editTextEmail.getText().toString());
            account.setFullName(editTextFullName.getText().toString());
            account.setPassword(editTextPassword.getText().toString());
            account.setUsername(editTextUsername.getText().toString());
            account.setPhone(Integer.parseInt(editTextPhone.getText().toString()));

            Account temp = databaseHelper.checkUsername(editTextUsername.getText().toString());

            if(temp == null){
                if (databaseHelper.create(account)){
                    Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                    startActivity(intent);
                }else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle(R.string.error);
                    builder.setMessage(R.string.can_not_cr);
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            }else {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.username_exs);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }

            if(databaseHelper.create(account)){
                Intent intent = new Intent(RegisterActivity.this, loginActivity.class);
                startActivity(intent);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle(R.string.error);
                builder.setMessage(R.string.can_not_cr);
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }

        }catch (Exception e){
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.error);
            builder.setMessage(e.getMessage());
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }
}