package amir.copy;
 
public class Triunghi extends Figura{
    double a1 , a2 , a3 , b1 , b2 , b3 ;
    public Triunghi(){
       
    }
    public Triunghi(double a1 , double b1 , double a2 , double b2 , double a3 , double b3){
        this.a1 = a1 ;
        this.a2 = a2;
        this.b1 = b1 ;
        this.b2 = b2 ;
        this.a3 = a3 ;
        this.b3 = b3 ;
    }
    @Override
    public void fill(int id){
    	this.id = id ;
        x1 = a1 ;
        x1 = Math.min(x1, a2) ;
        x1 = Math.min(x1 , a3) ;
        x2 = a1 ;
        x2 = Math.max(x2, a2) ;
        x2 = Math.max(x2, a3) ;
        y1 = b1 ;
        y1 = Math.min(y1, b2) ;
        y1 = Math.min(y1 , b3) ;
        y2 = b1 ;
        y2 = Math.max(y2, b2) ;
        y2 = Math.max(y2, b3) ;
    }
    @Override
    public boolean point(double m , double n){
    	double arie = a2 * b3 - b2 * a3 - a1 * b3 + a1 * b2 + b1 * a3 - b1 * a2 ;
    	if(arie <= 0){
    		arie = - arie ;
    	}
    	double arie1 = a2 * b3 - b2 * a3 - m * b3 + m * b2 + n * a3 - n * a2 ;
    	if(arie1 <= 0){
    		arie1 = -arie1 ;
    	}
    	double arie2 = m * b3 - n * a3 - a1 * b3 + a1 * n + b1 * a3 - b1 * m ;
    	if(arie2 <= 0){
    		arie2 = - arie2 ;
    	}
    	double arie3 = a2 * n - b2 * m - a1 * n + a1 * b2 + b1 * m - b1 * a2 ;
    	if(arie3 <= 0){
    		arie3 = - arie3 ;
    	}
    	if(arie == arie1 + arie2 + arie3){
    		return true ;
    	}
    	else{
    		return false ;
    	}
    }
}