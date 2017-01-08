

public class cauta {
	public int search(Figura[] f , int id , int nr_figuri){
		for(int i = 0 ; i < nr_figuri ; i ++){
			if(f[i].id == id){
				return i ;
			}
		}
		return -1 ;
	}
}
