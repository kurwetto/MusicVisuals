package C19434762;

public class Ball {

    MyVisual b;

    float x;
    float y;
    float speedX;
    float speedY;
    float ballWidth;
    float ballHeight;
    int ballMax;
    int ballStart;

    Ball(MyVisual b)
    {
        b.translate(-200,-200,0);
        ballWidth = b.width;
        ballHeight = b.height;
        this.b = b;

        x = b.random(ballWidth+320); // spawns within canvas
        y = b.random(ballHeight+320);

        speedX = b.random(-2,2);
        speedY = b.random(-2,2);

    }

    void movement()
    {
        ballStart = 1;
        ballMax = 50;

        if (speedX < 0 )
        {
            speedX = (ballMax * b.calculateAverageAmplitudeInverse() * -1 );  // amplitude and amplitude inverse
        }
        else
        {
            speedX = (ballMax * b.calculateAverageAmplitudeInverse() * 1 );
        }

        if (speedY > 0 )
        {
            speedY = (ballMax * b.calculateAverageAmplitude() * 1);
        }
        else
        {
            speedY = (ballMax * b.calculateAverageAmplitude() * -1);
        }

        if ((x > ballWidth+320) || (x < 0))  // ball bounces back
        {
            speedX = speedX * - 1;
            speedY += b.random(-1,1);
        }

        if ((y > ballHeight+320) || (y < 0))
        {
            speedY = speedY * - 1;
            speedX += b.random(-1,1);
        }

        x = x + speedX;
        y = y + speedY;

    }

    void display()
    {
        b.strokeWeight(0.85f);
        b.stroke(b.color(50,  150 + (500 * b.getAmplitude()),200));

        float size = 1.5f + (40 * b.getSmoothedAmplitude()); // size of circle

        b.circle(x,y,size);

    }

}
