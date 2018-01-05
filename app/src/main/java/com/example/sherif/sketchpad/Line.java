package com.example.sherif.sketchpad;

import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Sherif on 1/5/2018.
 */

public class Line {
    private Paint paint;
    private Path path;

    public Line(Path path, Paint paint) {
        this.paint = paint;
        this.path = path;
    }

    public Paint getPaint() {
        return paint;
    }

    public Path getPath() {
        return path;
    }

}
