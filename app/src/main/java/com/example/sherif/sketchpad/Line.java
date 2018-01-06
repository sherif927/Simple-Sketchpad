package com.example.sherif.sketchpad;

import android.graphics.Path;

/**
 * Created by Sherif on 1/5/2018.
 */

public class Line {
    private int paint;
    private Path path;

    public Line(Path path, int paint) {
        this.paint = paint;
        this.path = path;
    }

    public int getPaint() {
        return paint;
    }

    public Path getPath() {
        return path;
    }

}
