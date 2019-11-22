package java_20191121;

public class ArrayDemo {
	public static void main(String[] args){
		
	//1. 諛곗뿴 �꽑�뼵
	int[] a= new int[4];
	
	//2. 諛곗뿴 �븷�떦
	a[0] = 1;
	a[1] = 2;
	a[2] = 3;
	a[3] = 4;
	
	//length >> 諛곗뿴�쓽 湲몄씠, length() >> 臾몄옄�뿴�쓽 湲몄씠
	for (int i = 0; i<a.length ; i++){
		System.out.println(a[i]);
		}
	
	//諛곗뿴�쓽 �깮�꽦怨� �븷�떦�쓣 �룞�떆�뿉
	int[] b = {1,2,3,4}; // int b[] ={1,2,3,4} 
	
	//諛곗뿴�쓽 媛� 蹂�寃�(�옱�븷�떦)
	b[0] = 100;
	b[1] = 200;
	b[2] = 300;
	b[4] = 400;

	//enhanced for loop
	for(int temp : b){
		System.out.println(temp);
	}
	
	}
	
	}
