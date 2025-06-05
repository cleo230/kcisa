package pattern.prototype;

// 복사해서 instance 생성
public class PrototypePattern {
	public static void main(String args[]) throws CloneNotSupportedException {
		User user = new User.Builder()
				.setName("Kate")
				.setAge(20)
				.setEmail("ttt@na.com")
				.build();
		System.out.println (user);
		
		User user2 = user.clone(user);
		System.out.println ( user2);
		
		System.out.println(user == user2);      // false (다른 객체)
		System.out.println(user.equals(user2)); // false (equals 오버라이딩 안 했음)

		
	}
}
