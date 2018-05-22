package com.example.prachu.pay;

import android.graphics.Color;
import android.os.PersistableBundle;
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

    public int sum=0,left =0,n,n1;
    public int tv11,tv22;
    public Button b1,b2,b3,b4,breset,bsubmit;
    TextView tv1,tv2;
    RelativeLayout rl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rl= (RelativeLayout)findViewById(R.id.relativeLayout);

        do {
            Random r = new Random();
            n = r.nextInt(50);
            tv1.setText(n + " ");
            tv2.setText(" " + n);
        }while(n==0);

        }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        tv11 = Integer.parseInt(tv1.getText().toString());
        tv22 = Integer.parseInt(tv2.getText().toString());

        outState.putInt("textview1",tv11);
        outState.putInt("textview2",tv22);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);

        n =savedInstanceState.getInt("textview1");
        tv1.setText(""+n);
       sum= n- savedInstanceState.getInt("textview2");
         tv2.setText(" "+(n-sum));
    }

    @Override
    public void onResume()
    {
        super.onResume();

        tv1.setText(""+n);
        tv2.setText(""+(n-sum));
    }


    public void button1(View v)
    {
        b1=(Button)findViewById(R.id.button1);
        sum=sum+1;
        tv2.setText(""+(n-sum));
    }


    public void button2(View v)
    {
        b2=(Button)findViewById(R.id.button2);
        sum=sum+2;
        tv2.setText(""+(n-sum));
    }

    public void button5(View v)
    {
       b3= (Button)findViewById(R.id.button3) ;
        sum=sum+5;
        tv2.setText(""+(n-sum));
    }

    public void button10(View v)
    {
        b4 = (Button)findViewById(R.id.button4);
        sum=sum+10;
        tv2.setText(""+(n-sum));
    }

        public void buttonreset(View v){
        breset =(Button)findViewById(R.id.button5);
        do {
            Random r = new Random();
            n = r.nextInt(50);
            tv1.setText(n + " ");
            tv2.setText(" " + n);
            sum = 0;
            rl.setBackgroundColor(Color.parseColor("#f8e0a9"));
        }while(n==0);
    }

    public void buttonsubmit(View v)
    {
        bsubmit=(Button)findViewById(R.id.button);
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





}
