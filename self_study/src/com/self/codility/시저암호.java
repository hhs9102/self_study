package com.self.codility;

import org.junit.Test;

import junit.framework.Assert;

public class 시저암호 {
	public String solution(String s, int n) {
		StringBuffer sb = new StringBuffer();
		char a = 0;
		for (char c : s.toCharArray()) {
			int start = isLower(c) ? 96 : 65;
			int end = isLower(c) ? 121 : 90;
			
			if(c == 32) { 	//space
				a = c;
			}else if (c+n > end) {
				a = (char) ((c + n) - end + start-1);
			} else {
				a = (char) (c + n);
			}

			System.out.println(a);
			sb.append(a);
		}
		return sb.toString();
	}
	
	private boolean isLower(char c) {
		if(c >= 97 && c <= 122) {
			return true;
		}else {
			return false;
		}
	}

	@Test
	public void test() {
		Assert.assertEquals("BC", solution("AB", 1));
		Assert.assertEquals("a", solution("z", 1));
		Assert.assertEquals("e F d", solution("a B z", 4));
	}

}
