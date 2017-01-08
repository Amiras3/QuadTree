
public class Romb extends Figura {
	double a1, a2, a3, a4, b1, b2, b3, b4;

	public Romb() {

	}

	public Romb(double a1, double b1, double a2, double b2, double a3, double b3, double a4, double b4) {
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.b4 = b4;
	}

	@Override
	public void fill(int id) {
		this.id = id;
		x1 = a1;
		x1 = Math.min(x1, a2);
		x1 = Math.min(x1, a3);
		x1 = Math.min(x1, a4);
		x2 = a1;
		x2 = Math.max(x2, a2);
		x2 = Math.max(x2, a3);
		x2 = Math.max(x2, a4);
		y1 = b1;
		y1 = Math.min(y1, b2);
		y1 = Math.min(y1, b3);
		y1 = Math.min(y1, b4);
		y2 = b1;
		y2 = Math.max(y2, b2);
		y2 = Math.max(y2, b3);
		y2 = Math.max(y2, b4);
	}

	@Override
	public boolean point(double m, double n){
		Triunghi t = new Triunghi(a1 , b1 , a2 , b2 , a3 , b3) ;
		Triunghi t1 = new Triunghi(a1 , b1 , a3 , b3 , a4 , b4) ;
		if (t.point(m , n) || t1.point(m, n)) {
			return true;
		} else {
			return false;
		}
	}
}