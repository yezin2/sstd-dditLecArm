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
	}
}
