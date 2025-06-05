package pattern.prototype;

public class User implements Cloneable{
	private String name;
	private int age;
	private String email;
	
	private User(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.email = builder.email;
	}
	
	public User clone(User originalUser) throws CloneNotSupportedException {
		return (User)super.clone();
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + "]";
	}



	public static class Builder {
		private String name;
		private int age;
		private String email;
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
}
