package com.example.macpro.newproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

public class OwnProgressBar extends View {

    Handler handler;

    public OwnProgressBar(Context context) {
        super(context);
    }

    public OwnProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        handler = new Handler();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };
    int delay = 0, delay1 = 0, delay2 = 0, delay3 = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#33cc33"));

        canvas.save();
        canvas.drawRect(80, 0, 80+delay, 20, paint);
        canvas.restore();

        if (delay <= 250) {
            delay += 10;
        }
        if (delay > 250) {
            canvas.save();
            paint.setColor(Color.parseColor("#1a75ff"));
            canvas.drawRect(80, 40, 80+delay1, 60, paint);
            canvas.restore();

            if (delay1 <= 300) {
                delay1 += 10;
            }
            if (delay1 > 300) {
                canvas.save();
                paint.setColor(Color.parseColor("#ff3333"));
                canvas.drawRect(80, 80, 80+delay2, 100, paint);
                canvas.restore();

                if (delay2 <= 350) {
                    delay2 += 10;
                }
                if (delay2 > 350) {
                    canvas.save();
                    paint.setColor(Color.parseColor("#ff99ff"));
                    canvas.drawRect(80, 120, 80+delay3, 140, paint);
                    canvas.restore();

                    if (delay3 <= 400) {
                        delay3 += 10;
                    }
                }

            }
        }
        handler.postDelayed(runnable, 3);
    }
}
