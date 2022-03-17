package com.example.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int currentCount = 0;
    TextView numberText;
    Button toastButton, countButton, zeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countButton = findViewById(R.id.count_btn);
        toastButton = findViewById(R.id.toast_btn);
        zeroButton = findViewById(R.id.zero_btn);
        numberText = findViewById(R.id.count_text);
        this.changeCountColor();

        countButton.setOnClickListener(this);
        toastButton.setOnClickListener(this);
        zeroButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.count_btn:
                countUp(view);
                break;

            case R.id.toast_btn:
                showToast(view);
                break;

            case R.id.zero_btn:
                this.currentCount = 0;
                this.zeroButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.gray));
                numberText.setText(this.currentCount+"");
                this.changeCountColor();
                break;
        }
    }

    public void showToast(View view){
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view){
        currentCount++;
        numberText.setText(currentCount+"");
        this.zeroButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.pink));
        this.changeCountColor();
    }

    public void changeCountColor(){
        // set background color of count button
        if(this.currentCount%2==0){
            this.countButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.teal_200));
            return;
        }

        this.countButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.red));
    }
}