

import java.util.* ;
public class Node {
	public double c1, d1, c2, d2;
	public Node unu, doi, trei, patru;
	public Figura[] figuri;
	public int size_figuri;

	public Node() {

	}

	public Node(double c1, double d1, double c2, double d2) {
		this.c1 = c1;
		this.c2 = c2;
		this.d1 = d1;
		this.d2 = d2;
		size_figuri = -1;
		figuri = new Figura[100];
	}

	public boolean check_point(Node e, double a, double b) {
		return e.c1 <= a && e.c2 >= a && e.d1 <= b && e.d2 >= b;
	}

	public boolean check(Node e, Figura f) {
		return Math.max(f.x1, e.c1) <= Math.min(f.x2, e.c2) && Math.max(f.y1, e.d1) <= Math.min(f.y2, e.d2);
	}

	public boolean check_frunza(Node e) {
		return e.unu == null;
	}

	public boolean inter_min_fig(Figura f, Node e) {
		for (int i = 0; i <= e.size_figuri; i++) {
			if (f.intersectie(e.figuri[i]) == true) {
				return true;
			}
		}
		return false;
	}
	public void sterge_obiecte(Node e){
		for(int i = 0 ; i <= e.size_figuri ; i++){
			e.figuri[i] = null ;
		}
		e.size_figuri = -1 ;
	}
	public void insert(Node e, Figura f) {
		if(e == null){
			return ;
		}
		if (check(e, f) == false) {
			return;
		}
		if (check_frunza(e) == true) {
			if (e.size_figuri == -1) {
				e.figuri[0] = f;
				e.size_figuri++;
				return ;
			} else {
				if (inter_min_fig(f, e) == true) {
					e.size_figuri++;
					e.figuri[e.size_figuri] = f;
					return;
				}
				e.unu = new Node(e.c1, e.d1, (e.c1 + e.c2) / 2, (e.d1 + e.d2) / 2);
				e.doi = new Node((e.c1 + e.c2) / 2, e.d1, e.c2, (e.d1 + e.d2) / 2);
				e.trei = new Node((e.c1 + e.c2) / 2, (e.d1 + e.d2) / 2, e.c2, e.d2);
				e.patru = new Node(e.c1, (e.d1 + e.d2) / 2, (e.c1 + e.c2) / 2, e.d2);
				for (int i = 0; i <= e.size_figuri; i++) {
					if (check(e.unu, e.figuri[i]) == true) {
						e.unu.size_figuri++;
						e.unu.figuri[e.unu.size_figuri] = e.figuri[i];
					}
					if (check(e.doi, e.figuri[i]) == true) {
						e.doi.size_figuri++;
						e.doi.figuri[e.doi.size_figuri] = e.figuri[i];
					}
					if (check(e.trei, e.figuri[i]) == true) {
						e.trei.size_figuri++;
						e.trei.figuri[e.trei.size_figuri] = e.figuri[i];
					}
					if (check(e.patru, e.figuri[i]) == true) {
						e.patru.size_figuri++;
						e.patru.figuri[e.patru.size_figuri] = e.figuri[i];
					}
				}
				sterge_obiecte(e) ;
				insert(e.unu, f);
				insert(e.doi, f);
				insert(e.trei, f);
				insert(e.patru, f);
			}
		} else {
			insert(e.unu, f);
			insert(e.doi, f);
			insert(e.trei, f);
			insert(e.patru, f);
		}
	}

	public void delete(Node e, Figura f) {
		if (e == null) {
			return;
		}
		if (check(e, f) == false) {
			return;
		}
		if (check_frunza(e) == true) {
			for (int i = 0; i <= e.size_figuri; i++) {
				if (f.id == e.figuri[i].id) {
					e.figuri[i] = e.figuri[e.size_figuri];
					e.figuri[e.size_figuri] = null;
					e.size_figuri--;
					break;
				}
			}
		} else {
			delete(e.unu, f);
			delete(e.doi, f);
			delete(e.trei, f);
			delete(e.patru, f);
		}
	}

	public void count(Node e, double a, double b , ArrayList<Integer> v) {
		if(e == null){
			return ;
		}
		if (check_frunza(e) == true) {
			for (int i = 0; i <= e.size_figuri; i++) {
				if (e.figuri[i] instanceof Cerc) {
					if(((Cerc)e.figuri[i]).point(a , b) == true){
						v.add(e.figuri[i].id) ;
					}
				}
				if (e.figuri[i] instanceof Dreptunghi) {
					if(((Dreptunghi)e.figuri[i]).point(a , b) == true){
						v.add(e.figuri[i].id);
					}
				}
				if (e.figuri[i] instanceof Romb) {
					if(((Romb)e.figuri[i]).point(a , b) == true){
						v.add(e.figuri[i].id) ;
					}
				}
				if (e.figuri[i] instanceof Triunghi) {
					if(((Triunghi)e.figuri[i]).point(a , b) == true){
						v.add(e.figuri[i].id);
					}
				}
			}
		} else {
			if (check_point(e.unu, a, b)){
				count(e.unu, a, b , v);
			}
			if (check_point(e.doi, a, b)) {
				count(e.doi, a, b , v);
			}
			if (check_point(e.trei, a, b)) {
				count(e.trei, a, b , v);
			}
			if (check_point(e.patru, a, b)) {
				count(e.patru, a, b , v);
			}
		}
	}

	public void count_fig(Node e, Figura f , ArrayList<Integer> v) {
		if (e == null) {
			return ;
		}
		if (check(e, f) == false) {
			return ;
		}
		if (check_frunza(e)) {
			for (int i = 0; i <= e.size_figuri; i++) {
				if (f.intersectie(e.figuri[i])) {
					v.add(e.figuri[i].id) ;
				}
			}
		}
		count_fig(e.unu, f , v) ;
		count_fig(e.doi, f , v) ; 
		count_fig(e.trei, f , v) ; 
		count_fig(e.patru, f , v);
	}
}