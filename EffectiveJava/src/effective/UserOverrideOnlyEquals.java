package effective;

import java.util.Objects;

public class UserOverrideOnlyEquals {
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
		
		public UserOverrideOnlyEquals build() {
			return new UserOverrideOnlyEquals(this);
		}
	}
	
	private UserOverrideOnlyEquals(Builder builder) {
		name = builder.name;
		age = builder.age;
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) return true;
		if(!(o instanceof UserOverrideOnlyEquals)) {
			return false;
		}
		
		UserOverrideOnlyEquals UserOverrideOnlyEquals = (UserOverrideOnlyEquals) o;
		return age == UserOverrideOnlyEquals.age
				&& Objects.equals(name, UserOverrideOnlyEquals.name);
	}
	
}
