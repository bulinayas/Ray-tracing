import java.awt.Color;
import java.util.ArrayList;

public class Mathan {
	public static final double POSITIVE_INFINITY = 1.0 / 0.0;
	static Vector O=new Vector(0,0,0);
	
	public static double get_time(Vector D, Sphere sph) {
		Vector C=sph.center;
		double r =sph.radius;
		
		Vector OC=Vector.differVect(O,C);
		
		double k1=D.scalarMult(D);
		double k2=2*OC.scalarMult(D);
		double k3=OC.scalarMult(OC)-r*r;
		double t=0;
		
		double diskr=k2*k2-4*k1*k3;
		
		if(diskr<0) {
		t= POSITIVE_INFINITY;
		}
		else {
			
			t= (-k2-Math.sqrt(diskr))/(2*k1);
			
			if(t<0) {
				t= (-k2+Math.sqrt(diskr))/(2*k1);
				}	
		}
		
		return t;
	}
	
	public static int TraceRay(ArrayList<Sphere> scene,Vector D, double t_min, double t_max,Light l) {
		double closest_t = POSITIVE_INFINITY;
		double t=0;

		Sphere closest_sphere = null;
	
		for(Sphere sph: scene) {
			t=get_time(D,sph);
			
	
			if(t>t_min && t<t_max && t<closest_t) {
			closest_t = t;
		    closest_sphere = sph;
		    }
		}
	
		if (closest_sphere == null){
		   return Color.white.getRGB();
		}
		else {
			D.alphaMult(closest_t);
			Vector P = Vector.summVect(O, D);  
			Vector N =Vector.differVect(P,closest_sphere.center); 
			N.Norma(N.length());
			double k=l.ComputeLighting(P, N);
			int R=(int) (k*closest_sphere.color.getRed());
			int G=(int) (k*closest_sphere.color.getGreen());
			int B=(int) (k*closest_sphere.color.getBlue());
			Color col=new Color(R,G,B,255);
			return col.getRGB();
	}
}
	
	
}
