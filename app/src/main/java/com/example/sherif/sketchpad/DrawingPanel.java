package com.example.sherif.sketchpad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherif on 1/5/2018.
 */

public class DrawingPanel extends SurfaceView implements SurfaceHolder.Callback{
    private Context context;
    private Paint paint,selectedPaint;
    private int selectedColor;
    private Path path;
    private List<Line> canvasPaths;


    public DrawingPanel(Context context) {
        super(context);
        this.context=context;
        initializeView();
    }

    public DrawingPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        initializeView();
    }

    public DrawingPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        initializeView();
    }

    public void setPaintColor(int color){
        selectedPaint.setColor(color);
        selectedColor=color;
    }

    public void initializeView(){
        getHolder().addCallback(this);
        path=new Path();
        paint=new Paint();
        canvasPaths=new ArrayList<>();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5f);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        selectedPaint=paint;
        selectedColor=Color.BLACK;
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        setBackgroundColor(Color.WHITE);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                canvasPaths.add(new Line(path,selectedColor));
                path=new Path();
                break;
            default:
                return false;
        }invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        selectedPaint.setColor(selectedColor);
        canvas.drawPath(path,selectedPaint);
        for(int i=0;i<canvasPaths.size();i++){
            paint.setColor(canvasPaths.get(i).getPaint());
            canvas.drawPath(canvasPaths.get(i).getPath(),paint);
        }
    }

    public void popPath(){
        if(canvasPaths.size()>0){
            canvasPaths.remove(canvasPaths.size()-1);
            invalidate();
        }
    }

}
