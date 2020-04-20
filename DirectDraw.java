import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.util.ArrayList;

public class DirectDraw extends JPanel {


	private BufferedImage canvas;
   
	public DirectDraw(int width, int height,ArrayList<Sphere> scene,Light l) {
        canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); 
        fillCanvas(width, height, scene,l);
}
	
	
    private void fillCanvas(int width, int height,ArrayList<Sphere> scene,Light l) {
    	final double Vwidth=1;
    	final double Vheight=1;
    	final double d=1;
    	
    	int color;

    	
	   Vector D=null;
	   for(int x=0;x<width;x++){
		  for(int y=0;y<height;y++){
			   D=new Vector(x*Vwidth/width,y*Vheight/height,d);
			   color=Mathan.TraceRay(scene,D,1.0,1.0/0.0,l);
			   canvas.setRGB(x, y,color);
		   } 
	   }
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(canvas, null, null);
    }
    
}