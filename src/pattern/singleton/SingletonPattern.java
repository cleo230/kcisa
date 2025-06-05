package pattern.singleton;

public class SingletonPattern {
	public static void main(String args[]) {
		//기본 싱글턴
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println ( "s1=s2?" + (s1 == s2));
		
		//멀티스레드 상황에서 여러개 인스턴스 방지
		Singleton2 s21 = Singleton2.getInstance();
		Singleton2 s22 = Singleton2.getInstance();
		
		System.out.println ( "s21=s22?" + (s21 == s22));
	}
}
