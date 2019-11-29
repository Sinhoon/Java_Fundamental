package java_20191122.bb;

import java_20191122.aa.Notice;
import java_20191122.aa.NoticeParent;
import java_20191122.aa.NoticeChild;;

// 서로다른  패키지의 클래스르 사용하기위해서 반드시 import

public class NoticDemo2 extends Notice {
	public static void main(String[] args) {
		NoticDemo2 nc = new NoticDemo2();
		nc.number = 10;
		nc.tiltle = "title";
		//nc.hit = 30;
		nc.abc = 10;
		
/*		Notice ns = new Notice();
		ns.number = 10;
		ns.tiltle = "title";
		ns.hit = 30;
		ns.abc = 10;
		
		NoticeChild nv = new NoticeChild();
		nv.number = 10;
		nv.tiltle = "title";
		nv.hit = 30;
		nv.abc = 10;
		
		NoticeParent nt = new NoticeParent();
		nt.number = 10;
		nt.tiltle = "title";
		nt.hit = 30;
		nt.abc = 10;
		*/
		
		System.out.print(nc.a);
	}
}
