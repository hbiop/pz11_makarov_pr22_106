package com.example.pz11_makarov_22_106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView result = (TextView) findViewById(R.id.textView);
        //result.setVisibility(View.INVISIBLE);
        try {
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
    public boolean Started = false;
    public boolean Finished = false;
    public void Start(View view)
    {
        Button button = (Button)findViewById(R.id.button);
        if(!Finished)
        {
            if(!Started)
            {
                button.setBackgroundColor(Color.RED);
                button.setText("Пауза");
                Started = true;
            }
            else
            {
                if(Started)
                {
                    button.setBackgroundColor(Color.GREEN);
                    button.setText("Старт");
                    Started = false;
                }
            }
        }
        else
        {
            Intent intent = new Intent (MainActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
    public void  Drive1(View view)
    {
        Button button = (Button)findViewById(R.id.button2);
        Button btn = (Button)findViewById(R.id.button);
        View car = (View)findViewById(R.id.imageView);
        TextView result = (TextView) findViewById(R.id.textView);
        if(Started && !Finished)
        {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin +=40;
            car.requestLayout();
            if(margin.rightMargin >1100)
            {
                //result.setVisibility(View.VISIBLE);
                result.setText("Победа первого игрока");
                btn.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
    public void  Drive2(View view)
    {
        Button button = (Button)findViewById(R.id.button3);
        Button btn = (Button)findViewById(R.id.button);
        View car = (View)findViewById(R.id.imageView2);
        TextView result = (TextView) findViewById(R.id.textView);
        if(Started && !Finished)
        {
            ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)car.getLayoutParams();
            margin.leftMargin +=40;
            margin.rightMargin +=40;
            car.requestLayout();
            if(margin.rightMargin >1100)
            {
                //result.setVisibility(View.VISIBLE);
                result.setText("Победа второго игрока");
                btn.setText("Заново");
                result.setTextColor(0xffe91E63);
                Finished = true;
            }
        }
    }
}