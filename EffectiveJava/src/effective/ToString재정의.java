package effective;

import java.util.HashMap;
import java.util.Map;

public class ToString재정의 {
	
	String name;
	String phoneNumber;
	
	@Override
	public String toString() {
		return "["+name+"]"+":"+phoneNumber;
	}

	public static void main(String[] args) {
		ToString재정의 ts = new ToString재정의();
		ts.name="함호식";
		ts.phoneNumber="010-1234-5678";
		
		Map<ToString재정의, Object> mapTs = new HashMap<ToString재정의, Object>();
		mapTs.put(ts, 1);
		try {
			System.out.println((String)mapTs.get(ts));
		}catch (Exception e) {
			System.out.println(ts.toString() +" : "+ e.getMessage());
		}
	}
}

