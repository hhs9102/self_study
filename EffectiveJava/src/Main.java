import java.util.HashMap;
import java.util.Map;

import effective.AllSameHashcode;
import effective.UserNotOverride;
import effective.UserOverride;
import effective.UserOverrideOnlyEquals;

public class Main {

	public static void main(String[] args) {
		/*
		//equals, hashCode 재정의
		UserOverride userOverride1 = new UserOverride.Builder("HHS").age(29).build();
		UserOverride userOverride2 =  new UserOverride.Builder("HHS").age(29).build();
		
		//equals, hashCode 재정의 하지 않음
		UserNotOverride userNotOverride1 = new UserNotOverride.Builder("HHS").age(29).build();
		UserNotOverride UuerNotOverride2 =  new UserNotOverride.Builder("HHS").age(29).build();
		
		//equals만 재정의
		UserOverrideOnlyEquals userOverrideOnlyEquals1 
								= new UserOverrideOnlyEquals.Builder("HHS").age(29).build();
		UserOverrideOnlyEquals userOverrideOnlyEquals2 
								=  new UserOverrideOnlyEquals.Builder("HHS").age(29).build();
		
		
		
		System.out.println(userOverride1.equals(userOverride2) + "\t(equals userOverride)");
		System.out.println(userNotOverride1.equals(UuerNotOverride2) + "\t(equals userNotOverride)");
		System.out.println(userOverrideOnlyEquals1.equals(userOverrideOnlyEquals2)+"\t(equals userOverrideOnlyEquals)");
		
		System.out.println(userOverride1.hashCode() + "\t\t(UserOverride1 hashCode)");
		System.out.println(userOverride2.hashCode() + "\t\t(UserOverride2 hashCode)");
		System.out.println(userNotOverride1.hashCode() + "\t(UserNotOverride1 hashCode)");
		System.out.println(UuerNotOverride2.hashCode() + "\t(UserNotOverride2 hashCode)");
		System.out.println(userOverrideOnlyEquals1.hashCode() 
												+ "\tUserNotOverrideOnlyEquals1 hashCode)");
		System.out.println(userOverrideOnlyEquals2.hashCode() 
												+ "\tUserNotOverrideOnlyEquals2 hashCode)");
		
		System.out.println();
		System.out.println();
		
		Map<UserOverride, String> test = new HashMap<UserOverride, String>();
		test.put(userOverride1, "userOverride1");
		System.out.println(test.get(userOverride2));
		
		Map<UserNotOverride, String> test2 = new HashMap<UserNotOverride, String>();
		test2.put(userNotOverride1, "userNotOverride1");
		System.out.println(test.get(UuerNotOverride2));
		*/
		
		AllSameHashcode allSameHashcode = new AllSameHashcode();
		allSameHashcode.str = "allSameHashcode";
		AllSameHashcode allSameHashcode2 = new AllSameHashcode();
		allSameHashcode2.str = "allSameHashcode";
		Map<AllSameHashcode, String> t = new HashMap<AllSameHashcode, String>();
		t.put(allSameHashcode, allSameHashcode.str);
		
		System.out.println(t.get(allSameHashcode2));
		
		

	}

}
