package effective;

import java.util.Objects;

public class UserOverride {
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
		
		public UserOverride build() {
			return new UserOverride(this);
		}
	}
	
	private UserOverride(Builder builder) {
		name = builder.name;
		age = builder.age;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) return true;
		if(!(o instanceof UserOverride)) {
			return false;
		}
		
		UserOverride UserOverride = (UserOverride) o;
		return age == UserOverride.age
				&& Objects.equals(name, UserOverride.name);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}
}
