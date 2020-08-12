package com.self.programmers;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

//100
public class ImprovementWork {
	public int[] solution(int[] progresses, int[] speeds){
		Queue<TechnicalWork> q = new LinkedList<>();
		for(int i=0; i<progresses.length; i++){
			q.add(new TechnicalWork(i, progresses[i], speeds[i]));
		}
		
		List<Integer> timeTaken = new ArrayList<>();
		int currTakedDay = 0;
		int completeCnt = 1;
		boolean findNext = false;
		while(!q.isEmpty()){
			if(!findNext){	//처음, timeTaken에 Add 후에
				TechnicalWork t = q.poll();
				int remainProgress = 100-t.getProgress();
				int speed = t.getSpeed();
				int day = remainProgress%speed==0? remainProgress/speed : remainProgress/speed+1;
			
				currTakedDay = day;
				findNext = true;
			}else{	//다음 workDay가 현재 workDay보다 작은지 확인(함께 반영하려고)
				TechnicalWork nextT = q.peek();
				int nextRemainProgress = 100-nextT.getProgress();
				int nextSpeed = nextT.getSpeed();
				int nextDay = nextRemainProgress%nextSpeed==0? nextRemainProgress/nextSpeed : nextRemainProgress/nextSpeed+1;
				if(currTakedDay >= nextDay){
					q.poll(); 	//다음 작업시간이 더 작기에 함께 커밋할 수 있음
					completeCnt++;
				}else{	//다음작업시간이 더걸리므로 add후 다시 찾기시작
					findNext = false;
					timeTaken.add(completeCnt);
					completeCnt=1;
				}
			}
			if(q.size()==0){
				timeTaken.add(completeCnt);
			}
		}
		
		int[] anwser = new int[timeTaken.size()];
		anwser = timeTaken.stream().mapToInt(i->i).toArray();
		return anwser;
	}
	
	@Test
	public void test(){
		ImprovementWork i = new ImprovementWork();
//		assertTrue(Arrays.equals(new int[]{2,1},i.solution(new int[]{93,30,55}, new int[] {1,30,5})));
//		assertTrue(Arrays.equals(new int[]{3,1},i.solution(new int[]{50,30,40,50}, new int[] {30,50,30,20})));
		assertTrue(Arrays.equals(new int[]{1,3},i.solution(new int[]{50,30,40,50}, new int[] {3,2,4,5})));
	}
	
	public static void main(String[] args) {
		ImprovementWork i = new ImprovementWork();
		assertTrue(Arrays.equals(new int[]{2,1},i.solution(new int[]{93,30,55}, new int[] {1,30,5})));
		
	}
}

class TechnicalWork{
	private int priority;
	private int progress;
	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	private int speed;
	
	public TechnicalWork(int priority, int progress, int speed){
		this.priority = priority;
		this.progress = progress;
		this.speed = speed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+priority+","+progress+","+speed+"]";
	}
}
