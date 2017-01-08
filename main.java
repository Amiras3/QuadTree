
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.* ;

import javax.annotation.processing.Filer;

public class main {
    public static void main(String[] args) throws IOException{
    	int id , operatie , tip ;
    	double a1 , a2 , a3 , a4 , b1 , b2 , b3 , b4  , raza;
    	Figura[] figuri = new Figura[100000 + 10] ;
    	int nr_figuri = 0 ; 
    	ArrayList<Integer> v ;
    	BufferedReader in = null;
    	in = new BufferedReader(new FileReader("quadtree.in"));
    	BufferedWriter out = new BufferedWriter(new FileWriter("quadtree.out"));
    	String linie ;
    	String[] rand = new String[100] ; 
    	linie = in.readLine() ;
    	rand = linie.split(" ") ;
    	a1 = Double.parseDouble(rand[0]);
    	b1 = Double.parseDouble(rand[1]);
    	a2 = Double.parseDouble(rand[2]);
    	b2 = Double.parseDouble(rand[3]);
    	Node quad = new Node(a1 , b1 , a2 , b2) ;
    	while((linie = in.readLine()) != null){
    		rand = linie.split(" ") ;
    		operatie = Integer.parseInt(rand[0]) ;
    		if(operatie == 11){
    			tip =  Integer.parseInt(rand[1]) ;
    			if(tip == 1){
    				id = Integer.parseInt(rand[2]) ;
    				a1 = Double.parseDouble(rand[3]);
    		    	b1 = Double.parseDouble(rand[4]);
    		    	a2 = Double.parseDouble(rand[5]);
    		    	b2 = Double.parseDouble(rand[6]);
    		    	Dreptunghi d = new Dreptunghi(a1 , b1 , a2 , b2) ;
    		    	d.fill(id); 
    		    	quad.insert(quad, d);
    		    	nr_figuri ++ ;
    		    	figuri[nr_figuri - 1] = d ;
    			}
    			if(tip == 2){
    				id = Integer.parseInt(rand[2]) ;
    				a1 = Double.parseDouble(rand[3]);
    		    	b1 = Double.parseDouble(rand[4]);
    		    	a2 = Double.parseDouble(rand[5]);
    		    	b2 = Double.parseDouble(rand[6]);
    		    	a3 = Double.parseDouble(rand[7]) ;
    		    	b3 = Double.parseDouble(rand[8]) ;
    		    	Triunghi t = new Triunghi(a1 , b1 , a2 , b2 , a3 , b3) ;
    		    	t.fill(id); 
    		    	quad.insert(quad ,  t); 
    		    	nr_figuri ++ ;
    		    	figuri[nr_figuri - 1] = t ;
    			}
    			if(tip == 3){
    				id = Integer.parseInt(rand[2]) ;
    				raza = Double.parseDouble(rand[3]) ;
    				a1 = Double.parseDouble(rand[4]);
    		    	b1 = Double.parseDouble(rand[5]);
    		    	Cerc c = new Cerc(raza , a1 , b1) ;
    		    	c.fill(id); 
    		    	quad.insert(quad, c);
    		    	nr_figuri ++ ;
    		    	figuri[nr_figuri - 1] = c ;
    			}
    			if(tip == 4){
    				id = Integer.parseInt(rand[2]) ;
    				a1 = Double.parseDouble(rand[3]);
    		    	b1 = Double.parseDouble(rand[4]);
    		    	a2 = Double.parseDouble(rand[5]);
    		    	b2 = Double.parseDouble(rand[6]);
    		    	a3 = Double.parseDouble(rand[7]) ;
    		    	b3 = Double.parseDouble(rand[8]) ;
    		    	a4 = Double.parseDouble(rand[9]) ;
    		    	b4 = Double.parseDouble(rand[10]) ;
    		    	Romb r = new Romb(a1 , b1 , a2 , b2 , a3 , b3 , a4 , b4) ;
    		    	r.fill(id); 
    		    	quad.insert(quad ,  r); 
    		    	nr_figuri ++ ;
    		    	figuri[nr_figuri - 1] = r ;
    			}
    			
    		}
    		if(operatie == 22){
    			id = Integer.parseInt(rand[1]) ;
    			cauta ca = new cauta() ;
    			int i = ca.search(figuri, id, nr_figuri) ;
    			quad.delete(quad, figuri[i]);
    		}
    		if(operatie == 33){
    			a1 = Double.parseDouble(rand[1]) ;
    			b1 = Double.parseDouble(rand[2]) ;
    			v = new ArrayList<Integer>() ;
    			quad.count(quad, a1 , b1 , v);
    			ArrayOp op = new ArrayOp() ;
    			op.sorteaza(v);
    			op.afiseaza(v , out) ;
    		}
    		if(operatie == 44){
    			tip = Integer.parseInt(rand[1]) ;
    			if(tip == 1){
    				a1 = Double.parseDouble(rand[2]);
    		    	b1 = Double.parseDouble(rand[3]);
    		    	a2 = Double.parseDouble(rand[4]);
    		    	b2 = Double.parseDouble(rand[5]);
    		    	Dreptunghi d = new Dreptunghi(a1 , b1 , a2 , b2) ;
    		    	d.fill(0); 
    		    	v = new ArrayList<Integer>() ;
    		    	quad.count_fig(quad, d, v);
    		    	ArrayOp op = new ArrayOp() ;
        			op.sorteaza(v);
        			op.afiseaza(v, out);
    			}
    			if(tip == 2){
    				a1 = Double.parseDouble(rand[2]);
    		    	b1 = Double.parseDouble(rand[3]);
    		    	a2 = Double.parseDouble(rand[4]);
    		    	b2 = Double.parseDouble(rand[5]);
    		    	a3 = Double.parseDouble(rand[6]) ;
    		    	b3 = Double.parseDouble(rand[7]) ;
    		    	Triunghi t = new Triunghi(a1 , b1 , a2 , b2 , a3 , b3) ;
    		    	t.fill(0); 
    		    	v = new ArrayList<Integer>() ;
    		    	quad.count_fig(quad, t, v);
    		    	ArrayOp op = new ArrayOp() ;
        			op.sorteaza(v);
        			op.afiseaza(v, out);
    			}
    			if(tip == 3){
    				raza = Double.parseDouble(rand[2]) ;
    				a1 = Double.parseDouble(rand[3]);
    		    	b1 = Double.parseDouble(rand[4]);
    		    	Cerc c = new Cerc(raza , a1 , b1) ;
    		    	c.fill(0); 
    		    	v = new ArrayList<Integer>() ;
    		    	quad.count_fig(quad, c, v);
    		    	ArrayOp op = new ArrayOp() ;
        			op.sorteaza(v);
        			op.afiseaza(v, out);
    			}
    			if(tip == 4){
    				a1 = Double.parseDouble(rand[2]);
    		    	b1 = Double.parseDouble(rand[3]);
    		    	a2 = Double.parseDouble(rand[4]);
    		    	b2 = Double.parseDouble(rand[5]);
    		    	a3 = Double.parseDouble(rand[6]) ;
    		    	b3 = Double.parseDouble(rand[7]) ;
    		    	a4 = Double.parseDouble(rand[8]) ;
    		    	b4 = Double.parseDouble(rand[9]) ;
    		    	Romb r = new Romb(a1 , b1 , a2 , b2 , a3 , b3 , a4 , b4) ;
    		    	r.fill(0) ;
    		    	v = new ArrayList<Integer>() ;
    		    	quad.count_fig(quad, r, v);
    		    	ArrayOp op = new ArrayOp() ;
        			op.sorteaza(v);
        			op.afiseaza(v, out);
    			}
    		}
    	}
    	
    	out.close() ;
    }
}
