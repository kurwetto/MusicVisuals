package example;
import processing.core.PApplet;

public class Cube
{
    MyVisual c;

    float CubeStart = -3000;
    float CubeMax = 999;

    float CubeX, CubeY, CubeZ;
    float rotateX, rotateY, rotateZ;
    float sumRotX, sumRotY, sumRotZ;

    // Constructor
    Cube(MyVisual c)
    {
        this.c = c;

        CubeX = c.random(-600 , c.width);
        CubeY = c.random(-300 , c.height);
        CubeZ = c.random(CubeStart, CubeMax);

        rotateX = c.random (0, 1);
        rotateY = c.random (0, 1);
        rotateZ = c.random (0, 1);
    }

    void display()
    {
        c.fill(PApplet.map(c.getAmplitude() * 255, 100, 255, 0, 100), 255, 255, c.getAmplitude() * 250);

        c.stroke(c.color(200,  100 + (500 * c.getAmplitude())));
        c.strokeWeight(1 + (c.getAmplitude() * 10));
        c.pushMatrix();
        c.translate(CubeX, CubeY, CubeZ);

        sumRotX += c.getAmplitude() * (rotateX / 3);
        sumRotY += c.getAmplitude() * (rotateY / 3);
        sumRotZ += c.getAmplitude() * (rotateZ / 3);

        c.rotateX(sumRotX);
        c.rotateY(sumRotY);
        c.rotateZ(sumRotZ);
        float boxSize = 60 + (100 * c.getSmoothedAmplitude());
        c.box(boxSize);
        c.box(10);
        c.popMatrix();


        CubeZ += ((CubeMax * c.getAmplitude()) * 0.2f) + 1;
        if (CubeZ >= CubeMax)
        {
            CubeZ = CubeStart;
        }
    }
}

