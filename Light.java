public class Light {
	double intensity;
	Vector position=null;

public Light(double intensity,double x,double y,double z) {
	 this.intensity=intensity;
	 this.position=new Vector(x,y,z);
}

public double ComputeLighting(Vector P, Vector N) {
   double i = 0.1;//"окружающее освещение"
 
   Vector L = new Vector(this.position.x - P.x,this.position.y - P.y,this.position.z - P.z);
     
   double n_dot_l = N.scalarMult(L);
        if (n_dot_l > 0) {
           i += (this.intensity*n_dot_l)/(N.length()*L.length());
        }
    
    return i;
}
}
