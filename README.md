# Music Visualiser Project

Name:

Student Number: C19434762

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
For this assignment I was required to create my own version of an audio visualiser, I created a music visualiser for this project, something that one can watch while listening to music.

# Instructions

# How it works
I created varius classes.

1) Ball
2) BallAmp
3) Circles
4) Cube
5) Waveform

#Ball
The balls are in an array which creates the background images of the stars(blue), their movement is based off the beat or amplitude of the song ( when the beat switches the amplitude inverses) and bounce off the sides of canvas.
```Java
   void display()
    {
        b.strokeWeight(0.85f);
        b.stroke(b.color(50,  150 + (500 * b.getAmplitude()),200));

        float size = 1.5f + (40 * b.getSmoothedAmplitude()); // size of circle

        b.circle(x,y,size);

    }
```
This code draws the cirlce at the end of the class.

#BallAmp
The balls are in an array which creates the background image of the stars(pink), they work the same way as the balls above however they remain invisble until the amplitude increases, this is done by * the transparency by the ampltitude.
```Java
   void display()
    {
        ba.strokeWeight(6.75f);
        ba.stroke(ba.color(255,  0,200, 0.0001f + ba.getAmplitude()* 700));
```

#Cube
The cubes spawn at a negative z location whilst rotating and flying towards their maximum z value. They change size, color and transparency based on amplitude.
```Java
 void display()
        {
            n.fill(PApplet.map(n.getAmplitude() * 255, 0, 255, n.fBase, n.fSet), 255, 255, n.getAmplitude() * 250);
        
            n.stroke(n.color(255,  100 - (500 * n.getAmplitude())));
            n.strokeWeight(1 + (n.getAmplitude() * 10));
            n.pushMatrix();
            n.translate(x, y, z);

            
            sumRotX += n.getAmplitude() * (rotX / 5);
            sumRotY += n.getAmplitude() * (rotY / 5);
            sumRotZ += n.getAmplitude() * (rotZ / 5);


            n.rotateX(sumRotX);
            n.rotateY(sumRotY);
            n.rotateZ(sumRotZ);
            float boxSize = 100 + (200 * n.getSmoothedAmplitude());
            n.box(boxSize);
            n.popMatrix();


            z += ((maxZ * n.getAmplitude()) * 0.4f) + 1;
            if (z >= maxZ)
            {
                z = startingZ;
            }
        }
```

# What I am most proud of in the assignment

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

