package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Switch;
import android.widget.CompoundButton;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button);
        final TextView tv1 = findViewById(R.id.textView);
        final ImageView iv1 = findViewById(R.id.imageView);

        btn1.setOnClickListener(new View.OnClickListener(){
            boolean flag = true;
            public void onClick(View v) {
                if(flag){
                    tv1.setText("Good Good Study!");
                    flag = false;
                }
                else{
                    tv1.setText("Hello World!");
                    flag = true;
                }
                Log.d("MainActivity", "hello");
            }
        });

        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tv1.setVisibility(View.INVISIBLE);
                    iv1.setVisibility(View.VISIBLE);
                }
                else{
                    tv1.setVisibility(View.VISIBLE);
                    iv1.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
}
