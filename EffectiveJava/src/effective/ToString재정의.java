package effective;

import java.util.HashMap;
import java.util.Map;

public class ToString������ {
	
	String name;
	String phoneNumber;
	
	@Override
	public String toString() {
		return "["+name+"]"+":"+phoneNumber;
	}

	public static void main(String[] args) {
		ToString������ ts = new ToString������();
		ts.name="��ȣ��";
		ts.phoneNumber="010-1234-5678";
		
		Map<ToString������, Object> mapTs = new HashMap<ToString������, Object>();
		mapTs.put(ts, 1);
		try {
			System.out.println((String)mapTs.get(ts));
		}catch (Exception e) {
			System.out.println(ts.toString() +" : "+ e.getMessage());
		}
	}
}

