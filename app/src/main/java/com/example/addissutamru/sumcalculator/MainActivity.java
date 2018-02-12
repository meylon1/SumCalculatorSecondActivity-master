package com.example.addissutamru.sumcalculator;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    //define instance variables for widgets
    private EditText editTextNum1;
    private EditText editTextNum2;
    private Button button;
    private TextView textViewSum;

    private SharedPreferences savedValues;

    //what we want to save

    private int num1 = 0;
    private int num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = (EditText) findViewById(R.id.editTextNum1);
        editTextNum2 = (EditText) findViewById(R.id.editTextNum2);
        button = (Button) findViewById(R.id.button);
        textViewSum = (TextView) findViewById(R.id.textView3);

        //button.setOnClickListener((View.OnClickListener)this);
        savedValues = getSharedPreferences("savedValues", MODE_PRIVATE);


    }

    @Override
    public void onPause() {

        SharedPreferences.Editor editor = savedValues.edit();
        editor.putInt("num1", num1);
        editor.putInt("num2", num2);
        editor.commit();
        // save the instance variables above
        super.onPause();
    }
    public void onResume(){

        super.onResume();
        //get instance variables
        num1 = savedValues.getInt("num1", 0);
        num2 = savedValues.getInt("num2", 0);




    }










    /*public void calculateAndDisplay(){
         num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());
        int sum = num1 + num2;

        textViewSum.setText (String.valueOf(sum));
    }*/

    public void sendMessage(View view){
        //set an intent that you are going to invoke the second activity from the first class
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //get values for the two numbers to be added
        num1 = Integer.parseInt(editTextNum1.getText().toString());
        num2 = Integer.parseInt(editTextNum2.getText().toString());
        intent.putExtra("num1", num1);
        intent.putExtra("num2", num2);
        startActivity(intent);


    }

    /*@Override
    public void onClick(View view) {
        calculateAndDisplay();
    }*/
}
