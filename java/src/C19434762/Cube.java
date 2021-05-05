package C19434762;
import processing.core.PApplet;

public class Cube
{
    MyVisual c;

    float CubeStart = -3000; // Z position min
    float CubeMax = 999; // Z position max

    float CubeX, CubeY, CubeZ;
    float rotateX, rotateY, rotateZ;
    float sumX, sumY, sumZ;


    Cube(MyVisual c)
    {
        this.c = c;

        CubeX = c.random(-600 , c.width);  // randomizes cubes x y z
        CubeY = c.random(-300 , c.height);
        CubeZ = c.random(CubeStart, CubeMax);

        rotateX = c.random (-2, 2); // min and max of cube rotation
        rotateY = c.random (-2, 2);
        rotateZ = c.random (-2, 2);

    }

    void display()
    {
        c.fill(PApplet.map(c.getAmplitude() * 255, 100, 255, 0, 100), 255, 255, c.getAmplitude() * 420); // inner color with amp
        c.stroke(c.color(200,  100 + (500 * c.getAmplitude()))); // cube outline
        c.strokeWeight(1 + (c.getAmplitude() * 10));
        c.pushMatrix();

        c.translate(CubeX, CubeY, CubeZ);

        sumX += c.getAmplitude() * (rotateX / 3); // calculates rotation amp
        sumY += c.getAmplitude() * (rotateY / 3);
        sumZ += c.getAmplitude() * (rotateZ / 3);

        c.rotateX(sumX); // rotates cubes
        c.rotateY(sumY);
        c.rotateZ(sumZ);

        float boxSize = 60 + (100 * c.getSmoothedAmplitude()); // size of cubes
        c.box(boxSize);
        c.popMatrix();

        CubeZ += ((CubeMax * c.getAmplitude()) * 0.2f) + 1; // speed of cube from start to finish
        if (CubeZ >= CubeMax)
        {
            CubeZ = CubeStart;
        }

    }
}

