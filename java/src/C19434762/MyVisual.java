package C19434762;

import ie.tudublin.*;
import processing.core.PApplet;

public class MyVisual extends Visual
{
    WaveForm wf;
    Circles cr;
    Ball[] balls = new Ball[200];
    BallAmp[] ballAmps = new BallAmp[150];

    int numCubes;
    Cube[] cubes;
    float strength = 0.10f;
    float smoothedCircleSize0 = 0;
    float smoothedCircleSize1 = 0;

    public static Boolean isEven (Integer i)
    {
        return (i % 2)  == 0;

    }

    public void settings()
    {
        size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
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
        startMinim();
        colorMode(RGB);
        noCursor();

        setFrameSize(256);

        startMinim();
        loadAudio("JEZIORKO.mp3");

        numCubes = (int)(7 + getSpecSize() * strength);
        cubes = new Cube[numCubes];

        for(int i = 0; i < numCubes; i++)
        {
            cubes[i] = new Cube(this);
        }

        for(int i = 0; i < balls.length; i++)
        {
            balls[i] = new Ball(this);
        }

        for(int i = 0; i < ballAmps.length; i++)
        {
            ballAmps[i] = new BallAmp(this);
        }

        wf = new WaveForm(this);
        cr = new Circles(this);
    }



    public void draw()
    {
        colorMode(RGB);
        calculateAverageAmplitude();
        background(0);

        cr.display();

        translate(0,-400,0);

        wf.render();

        translate(-400,0,0);

        translate(400,0,0);

        colorMode(RGB);
        for(int i = 0; i < numCubes; i++) // Calls Cubes
        {
            cubes[i].display();
        }

        translate(-550,-200,0);

        colorMode(RGB);
        for (Ball ball : balls)
        {
            ball.movement();
            ball.display();

        }

        for (BallAmp ballAmp : ballAmps)
        {
            ballAmp.movement();
            ballAmp.display();

        }

        translate(0,0,0);

    }
    float angle = 0;

}