package kr.or.ddit.basic;

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
