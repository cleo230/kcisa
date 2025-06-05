package pattern.build;

public class BuilderPattern {
	public static void main(String args[]) {
		User user = new User.Builder()
				.setName("Ami")
				.setAge(10)
				.setEmail("test@test.com")
				.build();
		
		System.out.println (user);
	}
}
