package example;

import ie.tudublin.Visual;

public class CubeVisual extends Visual
{

    public static Boolean isEven (Integer i) {

        return (i % 2) == 0;

    }

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        //fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
    }

    public void setup()
    {
        colorMode(HSB);
        noCursor();
        
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        //getAp().play();
        //startListening(); 
        
    }

    float smoothedCircleSize0 = 0;
    float smoothedCircleSize1 = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 50, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0, 0, -250);

        loopcircles();

        angle += 0.01f;

    }

    public void circles() // drawing circles
    {
        float CircleSize0 = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400);
        smoothedCircleSize0 = lerp(smoothedCircleSize0, CircleSize0, 0.2f);

        rotateY(angle);
        rotateX(angle);
        strokeWeight(0.1f);
        sphere(smoothedCircleSize0/ 2);

        float CircleSize1 = 30 + (getAmplitude() * 1000);//map(average, 0, 1, 100, 400);
        smoothedCircleSize1 = lerp(smoothedCircleSize1, CircleSize1, 0.4f);

        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        rotateY(angle);
        rotateX(angle);
        strokeWeight(2);
        sphere(smoothedCircleSize1/ 2);
    }

    public void loopcircles()
    {
        float CircleSize0 = 50 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400);
        smoothedCircleSize0 = lerp(smoothedCircleSize0, CircleSize0, 0.2f);

        float CircleSize1 = 100 + (getAmplitude() * 500);//map(average, 0, 1, 100, 400);
        smoothedCircleSize1 = lerp(smoothedCircleSize1, CircleSize1, 1);

        for (int i = 1; i < 4; i++)
        {

            if (isEven(i))
            {
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                strokeWeight(0.01f);
                sphere(smoothedCircleSize0/ 2);
                rotateY(angle * -1);
                rotateX(angle * -1);

            }
            else
            {
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 50, 60);
                strokeWeight(0.01f);
                sphere(smoothedCircleSize1/ 2);
                rotateY(angle);
                rotateX(angle);

            }
        }

    }
    float angle = 0;
}