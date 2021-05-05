package example;

import ie.tudublin.*;
import processing.core.PApplet;

public class MyVisual extends Visual
{
    Ball[] balls = new Ball[300];
    Ball2[] balls2 = new Ball2[15];

    public static Boolean isEven (Integer i)
    {
        return (i % 2)  == 0;

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

    int numCubes;
    Cube[] cubes;
    float strength = 0.10f;

    public void setup()
    {
        startMinim();
        colorMode(HSB);
        noCursor();

        setFrameSize(256);

        startMinim();
        loadAudio("BELLYACHE.mp3");
        //getAp().play();
        //startListening();

        numCubes = (int)(7+getSpecSize() * strength);
        cubes = new Cube[numCubes];

        for(int i = 0; i < numCubes; i++)
        {
            cubes[i] = new Cube(this);
        }

        for(int i = 0; i < balls.length; i++){
            balls[i] = new Ball(this);
          }

        for(int i = 0; i < balls2.length; i++){
            balls2[i] = new Ball2(this);
        }

    }

    float smoothedCircleSize0 = 0;
    float smoothedCircleSize1 = 0;

    public void drawWaveform() throws VisualException {

        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();

        calculateFFT();
        int cy = this.height/2;
        colorMode(PApplet.HSB);
        strokeWeight(0.1f);

        for(int i = 0 ; i < getAudioBuffer().size(); i ++)
        {
            stroke(
                    PApplet.map(i, 0, getAudioBuffer().size(), 0, 255)
                    , 255
                    , 255
            );

            float smoothedAmplitude = calculateAverageAmplitude();
            smoothedAmplitude = PApplet.lerp(getAudioBuffer().get(i), smoothedAmplitude, 0.35f);
            line(i, cy, i+130, cy + cy * smoothedAmplitude);
            line(i*-1, cy, i*-1-130, cy + cy * smoothedAmplitude);

        }
    }

    public void loopcircles()
    {
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 50, 255);

        angle += 0.01f;
        float CircleSize0 = 30 + (getAmplitude() * 150);//map(average, 0, 1, 100, 400);
        smoothedCircleSize0 = lerp(smoothedCircleSize0, CircleSize0, 0.2f);

        float CircleSize1 = 40 + (getAmplitude() * 200);//map(average, 0, 1, 100, 400);
        smoothedCircleSize1 = lerp(smoothedCircleSize1, CircleSize1, 1);

        translate(400, 400, -250);
        for (int i = 1; i < 4; i++)
        {

            if (isEven(i))
            {
                colorMode(PApplet.HSB);
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255,255,193);
                strokeWeight(1);

                circle(0,0,smoothedCircleSize0 * 2); // surrounding circle

            }
            else
            {
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255),200, 500,200);
                strokeWeight(10);
                sphere(smoothedCircleSize1 * 0.2f); // inner sphere
                strokeWeight(0.009f);
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 200), 0, 191,255);
                sphere(smoothedCircleSize1 * 160); // outer sphere (stars)

            }
        }
    }

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        loopcircles(); // Calls Circles

        translate(0,-400,0);

        try {
            drawWaveform();
        } catch (VisualException e) { // Calls Waveform
            e.printStackTrace();
        }

        translate(-400,0,0);

        for(int i = 0; i < balls2.length; i++){

            balls2[i].movement();
            balls2[i].display();
        }

        translate(400,0,0);

        for(int i = 0; i < numCubes; i++) // Calls Cubes
        {
            cubes[i].display();
        }

        translate(-550,-200,0);

        for(int i = 0; i < balls.length; i++){

            balls[i].movement();
            balls[i].display();
        }


        translate(0,0,0);

    }
    float angle = 0;

}