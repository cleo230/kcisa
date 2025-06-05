package pattern.singleton;

public class Singleton {
	
	//외부접근 차단 
	//Singleton.myInstance(X) => Singleton.getInstance(O) 
	//프로그램 전체에서 하나의 instance만 공유 : static 
	//유일한 인스턴스 미리 만들어두기 
	private static Singleton myInstance = new Singleton();
	//외부에서 new 로 생성못하도록 private 
	private Singleton() {		
	}
	
	// 외부에서는 이메소드만 접근가능
	public static Singleton getInstance() {
		return myInstance;
	}
	
}
