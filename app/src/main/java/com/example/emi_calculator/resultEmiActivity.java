package com.example.emi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultEmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_emi);

        ImageView txtBack = findViewById(R.id.txtBack);
        TextView txtRAmount = findViewById(R.id.txtRAmount);
        TextView txtRRate = findViewById(R.id.txtRRate);
        TextView txtRYear = findViewById(R.id.txtRYear);
        TextView txtRAnswer = findViewById(R.id.txtRAnswer);
        LinearLayout btnShare = findViewById(R.id.btnShare);

        txtBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

       Intent intent=getIntent();

        String rAmount = getIntent().getStringExtra("edtAmount");
        String rRate = getIntent().getStringExtra("edtRate");
        String rYear = getIntent().getStringExtra("edtYear");
        Double rAnswer = getIntent().getDoubleExtra("txtAnswer",0);

        txtRAmount.setText("Amount = "+rAmount);
        txtRYear.setText("Rate = "+rRate);
        txtRRate.setText("Year = "+rYear);
        txtRAnswer.setText("Monthly EMI = "+rAnswer);


        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent1 = new Intent(Intent.ACTION_SEND);
                intent1.setType("text/plain");
                intent1.putExtra(Intent.EXTRA_SUBJECT,"EMI Calculation");
                intent1.putExtra(Intent.EXTRA_TEXT,"Amount = "+rAmount+"\nRate = "+rRate+"\nYear = "+rYear+"\nMonthly EMI = "+rAnswer);
                startActivity(Intent.createChooser(intent1,"EMI Calculation"));

            }
        });
    }
}