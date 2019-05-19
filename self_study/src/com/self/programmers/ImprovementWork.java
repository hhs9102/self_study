package com.self.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

import junit.framework.Assert;

//
public class ImprovementWork {
	public int[] solution(int[] progresses, int[] speeds){
		int[] anwser = new int[progresses.length];
		
		Queue<TechnicalWork> q = new LinkedList<>();
		for(int i=0; i<progresses.length; i++){
			q.add(new TechnicalWork(i, progresses[i], speeds[i]));
		}
		
		List<Integer> timeTaken = new ArrayList<>();
		int currTakedDay = 0;
		int completeCnt = 1;
		boolean findNext = false;
		while(!q.isEmpty()){
			if(!findNext){
				TechnicalWork t = q.poll();
				int remainProgress = 100-t.getProgress();
				int speed = t.getSpeed();
				int day = remainProgress%speed==0? remainProgress/speed : remainProgress/speed+1;
			
				currTakedDay = day;
				findNext = true;
				if(q.size()==0){
					timeTaken.add(completeCnt);
				}
			}else{
				TechnicalWork nextT = q.peek();
				int nextRemainProgress = 100-nextT.getProgress();
				int nextSpeed = nextT.getSpeed();
				int nextDay = nextRemainProgress%nextSpeed==0? nextRemainProgress/nextSpeed : nextRemainProgress/nextSpeed+1;
				if(currTakedDay > nextDay){
					q.poll();
					completeCnt++;
				}else{
					findNext = false;
					timeTaken.add(completeCnt);
					completeCnt=1;
				}
			}
		}
		
		anwser = timeTaken.stream().mapToInt(i->i).toArray();
		return anwser;
	}
	
	@Test
	@SuppressWarnings(value = {"deprecation"})
	public void test(){
		ImprovementWork i = new ImprovementWork();
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
		int arr[] = i.solution(progresses, speeds);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		Assert.assertEquals(new int[]{2,1}, arr);
				
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
