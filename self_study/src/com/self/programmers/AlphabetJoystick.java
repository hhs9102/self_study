package com.self.programmers;

import org.junit.Test;

import junit.framework.Assert;

//25
public class AlphabetJoystick {
	public int solution(String name){
		int updownCnt = 0;
		int moveCnt = 0;
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<name.length(); i++){
			sb.append("A");
		}
		String aStr = sb.toString();
		int index=0;
		char[] arr = name.toCharArray();
		int cnt=0;
		while(true){
			char c = arr[index];
			if(c != 65){
				if((int) c == 65){
					continue;
				}else if((int)c < 78){
					updownCnt += c-65;
				}else{
					updownCnt += 91-c;
				}
				arr[index] = 65;
			}
			if(aStr.equals(new String(arr))){
				break; 
			}
			
			int leftIndex = index == 0 ? arr.length-1 : index-1;
			int rightIndex = index == arr.length-1 ? 0 : index+1;
			
			if((int)arr[rightIndex] == 65){
				index = leftIndex;
			}else{
				index = rightIndex;
			}
			moveCnt++;
			cnt++;
			if(cnt==name.length()){
				break;
			}
		}
		return (updownCnt + moveCnt);
	}
	
	@Test
	public void tset(){
		AlphabetJoystick aj = new AlphabetJoystick();
		Assert.assertEquals(23, aj.solution("JAN"));
		Assert.assertEquals(56, aj.solution("JEROEN"));
	}

}
