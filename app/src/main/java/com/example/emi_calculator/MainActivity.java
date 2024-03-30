package com.example.emi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtBtnSubmit = findViewById(R.id.txtbtnSubmit);
        EditText edtAmount = findViewById(R.id.edtAmount);
        EditText edtRate = findViewById(R.id.edtRate);
        EditText edtYear = findViewById(R.id.edtYear);
        TextView txtAnswer = findViewById(R.id.txtAnswer);

        txtBtnSubmit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String amount = edtAmount.getText().toString();
                String rate = edtRate.getText().toString();
                String year = edtYear.getText().toString();
                String answer = txtAnswer.getText().toString();
                if(amount.isEmpty())
                {
                    edtAmount.setError("Please Enter Amount");
                    Toast.makeText(MainActivity.this,"Please Enter Amount", Toast.LENGTH_SHORT).show();
                    Log.e(amount,"Enter Amount");
                }
                else if (rate.isEmpty())
                {
                    edtRate.setError("Please Enter Rate");
                    Toast.makeText(MainActivity.this,"Please Enter Rate", Toast.LENGTH_SHORT).show();
                    Log.e(rate,"EnterRete");
                }
                else if (year.isEmpty())
                {
                    edtYear.setError("Please Enter Year");
                    Toast.makeText(MainActivity.this,"Please Enter Year", Toast.LENGTH_SHORT).show();
                    Log.e(year,"Enter Years");
                }
                else
                {
                        int amounts = Integer.parseInt(amount);
                        float rates = Float.parseFloat(rate);
                        int years = Integer.parseInt(year);
                        float monthlyRate = rates/(12*100);
                        int months = years*12;
                        Double emi = (amounts*monthlyRate*Math.pow(1+monthlyRate,months)/(Math.pow(1+monthlyRate,months)-1));
                        emi=Math.floor(emi);


                    Intent intent = new Intent(MainActivity.this, resultEmiActivity.class);
                    intent.putExtra("edtAmount",amount);
                    intent.putExtra("edtRate",rate);
                    intent.putExtra("edtYear",year);
                    intent.putExtra("txtAnswer",emi);
                    startActivity(intent);
                }
            }
        });
    }
}
