package com.self.codewars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class LongToIp {

	public static String longToIp(long ip) {
		String binaryString32 = lpad(Long.toBinaryString(ip), 32);
		List<String> ipAddress = Arrays.asList(binaryString32.substring(0, 8)
											,binaryString32.substring(8, 16)
											,binaryString32.substring(16, 24)
											,binaryString32.substring(24, 32));
		
		String t = ipAddress.stream()
							.map(s -> Integer.parseInt(s, 2))
							.map(s -> String.valueOf(s))
							.collect(Collectors.joining("."));
		return t;
	}
	
	public static String lpad(String input, int length) {
		if(input.length() >= length) {
			return input;
		}
		StringBuffer sb = new StringBuffer();
		while(sb.length() < length - input.length()) {
			sb.append("0");
		}
		sb.append(input);
		return sb.toString();
	}

	@Test
	public void test() {
		assertEquals("20.140.190.209", LongToIp.longToIp(344768209));
		assertEquals("128.114.17.104", LongToIp.longToIp(2154959208L));
		assertEquals("0.0.0.0", LongToIp.longToIp(0));
		assertEquals("128.32.10.1", LongToIp.longToIp(2149583361L));
	}
	
}


