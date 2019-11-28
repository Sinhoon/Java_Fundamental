package java_20191126;
public class StaticInitalizationDemo {
	// i18n internationalization 국제화
	// l10n localization 지역화
	static int age;
	final static String title;
	static{
		System.out.println("static block");
		title = "모기지론";
		age =20;
	}

	// 생서자는 객체 생성과 관련있다.
	private StaticInitalizationDemo(int age){
		this.age =age;
	}
	public static void main(String[] args) {
		StaticInitalizationDemo s = new StaticInitalizationDemo(10);
	}

}
