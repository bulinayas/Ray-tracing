import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		final int Cwidth=1920;
		final int Cheight=1080;
			
		ArrayList<Sphere> scene = new ArrayList<>();
	
		Sphere sph1=new Sphere(20,10,30,3,Color.yellow);
		Sphere sph2=new Sphere(10,10,40,5,Color.blue);
		scene.add(sph1);
		scene.add(sph2);
		   
		Light l=new Light(0.9,25,0,2);
		
		JFrame frame = new JFrame("Direct draw");
		   
		DirectDraw pictute=new DirectDraw(Cwidth,Cheight,scene,l);
		
	    frame.add(pictute);
	    frame.pack();
	    frame.setVisible(true);
	    frame.setResizable(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
	}
}
