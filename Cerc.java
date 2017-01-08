
 
public class Cerc extends Figura{
    double raza , a , b ;
    public Cerc(){
       
    }
    public Cerc(double raza , double a , double b){
        this.raza = raza ;
        this.a = a ;
        this.b = b ;
    }
    @Override
    public void fill(int id){
    	this.id = id ;
        x1 = a - raza ;
        x2 = a + raza ;
        y1 = b - raza ;
        y2 = b + raza ;
    }
    @Override
    public boolean point(double m , double n){
    	if((m - a) * (m - a) + (n - b) * (n - b) <= raza * raza){
    		return true ;
    	}
    	return false ;
    }
}