import java.awt.Color;

public class Sphere{
	Vector center;
	double radius;
	Color color;
public Sphere(double x,double y,double z,double radius,Color color) {
	 this.center=new Vector(x,y,z);;
	 this.radius=radius;
	 this.color=color;
}
}
