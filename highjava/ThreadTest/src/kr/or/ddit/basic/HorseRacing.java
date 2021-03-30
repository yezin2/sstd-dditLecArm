package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class HorseRacing {
	//순위 저장을 위한 변수
	static int strRank = 1;
	
	public static void main(String[] args) {
		/*List<Horse> horses = new ArrayList<>();
			//경주마(thread)배열 생성
				horses.add(new Horse("1번마"));
				horses.add(new Horse("2번마"));
				horses.add(new Horse("3번마"));
				horses.add(new Horse("4번마"));
				horses.add(new Horse("5번마"));
				horses.add(new Horse("6번마"));
				horses.add(new Horse("7번마"));
				horses.add(new Horse("8번마"));
				horses.add(new Horse("9번마"));
				horses.add(new Horse("10번마"));*/
			Vector<Horse> horses = new Vector();
				//경주마(thread)배열 생성
				horses.add(new Horse("1번마"));
				horses.add(new Horse("2번마"));
				horses.add(new Horse("3번마"));
				horses.add(new Horse("4번마"));
				horses.add(new Horse("5번마"));
				horses.add(new Horse("6번마"));
				horses.add(new Horse("7번마"));
				horses.add(new Horse("8번마"));
				horses.add(new Horse("9번마"));
				horses.add(new Horse("10번마"));
		
		
		for(Horse hRace : horses) {
			hRace.start();
			
		}
		for(Horse hRace : horses) {//일시정지중에 방해받지 않기 위해서 interruptedexception 으로 하드코딩해줌
			try {
				hRace.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		Collections.sort(horses);
		
		System.out.println("경기 끝...");
		System.out.println("--------------------------");
		System.out.println("경기결과");
		
		for(Horse hRace : horses) {
			System.out.println(hRace.getRank() + "위 : " + hRace.getName1());
		}
	}
}

//말 클래스 (말 도착 순위 : Thread, 순위 순서로 배열 위치 변경 comparable)
class Horse extends Thread implements Comparable<Horse>{
	private String name;
	private int rank;
	
	//생성자
	public Horse(String name) {
		this.name = name;
		this.rank = rank;
	}
	
	//name값 꺼내오기
	public String getName1() {
		return name;
	}
	//name값 넣기
	public void setName1(String name) {
		this.name = name;
	}

	//rank값 꺼내오기
	public int getRank() {
		return rank;
	}
	//rank값 넣기
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public void run() {
		//거리는 10으로 잡음
		for(int i=0; i<50; i++) {
			System.out.println(name + " : ");//경주마 이름 출력
			//경주마(thread)가 지나간 거리를 *로 찍음
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			//현재 경주마(thread)의 위치
			System.out.print("♘>");
			//경주마(thread)가 달려야 할 남은 거리
			for(int j=49; j>i; j--) {
				System.out.print("-");
			}
			System.out.println();
			//경주마(thread)가 멈춰있는 시간을 랜덤으로 주어서 경주마(thread)의 속도를 난수로 정함
			try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==49) {
				System.out.println(">>>>>>>>>>>>>>" + name + "도착");
			}
		}
		//rank값(순위) 넣어주기
		setRank(HorseRacing.strRank);
		//rank값 하나씩 올려서 순위 만들어주기
		HorseRacing.strRank++;
	}
	/*
	 * compareTo메서드는 구현된 객체와 매개변수를 비교해서 
	 * 객체가 크면 양수반환, 같으면 0반환, 객체가 작으면 음수반환함
	 */
	@Override
	public int compareTo(Horse h) {
		if(this.getRank() > h.getRank()) {			//객체가 크면 양수반환
			return 1;
		} else if(this.getRank() == h.getRank()) {	//같으면 0반환
			return 0;
		} else {									//객체가 작으면 음수반환
			return -1;
		}
		
	}
}