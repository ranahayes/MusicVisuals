package c123456;

import ie.tudublin.*;

class Branch {

    MainVisual mv;

    float start;
    float amplitude; 
    float angle = 0;

    Branch[] branches;

    Branch(MainVisual mv,float start, float amplitude, float angle, int branches){

        this.mv = mv;
        this.start = start;
        this.amplitude = amplitude;
        this.angle = angle;

        branch(branches); 
    }

    void display(){
        
        mv.rotate(this.angle);
        mv.line(0, 0, 0, amplitude);

        if(branches != null){
            mv.translate(0, amplitude);
            mv.pushMatrix();
            branches[0].display();
            mv.popMatrix();
            branches[1].display();         
        } 
    } 

    void branch(int numOfBranches){

        if (numOfBranches > 0){
        
            branches = new Branch[2];
            mv.branchCounter++;

            float angle = MainVisual.map(mv.smothedAmplitude,0,1,3.14f/5f,3.14f/2f);
            
            branches[0] = new Branch(mv, start-amplitude, amplitude/1.5f, angle, numOfBranches-2);
            branches[1] = new Branch(mv, start-amplitude, amplitude/1.5f, -angle, numOfBranches-2);
        }
    }
}

public class IsaVisual extends Visual {

    MainVisual mv;

    Branch branch1;
    Branch branch2;

    public IsaVisual(MainVisual mv) {
        this.mv = mv;
    }

    public void draw() {

        mv.colorMode(MainVisual.HSB);
        mv.strokeWeight(0.7f);
        mv.fill(0,20);
        mv.rect(-1, -1, mv.width+1, mv.height+1);

        mv.counter++;

        for( int i = 0; i < 9; i++ ){

            mv.resetMatrix();
            mv.translate(mv.width/2, mv.height/2);
            mv.branchCounter = 0;

            mv.rotate(MainVisual.map(mv.counter%360, 0, 360, 0, MainVisual.PI*1.5f));
            mv.rotate(MainVisual.map((float)i, 0f, 6f, 0f, MainVisual.PI*1.5f));

            branch1 = new Branch(mv, 0f, MainVisual.map(mv.smothedAmplitude,0,.6f,-mv.height/60f,-mv.height/3.5f), 0,14);
            branch2 = new Branch(mv, 0f, MainVisual.map(mv.smothedAmplitude,0,.6f,-mv.height/60f,-mv.height/3.5f), 0,16);
          
            mv.fill((mv.counter/8)%255);
            mv.stroke((mv.counter/8)%random(255));
            branch1.display();

            mv.fill((mv.counter/2)%255);
            mv.stroke((mv.counter/2)%255,255,255);
            branch2.display();

        }

    }
    
}
