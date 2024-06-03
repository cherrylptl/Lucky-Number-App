package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.luckynumberapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.wishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(binding.nameTextField.getText().toString().trim())){
                    Toast.makeText(MainActivity.this, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    UserModel.setUserName(binding.nameTextField.getText().toString());
                    LuckyNumberModel.generateLuckyNumber();
                    secondActivity();
                }
            }
        });
    }

    public void secondActivity()
    {
        Intent intentObj = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intentObj);
    }
}