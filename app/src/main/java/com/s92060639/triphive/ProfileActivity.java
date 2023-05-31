package com.s92060639.triphive;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword, editTextEmail, editTextFullName, editTextPhone;
    private Button RegBtn, logBtn;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.change_pro);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextFullName = findViewById(R.id.editTextFullName);
        editTextPhone = findViewById(R.id.editTextPhone);
        RegBtn = findViewById(R.id.RegBtn);
        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_onClick(v);
            }
        });
        logBtn = findViewById(R.id.logBtn);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, welcomeActivity.class);
                intent.putExtra("account", account);
                startActivity(intent);
            }
        });
        loadData();
    }

    private void loadData(){
        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        editTextEmail.setText(account.getEmail());
        editTextFullName.setText(account.getFullName());
        editTextUsername.setText(account.getUsername());
    }

    public void save_onClick(View v) {
        try{
            DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
            Account currentAccount = databaseHelper.find(account.getId());
            String newUsername = editTextUsername.getText().toString();
            Account temp = databaseHelper.checkUsername(newUsername);
            if(!newUsername.equalsIgnoreCase(currentAccount.getUsername()) && temp != null) {
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
                return;
            }
                currentAccount.setUsername(editTextUsername.getText().toString());
                currentAccount.setFullName(editTextFullName.getText().toString());
                currentAccount.setEmail(editTextEmail.getText().toString());
                String password = editTextPassword.getText().toString();
                if (!password.isEmpty()){
                    currentAccount.setPassword(editTextPassword.getText().toString());
                }
                if (databaseHelper.update(currentAccount)){
                    Intent intent = new Intent(ProfileActivity.this, welcomeActivity.class);
                    intent.putExtra("account", currentAccount);
                    startActivity(intent);
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setTitle(R.string.error);
                    builder.setMessage("Failed");
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