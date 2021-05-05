package C19434762;

public class BallAmp {

    MyVisual ba;

    float x;
    float y;
    float size;
    float speedX;
    float speedY;
    float ballWidth;
    float ballHeight;
    int ballMax;
    int ballStart;

    BallAmp(MyVisual ba)
    {
        ba.translate(-200,-200,0);
        ballWidth = ba.width;
        ballHeight = ba.height;
        this.ba = ba;

        x = ba.random(ballWidth+320); // spawns within canvas
        y = ba.random(ballHeight+320);

        speedX = ba.random(-2,2);
        speedY = ba.random(-2,2);

    }

    void movement()
    {
        ballStart = 1;
        ballMax = 50;

        if (speedX < 0 )
        {
            speedX = (ballMax * ba.calculateAverageAmplitudeInverse() * -1 ); // amplitude and amplitudes inverse
        }
        else
        {
            speedX = (ballMax * ba.calculateAverageAmplitudeInverse() * 1 );
        }

        if (speedY > 0 )
        {
            speedY = (ballMax * ba.calculateAverageAmplitude() * 1);
        }
        else
        {
            speedY = (ballMax * ba.calculateAverageAmplitude() * -1);
        }

        if ((x > ballWidth+320) || (x < 0))  // ball bounces back
        {
            speedX = speedX * - 1;
            speedY += ba.random(-1,1);
        }

        if ((y > ballHeight+320) || (y < 0))
        {
            speedY = speedY * - 1;
            speedX += ba.random(-1,1);
        }

        x = x + speedX;
        y = y + speedY;

    }

    void display()
    {
        ba.strokeWeight(6.75f);
        ba.stroke(ba.color(255,  0,200, 0.0001f + ba.getAmplitude()* 700));

        float size = 4.75f + (40 * ba.getSmoothedAmplitude()); // size of circle

        ba.circle(x,y,size);

    }
}
