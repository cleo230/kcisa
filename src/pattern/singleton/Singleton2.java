package pattern.singleton;

public class Singleton2 {
	private static Singleton2 syInstance;
	private Singleton2() {}
	
	//synchronized 를 통해 멀티스레드 일 경우 여러개 인스턴스 생성 방지
	public static synchronized  Singleton2 getInstance() {
		if ( syInstance == null ) {
			syInstance = new Singleton2();
		}
		return syInstance;
	}
}
