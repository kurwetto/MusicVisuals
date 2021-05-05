package example;

import processing.core.PApplet;

import java.awt.*;

public class Ball2 {

    MyVisual b;

    float x;
    float y;
    float size;
    float speedX;
    float speedY;
    float ballwidth;
    float ballheight;
    int ballMax;
    int ballStart;

    Ball2(MyVisual b) {
        b.translate(-200, -200, 0);
        ballwidth = b.width;
        ballheight = b.height;
        this.b = b;
        x = b.random(ballwidth);
        y = b.random(ballheight);
        size = 15;
        speedX = 0;
        speedY = 0;
    }

    void movement() {

        ballStart = 50;
        ballMax = 200;
        final float Gravity = (float) 0.98;
        float Bounce = -0.85f; // 15% decrease

        speedY += Gravity;
        y += speedY;
        if (y > b.height) {
            speedY *= -1;
        }
    }



    void display() {
        b.strokeWeight(1);
        b.stroke(PApplet.map(b.getAmplitude(), 100, 200, 0, 255), -200, 255, 255);
        b.circle(x, y, size);
    }
}