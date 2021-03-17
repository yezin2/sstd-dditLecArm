package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import util.ScanUtil;

public class Assign1_Lotto {
	public static void main(String[] args) {
		boolean awhile = true;
		while(awhile) {
			System.out.println("===============================");
			System.out.println("Lotto 프로그램");
			System.out.println("-------------------------------");
			System.out.println("1. lotto구입 \t 2. 프로그램 종료");
			System.out.println("===============================");
			
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				buy();
				break;
			case 2:
				System.out.println("THANK YOU!");
				System.out.println("TERMINATE PROGRAM");
				awhile = false;
				break;
			default:
				System.out.println("**ERROR : RE-ENTER**");
				break;
			}
		}
	}

	private static void buy() {
		System.out.println("lotto 구입 시작");
		System.out.println("==1000원에 로또번로 하나입니다==");
		System.out.print("금액 입력 : ");
		int inmoney = ScanUtil.nextInt();
		
		int charge = inmoney % 1000;
		int lottoC = inmoney / 1000;
		System.out.println("lottoC : " + lottoC);
		
		Set<Integer> lottonum = new HashSet<>();
		
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i=0; i<lottoC; i++) {
			while(lottonum.size()<6){
				int num = (int)(Math.random() * 45 +1);
				lottonum.add(num);
			}
			List lottoCount = new ArrayList(lottonum); 
			Collections.sort(lottoCount);
			System.out.println(i+1 + "번째 로또 번호 : " + lottoCount);
			
			lottonum.clear();
		}
		System.out.println("거스름돈은 " + charge + "원 입니다.");
		
		
		
	}
}