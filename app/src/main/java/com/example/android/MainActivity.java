package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int currentCount = 0;
    TextView numberText;
    Button toastButton, countButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countButton = findViewById(R.id.count_btn);
        toastButton = findViewById(R.id.toast_btn);
        numberText = findViewById(R.id.count_text);

        countButton.setOnClickListener(this);
        toastButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId()==R.id.count_btn){
            countUp(view);
        }else if(view.getId()==R.id.toast_btn){
            showToast(view);
        }
    }

    public void showToast(View view){
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view){
        currentCount++;
        numberText.setText(currentCount+"");
    }
}