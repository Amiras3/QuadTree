
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.* ;

import javax.management.StringValueExp;

public class ArrayOp {
	public void sorteaza(ArrayList<Integer> v){
		Collections.sort(v) ;
	}
	public void afiseaza(ArrayList<Integer> v , BufferedWriter out) throws IOException{
	String afis;
		if(v.size() == 0){
			out.write("NIL") ;
			out.newLine();
			return ;
		}
		for(int i = 0 ; i < v.size(); i ++){
			int x = v.get(i) ;
			if(x != v.get(v.size() - 1)){
				out.write(x + " ");
				while(x == v.get(i)){
					i ++ ;
				}
				i -- ;
			}
			else{
				out.write(x);
				out.newLine() ;
				break ;
			}
		}
	}
}
