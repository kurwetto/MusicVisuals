package example;

import ie.tudublin.*;
import processing.core.PApplet;

public class CubeVisual extends Visual
{
    WaveForm wf;
    AudioBandsVisual abv;

    public static Boolean isEven (Integer i)
    {
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
        startMinim();
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
        calculateAverageAmplitude();

        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 50, 255);

        angle += 0.01f;
        float CircleSize0 = 30 + (getAmplitude() * 200);//map(average, 0, 1, 100, 400);
        smoothedCircleSize0 = lerp(smoothedCircleSize0, CircleSize0, 0.2f);

        float CircleSize1 = 40 + (getAmplitude() * 250);//map(average, 0, 1, 100, 400);
        smoothedCircleSize1 = lerp(smoothedCircleSize1, CircleSize1, 1);

        translate(400, 400, -250);
        for (int i = 1; i < 4; i++)
        {

            if (isEven(i))
            {
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255,255,193);
                strokeWeight(1);

                circle(0,0,smoothedCircleSize0 * 2);

            }
            else
            {
                stroke(map(getSmoothedAmplitude(), 0, 1, 0, 20), 0, 191,255);
                strokeWeight(0.03f);

                sphere(smoothedCircleSize1 * 1.2f);

            }
        }
    }

    public void drawwaveform() throws VisualException {

        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();

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

            line(i, cy, i+50, cy + cy * getAudioBuffer().get(i));
            line(i*-1, cy, i*-1-50, cy + cy * getAudioBuffer().get(i));
            System.out.println(getAudioBuffer().get(i));
            System.out.println(i);

        }
    }

    public void draw()
    {
        background(0);
        //camera(0, 0, 0, 0, 0, -1, 0, 1, 0);

        loopcircles();
        translate(0,-400,0);

        try {
            drawwaveform();
        } catch (VisualException e) {
            e.printStackTrace();
        }

    }

    float angle = 0;
}