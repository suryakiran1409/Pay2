package com.example.prachu.pay;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int sum=0,left =0,n;
    public Button b1,b2,b3,b4,breset,bsubmit;
    TextView tv1,tv2;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        breset=(Button)findViewById(R.id.button5);
        bsubmit=(Button)findViewById(R.id.button);

        tv1=(TextView)findViewById(R.id.textView2);
        tv2=(TextView)findViewById(R.id.textView4);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        tv2.setMovementMethod(new ScrollingMovementMethod());

        rl=(RelativeLayout)findViewById(R.id.relativeLayout);

        do {
            Random r = new Random();
            n = r.nextInt(50);
            tv1.setText(n + " ");
            tv2.setText(" " + n);
        }while(n==0);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = sum+1;
                left = n-sum;
                tv2.setText(left +" ");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = sum+2;
                left = n-sum;
                tv2.setText(left +" ");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = sum+5;
                left = n-sum;
                tv2.setText(left +" ");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum = sum+10;
                left = n-sum;
                tv2.setText(left +" ");
            }
        });

        bsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum==n) {
                    // string a[] = {"","","","",""}
                    // write random function for 5 and store it in t
                    // string c= a[t]
                    // ll.setBackgroundColor
                    rl.setBackgroundColor(Color.parseColor("#21E60B"));
                    tv1.setText("successfull");
                    tv2.setText("u have paid");
                }
                else if(sum<n) {
                    Toast.makeText(getApplicationContext(), "u have to pay more", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "u paid extra tap to reset", Toast.LENGTH_LONG).show();
                }
            }
        });


        breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                do {
                    Random r = new Random();
                    n = r.nextInt(50);
                    tv1.setText(n + " ");
                    tv2.setText(" " + n);
                    sum = 0;
                    rl.setBackgroundColor(Color.parseColor("#f8e0a9"));
                }while(n==0);
            }

        });

    }
}
