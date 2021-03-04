package ddit_high;

import java.util.LinkedList;

public class T02_StackQueueTest {
	public static void main(String[] args) {
		/*
		 * Stack >> 후입선출(LIFO)의 자료구조
		 * Queue >> 선입선출(FIFO)의 자료구조
		 * 
		 * Stack과 Queue는 Linked List를 이용하여 사용가능
		 */
		
		LinkedList<String> stack = new LinkedList<>();
		
		//stack의 명령
		// 1) 자료입력 : push(저장할 값)
		// 2) 자료출력 : pop() >> 자료를 꺼내온 후 꺼내온 자료를 stack에서 삭제
		
		stack.push("류준열");
		stack.push("김선호");
		stack.push("주지훈");
		stack.push("송중기");
		System.out.println("현재 stack값들 : " + stack);
		
		stack.push("한효주");
		System.out.println("현재 stack값들 : " + stack);
		System.out.println("꺼내온 자료 : " + stack.pop());
		
		System.out.println("==============================");
		System.out.println();
		
		LinkedList<String> queue = new LinkedList<>();
		
		//Queue의 명령
		//1) 자료입력 : offer(저장할 값)
		//2) 자료출력 : poll() >> 자료를 꺼내온 후 꺼내온 자료는  Queue에서 삭제
		
		queue.offer("김선호");
		queue.offer("류준열");
		queue.offer("송중기");
		queue.offer("주지훈");
		
		System.out.println("현재 queue의 값 : " + queue);
		
		String temp =  queue.poll();
		System.out.println("꺼내온 자료 : " + temp);
		System.out.println("꺼내온 자료 : " + queue.poll());
		System.out.println("현재 queue의 값 : " + queue);
		
		if(queue.offer("한지민"))
			System.out.println("신규 등록 자료 : 한지민");
		System.out.println("");
	}
}
