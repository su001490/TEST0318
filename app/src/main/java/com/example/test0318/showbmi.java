package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class showbmi extends AppCompatActivity {

    private TextView name;
    private ImageView viewl;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showbmi);
         name = (TextView) findViewById(R.id.tv_name);
        viewl =(ImageView) findViewById(R.id.tv_image);
         info= (TextView) findViewById(R.id.tv_info);

        Bundle bundle = this.getIntent().getExtras();
        String h = bundle.getString("height");
        String w = bundle.getString("weight");
        String n = bundle.getString("name");

       // Toast.makeText(this, h+w+n, Toast.LENGTH_SHORT).show();
        Double bmi = Double.parseDouble(w)/(Double.parseDouble(h)/100*Double.parseDouble(h)/100);
        DecimalFormat df = new DecimalFormat( "#.##");

        String msg="";
        if(bmi<18.5) {
            msg="過輕";
            viewl.setImageResource(R.drawable.a1);
        } else if (bmi>25){
            msg="過重";
            viewl.setImageResource(R.drawable.a2);
        }else{
            msg="標準";
           viewl.setImageResource(R.drawable.a3);
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        info.setText (name.getText().toString()+"您的BMI是"+df.format(bmi)+msg);




    }
}
