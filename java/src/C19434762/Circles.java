package C19434762;

import processing.core.PApplet;

public class Circles {

    MyVisual cr;

    public Circles (MyVisual cr){
        this.cr = cr;
    }

    public void display()
    {
        cr.colorMode(PApplet.HSB);
        cr.noFill();
        cr.lights();
        cr.stroke(PApplet.map(cr.getSmoothedAmplitude(), 0, 1, 0, 255), 50, 255);

        cr.angle += 0.01f;
            float CircleSize0 = 30 + (cr.getAmplitude() * 150);//map(average, 0, 1, 100, 400);
        cr.smoothedCircleSize0 = PApplet.lerp(cr.smoothedCircleSize0, CircleSize0, 0.2f);

            float CircleSize1 = 40 + (cr.getAmplitude() * 200);//map(average, 0, 1, 100, 400);
        cr.smoothedCircleSize1 = PApplet.lerp(cr.smoothedCircleSize1, CircleSize1, 1);

        cr.translate(400, 400, -250);
            for (int i = 1; i < 4; i++)
            {

                if (MyVisual.isEven(i))
                {
                    cr.stroke(PApplet.map(cr.getSmoothedAmplitude(), 0, 1, 0, 255), 255,255,193);
                    cr.strokeWeight(1);

                    cr.circle(0,0,cr.smoothedCircleSize0 * 2); // surrounding circle

                }
                else
                {
                    cr.stroke(PApplet.map(cr.getSmoothedAmplitude(), 0, 1, 0, 255),200, 500,200);
                    cr.strokeWeight(10);
                    cr.sphere(cr.smoothedCircleSize1 * 0.2f); // inner sphere
                    cr.strokeWeight(0.009f);
                    cr.stroke(PApplet.map(cr.getSmoothedAmplitude(), 0, 1, 0, 200), 0, 191,255);
                    cr.sphere(cr.smoothedCircleSize1 * 160); // outer sphere (stars)

                }
            }
        }
    }

