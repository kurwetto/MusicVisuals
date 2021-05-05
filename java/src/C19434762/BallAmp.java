package C19434762;

import C19434762.MyVisual;

public class BallAmp {

    MyVisual ba;

    float x;
    float y;
    float size;
    float speedX;
    float speedY;
    float ballwidth;
    float ballheight;
    int ballMax;
    int ballStart;

    BallAmp(MyVisual ba){
        ba.translate(-200,-200,0);
        ballwidth = ba.width;
        ballheight = ba.height;
        this.ba = ba;
        x = ba.random(ballwidth+320);
        y = ba.random(ballheight+320);

        speedX = ba.random(-2,2);
        speedY = ba.random(-2,2);
    }

    void movement(){

        ballStart = 1;
        ballMax = 50;

        if (speedX < 0 ) {
            speedX = (ballMax * ba.calculateAverageAmplitudeInverse() * -1 ); // speed of cube
        }
        else{
            speedX = (ballMax * ba.calculateAverageAmplitudeInverse() * 1 ); // speed of cube
        }

        if (speedY > 0 ) {
            speedY = (ballMax * ba.calculateAverageAmplitude() * 1); // speed of cube
        }
        else{
            speedY = (ballMax * ba.calculateAverageAmplitude() * -1); // speed of cube
        }

        if ((x > ballwidth+320) || (x < 0)) {
            speedX = speedX * - 1;
            speedY += ba.random(-1,1);
        }

        if ((y > ballheight+320) || (y < 0)) {
            speedY = speedY * - 1;
            speedX += ba.random(-1,1);
        }

        x = x + speedX;
        y = y + speedY;
    }

    void display(){
        ba.strokeWeight(6.75f);
        ba.stroke(ba.color(255,  0,200, 0.0001f + ba.getAmplitude()* 700));
        float size = 4.75f + (40 * ba.getSmoothedAmplitude()); // size of cubes
        ba.circle(x,y,size);

    }

}
