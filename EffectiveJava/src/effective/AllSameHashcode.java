package effective;

public class AllSameHashcode {
	public String str;
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof String)) return false;
		String t = (String)obj;
		return obj == t;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}

}
