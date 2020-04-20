public class Vector {
    double x;
    double y;
    double z;
 
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
 
    public double scalarMult(Vector c) {
        return x * c.x + y * c.y + z * c.z;
    }
    
    public void alphaMult(double alpha) {
    	x=x*alpha;
    	y=y*alpha;
    	z=z*alpha;
    }
    
    public void Norma(double length) {
    	x=x/length;
    	y=y/length;
    	z=z/length;
        
    }
    
    public static Vector summVect(Vector a,Vector b) {
    	Vector c=new Vector(a.x + b.x, a.y + b.y,a.z + b.z);
        return c;
    }
    
    public static Vector differVect(Vector a,Vector b) {
    	Vector c=new Vector(a.x - b.x, a.y -b.y,a.z - b.z);
        return c;
    }
    
    public double length() {
    	return Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z);
    }
  
    }