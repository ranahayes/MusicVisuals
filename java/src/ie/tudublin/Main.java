package ie.tudublin;

import c123456.*;

public class Main
{
    
	public void Menu()
	{
		MainVisual visualizer = new MainVisual();

		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, visualizer);
		String[] b = {"Second"};
        processing.core.PApplet.runSketch( b, new Options(visualizer));
    }


	public static void main(String[] args)
	{
		Main main = new Main();
		main.Menu();
	}
}






