package kr.or.ddit.basic;
/**
 * 스레드의 수행시간 체크하기
 * @author PC-17
 *
 */
public class T03_ThreadTest {
	public static void main(String[] args) {
		Thread th = new Thread();
		
		//UTC(협정세계 표준시)를 사용하여 1970년 1월 1일 0시 0분 0초를 기준으로
		//경과한 시간을 밀리세컨드(1/1000초)단위로 나타낸다. >> 유닉스 타임스탬프
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join();//현재 실행중인 스레드에서 작업중인 스레드(지금은 th스레드)가 종료될 때 까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : " + (endTime - startTime));
	}
}

class MyRunner implements Runnable {

	//1~10억까지의 합계를 구하는 스레드
	@Override
	public void run() {
		long sum = 0;
		for(long i=0; i<1000000000; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}
