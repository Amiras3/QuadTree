
 
public abstract class Figura {
	public int id ;
    public double x1 , x2 , y1 , y2 ;
    public Figura(){
       
    }
    public abstract void fill(int id) ;
    public abstract boolean point(double m , double n) ;
    public boolean intersectie(Figura o){
        double c1 = Math.max(x1 , o.x1) ;
        double c2 = Math.max(y1 , o.y1) ;
        double c3 = Math.min(x2 , o.x2) ;
        double c4 = Math.min(y2 , o.y2) ;
        return ((c1 <= c3) && (c2 <= c4)) ;
    }
    public boolean punct_figura(double a , double b){
        return x1 <= a && a <= x2 && y1 <= b && b <= y2 ;
    }
}
 
 