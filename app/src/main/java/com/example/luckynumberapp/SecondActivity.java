package com.example.luckynumberapp;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.luckynumberapp.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    ActivitySecondBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intentObj = getIntent();
        String userName = intentObj.getStringExtra("username");
        String luckyNumberString = intentObj.getStringExtra("lucky_number");

        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.luckyNumber.setText(luckyNumberString);
        binding.secondPageTitle.setText(userName+ "'s Lucky Number is:");
        binding.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                shareLuckyNumber(userName,luckyNumberString);
            }
        });
    }

    public void shareLuckyNumber(String userName,String shareText){
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,  userName + "'s Lucky Number is: " + shareText);

        Intent chooser = Intent.createChooser(shareIntent, "Share your lucky number");
        startActivity(chooser);
    }
}