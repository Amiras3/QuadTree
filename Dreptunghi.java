
 
public class Dreptunghi extends Figura{
    public double a1 , a2 , b1 , b2 ;
    public Dreptunghi(){
       
    }
    public Dreptunghi(double a1 , double b1 , double a2 , double b2){
        this.a1 = a1 ;
        this.a2 = a2 ;
        this.b1 = b1 ;
        this.b2 = b2 ;
    }
    @Override
    public void fill(int id){
    	this.id = id ;
        x1 = a1 ;
        x2 = a2 ;
        y1 = b1 ;
        y2 = b2 ;
    }
    public boolean point(double m , double n){
    	if(a1 <= m && m <= a2 && b1 <= n && n <= b2){
    		return true ;
    	}
    	return false ;
    }
}