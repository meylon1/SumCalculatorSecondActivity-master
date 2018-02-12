package com.example.addissutamru.sumcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    //create instance variable
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //get reference to the widget
        textView4 = (TextView) findViewById(R.id.textView4);
        //get values from other activities
        Bundle bundle = getIntent().getExtras();
        int num1 = bundle.getInt("num1");
        int num2 = bundle.getInt("num2");

        int sum = num1 + num2;

        textView4.setText(Integer.toString(sum));
    }
}
