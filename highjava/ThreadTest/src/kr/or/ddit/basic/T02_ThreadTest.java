package kr.or.ddit.basic;

public class T02_ThreadTest {
	public static void main(String[] args) {
		// 멀티 스레드 프로그램 방식
		
		// 방법1 : Thread 클래스를 상속한 class의 인스턴스를 생성한 후
		//			이 인스턴스의 start()메서드를 호출한다.
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		// 방법2 : runnable 인터페이스를 수현한 class의 인스턴스를 생성한 후 
		//			이 인스턴스를 Thread객체의 인스턴스의 start()메서드를 호출한다.
		MyThread2 r1 = new MyThread2();
		Thread th2 = new Thread(r1);
		th2.start();
	}
}

class MyThread1 extends Thread{
	@Override
	public void run() {
		for(int i=0; i<=200; i++) {
			System.out.print("*");
			
			try {
				//Thread.sleep(시간) >> 주어진 시간동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용함
				// 즉, 1000은 1초를 의미
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<=200; i++) {
			System.out.print("$");
			
			try {
				//Thread.sleep(시간) >> 주어진 시간동안 작업을 잠시 멈춘다.
				//시간은 밀리세컨드 단위를 사용함
				// 즉, 1000은 1초를 의미
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}