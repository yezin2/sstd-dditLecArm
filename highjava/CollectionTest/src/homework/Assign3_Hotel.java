package homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Assign3_Hotel {
	public static Scanner scan= new Scanner(System.in);
	private static List<HashMap<String, hotel>> hotelI = new ArrayList();
		
	public static void main(String[] args) {
		System.out.println("***********************************");
		System.out.println("\t== HOTEL OPEN==");
		System.out.println("***********************************");
		boolean hotel = true;
		while (hotel) {
			System.out.println("***********************************");
			System.out.println("\t1. CHECK IN");
			System.out.println("\t2. CHECK OUT");
			System.out.println("\t3. HOTEL INFO");
			System.out.println("\t4. HOTEL CLOSE");
			System.out.println("***********************************");
			System.out.println("ENTER THE NUMBER >>");
			int input = scan.nextInt();
			switch (input) {
			case 1:
				chin();
				break;
			case 2:
				chout();
				break;
			case 3:
				hotin();
				break;
			case 4:
				System.out.println("THANK YOU!");
				System.out.println("TERMINATE PROGRAM");
				hotel = false;
				break;
			default:
				System.out.println("**ERROR : RE-ENTER**");
				break;
			}
		}
	}

	private static void hotin() {
		System.out.println("**************사용중인 방**************");
		System.out.println("\t방번호 \t투숙객 이름");
		System.out.println("************************************");
		for(int i=0; i<hotelI.size(); i++) {
			System.out.println("\t" + hotelI.get(i).get("roomN") 
							+ "\t" + hotelI.get(i).get("name") );
		}
		System.out.println("************************************");
		
	}

	private static void chout() {

		System.out.println("어느방 체크아웃?");
		
		String roomN = scan.next();
		
		for(int i=0; i<hotelI.size(); i++) {
			if(hotelI.get(i).get("roomN").equals(roomN)) {
				hotelI.remove(i);
				System.out.println("체크아웃 완료!");
			}else {
				System.out.println("아무도 체크인한적 없음 - 체크아웃 불가능");
			}
		}
	}

	private static void chin() {
		System.out.println("\t401 402 403 404");
		System.out.println("\t301 302 303 304");
		System.out.println("\t201 202 203 204");
		System.out.println("\t101 102 103 104");

		
		System.out.println("어느방 체크인? >>");
		String roomN = scan.next();
		System.out.println("투숙객 이름? >>");
		String name = scan.next();
		
		HashMap<String, Object> hi = new HashMap<>();
		hi.put("roomN", roomN);
		hi.put("name", name);
		hotelI.add(hi);
		
		System.out.println("체크인 완료!");
	}
}
class hotel {
	private int roomN;
	private String name;
	public int getRoomN() {
		return roomN;
	}
	public void setRoomN(int roomN) {
		this.roomN = roomN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public hotel(int roomN, String name) {
		super();
		this.roomN = roomN;
		this.name = name;
	}
	
	
}