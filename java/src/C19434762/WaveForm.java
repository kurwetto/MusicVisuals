package C19434762;
import processing.core.PApplet;

public class WaveForm
{
    MyVisual wf;
    float cy = 0;

    public WaveForm(MyVisual wf)
    {
        this.wf = wf;
        cy = this.wf.height / 2.0f;

    }

        public void render()
        {
            wf.strokeWeight(0.1f);
            wf.colorMode(PApplet.HSB);

            for(int i = 0 ; i < wf.getAudioBuffer().size(); i ++)
            {
                wf.stroke(
                        PApplet.map(i, 0, wf.getAudioBuffer().size(), 0, 255)
                        , 255
                        , 255
                );

                float smoothedAmplitude = wf.calculateAverageAmplitude();
                smoothedAmplitude = PApplet.lerp(wf.getAudioBuffer().get(i), smoothedAmplitude, 0.35f);
                wf.line(i, cy, i+130, cy + cy * smoothedAmplitude);
                wf.line(i*-1, cy, i*-1-130, cy + cy * smoothedAmplitude);

            }
        }
}
