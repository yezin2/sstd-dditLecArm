package kr.or.ddit.basic;

public class T15_SyncAccountTest {
	public static void main(String[] args) {
		SyncAccount sAcc = new SyncAccount();
		sAcc.setBalance(10000); // 입금처리
		
		BankThread bth1 = new BankThread(sAcc);
		BankThread bth2 = new BankThread(sAcc);
		
		bth1.start();
		bth2.start();
	}
}

//은행의 입출금을 관리하는 클래스 정의 (공통 객체)
class SyncAccount {
	private int balance; // 잔액이 저장될 변수

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	 
	public void deposit(int money) {
		balance += money;
	}
	
	//동기화 블럭
	//출금을 처리하는 메서드 (출금 성공 : true, 출금 실패 : false 반환)
	//동기화 영역에서 호출하는 메서드도 동기화 처리를 해 주어야함.
	synchronized public boolean withdraw(int money) { 
		if(balance >= money) {//잔액이 충분할 경우...
			for(int i=0; i<=100000000; i++) {}//시간때우기
			balance -= money;
			System.out.println("메서드 안에서 balance = " + getBalance());
			
			return true;
		} else {
			return false;
		}
	}
}

//은행업무를 처리하는 스레드
class BankThread extends Thread {
	private SyncAccount sAcc;
	
	public BankThread(SyncAccount sAcc) {
		this.sAcc = sAcc;
	}
	@Override
	public void run() {
		boolean result = sAcc.withdraw(6000);//6000원 인출
		System.out.println("스레드 안에서 result = " + result + ", balance = " 
							+ sAcc.getBalance());
		
	}
}
