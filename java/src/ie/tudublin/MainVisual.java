package ie.tudublin;
//import example.*;

public class MainVisual extends Visual
{
    int visualSwitch = 0;
    int playSong = 0;
    int stopSong = 0;
    public float eRadius;
    //int mode = 0;

    IsaVisual isa;
    //WaveForm audio1;

    public float counter = 0;
    public int branchCounter = 0;
    
    public void settings()
    {
        size(1400, 800);
        //size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }


    public void setup()
    {
        startMinim();

        loadAudio("Parasite.mp3");

        BeatDetect();
        ellipseMode(RADIUS);
        eRadius = 15;
        colorMode(HSB);
       
        isa = new IsaVisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            as.stop();
            as.trigger();
        }
        /*if (keyCode >= '1' && keyCode <= '3')
        {
            adamOption = keyCode - '0';
        }*/
    }
 
    /*public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}*/

    public void draw()
    {

        if(playSong == 1){
            as.stop();
            as.trigger();
            playSong = 0;
        }

        try
        {
            calculateFFT();
        }

        catch(VisualException e)
        {
            e.printStackTrace();
        }
        
        calculateFrequencyBands();        
        calculateAverageAmplitude();
        
        switch(visualSwitch){

            case 1 :
                isa.draw();
                break;

            default:
                background(0);
                //audio1.render();
                break;
        }
    }
}
