package effective;


public class UserNotOverride {
	private final String name;
	private final int age;
	
	public static class Builder{
		private final String name;		
		private int age;
		
		public Builder(String name) {
			this.name = name;
		}
		
		public Builder age(int val) {
			age = val;
			return this;
		}
		
		public UserNotOverride build() {
			return new UserNotOverride(this);
		}
	}
	
	private UserNotOverride(Builder builder) {
		name = builder.name;
		age = builder.age;
	}
	
}
