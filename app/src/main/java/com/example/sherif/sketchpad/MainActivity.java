package com.example.sherif.sketchpad;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView red,green,blue,black,back;
    private DrawingPanel panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize image-views
        red=(ImageView)findViewById(R.id.img_red);
        green=(ImageView)findViewById(R.id.img_green);
        blue=(ImageView)findViewById(R.id.img_blue);
        black=(ImageView)findViewById(R.id.img_black);
        back=(ImageView)findViewById(R.id.img_back);

        //initialize the drawing panel
        panel=(DrawingPanel)findViewById(R.id.drawing_panel);

        //setting event-handlers
        red.setOnClickListener(this);
        green.setOnClickListener(this);
        blue.setOnClickListener(this);
        black.setOnClickListener(this);
        back.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_red:
                panel.setCanvasColor(Color.RED);
                break;
            case R.id.img_green:
                panel.setCanvasColor(Color.GREEN);
                break;
            case R.id.img_blue:
                panel.setCanvasColor(Color.BLUE);
                break;
            case R.id.img_black:
                panel.setCanvasColor(Color.BLACK);
                break;
            case R.id.img_back:
                panel.popPath();
                break;
        }
    }
}
