package ie.tudublin;

import processing.core.PFont;

public class Options extends Visual
{    
    MainVisual visualOption;
    PFont myFont;
    
    public Options(MainVisual visual){

        visualOption = visual;
    }
   
    public int options = 3;
    int boxHeight= 60;
    int boxWidth = 200;   

    public void settings()
    {
        size(200, 240);
    }

    public void setup()
    {
        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            visualOption.visualSwitch = (visualOption.visualSwitch + 1) % 3;

        }
    }

    public void draw()
    {
        background(0);

        for(int i = 0; i < options + 1  ; i++ ){
            
            noFill();
            stroke(10);            
            rect(0, i * boxHeight, boxWidth, boxHeight);

            if(mouseY >= i * boxHeight && mouseY < (i + 1) * boxHeight){

                fill(255, 100);
                rect(0, i * boxHeight, boxWidth, boxHeight);

                if(mousePressed){

                    if(i != 0){
                        visualOption.visualSwitch = i - 1;
                    }
                    else{
                        visualOption.playSong = 1;
                    }                    
                }
            }
        }
       
        myFont = createFont("Calibri light", 25);
        textFont(myFont);
        fill(255);
        textAlign(CENTER, CENTER);

        text("Play Song", boxWidth/2, boxHeight/2);
        text("Ceren", boxWidth/2, 1 * boxHeight + boxHeight/2);
        text("Isa", boxWidth/2, 2 * boxHeight + boxHeight/2);
        text("Rana", boxWidth/2, 3 * boxHeight + boxHeight/2);     
    }
}
