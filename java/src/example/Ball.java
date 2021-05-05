package example;

public class Ball {

    MyVisual b;
    MyVisual b2;

    float x;
    float y;
    float size;
    float speedX;
    float speedY;
    float ballwidth;
    float ballheight;
    int ballMax;
    int ballStart;

    Ball(MyVisual b){
        b.translate(-200,-200,0);
        ballwidth = b.width;
        ballheight = b.height;
        this.b = b;
        x = b.random(ballwidth+320);
        y = b.random(ballheight+320);

        speedX = b.random(-2,2);
        speedY = b.random(-2,2);
    }

    void movement(){

        ballStart = 1;
        ballMax = 50;

        if (speedX < 0 ) {
            speedX = (ballMax * b.calculateAverageAmplitudeInverse() * -1 ); // speed of cube
        }
        else{
            speedX = (ballMax * b.calculateAverageAmplitudeInverse() * 1 ); // speed of cube
        }

        if (speedY > 0 ) {
            speedY = (ballMax * b.calculateAverageAmplitude() * 1); // speed of cube
        }
        else{
            speedY = (ballMax * b.calculateAverageAmplitude() * -1); // speed of cube
        }

        if ((x > ballwidth+320) || (x < 0)) {
            speedX = speedX * - 1;
            speedY += b.random(-1,1);
        }

        if ((y > ballheight+320) || (y < 0)) {
            speedY = speedY * - 1;
            speedX += b.random(-1,1);
        }

        x = x + speedX;
        y = y + speedY;
    }

    void display(){
        b.strokeWeight(1);
        b.stroke(b.color(50,  150 + (500 * b.getAmplitude()),200));
        float size = 1.25f + (40 * b.getSmoothedAmplitude()); // size of cubes
        b.circle(x,y,size);

    }

}
