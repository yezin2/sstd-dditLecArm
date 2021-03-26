package kr.or.ddit.basic;
/**
 * 프로세스 : 실행중인 프로그램
 * 프로세스의 단위 = 스레드(경량 프로세스)
 * 
 * @author PC-17
 *
 */
public class T01_ThreadTest {
	public static void main(String[] args) {
		//싱글 쓰레드 프로그램
		for(int i=1; i<=200; i++) {
			System.out.print("*");
		}
		System.out.println();
		
		for(int i=1; i<=200; i++) {
			System.out.print("$");
		}
		for(int i=0; i<10; i++) {
			//경주마(thread)가 지나간 거리를 *로 찍음
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			//현재 경주마(thread)의 위치
			System.out.print("♘");
			//경주마(thread)가 달려야 할 남은 거리
			for(int j=9; j>i; j--) {
				System.out.print("-");
			}
			System.out.println();
		}
	}
}
