package kr.or.ddit.basic;

public class T18_WaitNotifyTest {
/*
	wait()메서드 >> 동기화 영역에서 락을 풀고 wait-set영역(공유 객체별 존재)으로 이동시킴
	notify()또는 notifyAll()메서드 >> wait-set영역에 있는 스레드를 깨워서 실행될 수 있도록 함
			(notify()는 하나, notifyAll()은 모두 깨운다.)
			
	>>> wait()과 notify(), notifyAll()메서드는 동기화 영역에서만 실행할 수 있고,
			Object클래스에서 제공하는 메서드이다.
 */
	public static void main(String[] args) {
		
	}
}

//공유객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA()메서드 작업 중...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void methodB() {
		System.out.println("methodB()메서드 작업 중...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

//workObj의 methodA()메서드만 호출하는 스레드
class ThreadA extends Thread {
	private WorkObject workObj;

	private ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<=10; i++) {
			workObj.methodA();
		}
		System.out.println("ThreadA 종료");
	}
}

//workObj의 methodB() 메서드만 호출하는 스레드
class ThreadB extends Thread {
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObject) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i <=10; i++) {
			workObj.methodB();
		}
		System.out.println("ThreadB 종료");
	}
}