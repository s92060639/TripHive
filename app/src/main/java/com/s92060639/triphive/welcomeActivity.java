package com.s92060639.triphive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class welcomeActivity extends AppCompatActivity {

    private TextView textViewWelcome, textViewEmail;
    private Button btnChangeProfile, continueTrip;
    private Account account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        setTitle(R.string.welcome);

        textViewWelcome = findViewById(R.id.textViewWelcome);
//        textViewEmail = findViewById(R.id.textViewEmail);

        Intent intent = getIntent();
        account = (Account) intent.getSerializableExtra("account");
        textViewWelcome.setText(account.getFullName());

//        Intent intent1 = getIntent();
//        account = (Account) intent1.getSerializableExtra("account");
//        textViewEmail.setText(account.getEmail());

        btnChangeProfile = findViewById(R.id.btnChangeProfile);
        btnChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(welcomeActivity.this, ProfileActivity.class);
                intent1.putExtra("account", account);
                startActivity(intent1);
            }
        });

        continueTrip = findViewById(R.id.continueTrip);
        continueTrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(welcomeActivity.this, MainActivity.class);
                intent1.putExtra("account", account);
                startActivity(intent1);
            }
        });
    }
}