package com.self.programmers;

import junit.framework.Assert;

import java.util.*;

public class Printer {

	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Document> q = new LinkedList<>();
		
		Map<Integer, Document> dMap = new HashMap<Integer, Document>();
		for(int i=0; i<priorities.length; i++) {
			Document d = new Document(i, priorities[i]);
			q.add(d);
			dMap.put(i, d);
		}
		
		List<Document> printOrder = new ArrayList<>();
		while(!q.isEmpty()) {
			Document curDoc = q.peek();
			Iterator<Document> iter = q.iterator();
//			int curPriority;
			boolean isExistGreat = false;
			while(iter.hasNext()) {
				Document nextDoc = iter.next();
				if(curDoc.getIndex()!= nextDoc.getIndex() && curDoc.getPriority() < nextDoc.getPriority()) {
					q.add(q.poll());
					isExistGreat = true;
					break;
				}
			}
			
			if(!isExistGreat) {
				printOrder.add(q.poll());
			}
		}

		Document pickedDocument = dMap.get(location);
		for(int i=0; i<printOrder.size(); i++) {
			Document d = printOrder.get(i);
			if(d.getIndex()==pickedDocument.getIndex()) {
				return i+1;	//0번째 +1
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Printer p = new Printer();
		Assert.assertEquals(1, p.solution(new int[] {2,1,3,2}, 2));
		Assert.assertEquals(5, p.solution(new int[] {1,1,9,1,1,1}, 0));

	}
}

class Document{
	private int index;
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	private int priority;
	
	public Document(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+index+","+priority+"]";
	}
}