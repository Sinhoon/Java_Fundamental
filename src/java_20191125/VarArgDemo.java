package java_20191125;

public class VarArgDemo {
	public static void main(String[] args) {
		VarArgDemo v = new VarArgDemo();
		v.m(1);
		v.m(1,2);
		v.m(1,2,3);
	}
	public void m(int... test){
		int length = test.length;
		if(length == 1){
			System.out.printf("인자 하나입니다 %d \n",test[0]);
		}else if(length == 2){
			System.out.printf("인자 둘입니다    %d %d \n",test[0],test[1]);
		}else if(length == 3){
			System.out.printf("인자 셋입니다    %d %d %d \n",test[0],test[1],test[2]);
		}
	}
}
