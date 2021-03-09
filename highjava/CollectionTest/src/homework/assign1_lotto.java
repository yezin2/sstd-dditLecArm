package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import util.ScanUtil;

public class assign1_lotto {
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
		int count = 1;
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i=0; i<lottoC; i++) {
			raffle(count);
			count++;
		}
		
		
		
	}
	private static void raffle(int count) {

		Set lottonum = new HashSet();
		while(lottonum.size()<6){
			int num = (int)(Math.random() * 45 +1);
			lottonum.add(num);
		}
			
		Iterator it = lottonum.iterator();
		List listlonum = new ArrayList();
			
		while(it.hasNext()) { // 다음자료가 있는지 검사
			//next()메서드 >> 포인터를 다음 자료 위치로 이동하고, 이동한 위치의 자료를 반환한다.
			listlonum.add(it.hasNext());
			System.out.println(it.hasNext());
		}
		
		Collections.sort(listlonum, new Desc());
		System.out.println("로또번호" + count + " : " + listlonum);
	}
}

class Desc implements Comparator<Integer>{
	/*
	 * compare()메서드의 반환값을 결정하는 방법
	 *    >> 이 메서드가 양수를 반환하면 두 값의 순서가 바뀐다.(기본(default) : 오름차순)
	 * 
	 * - 오름차순 정렬일 경우
	 * 	  >> 앞의 값이 크면 양수, 같으면 0, 앞의 값의 작으면 음수를 반환 하도록 한다.
	 * 
	 * -String 객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데
	 * 	    이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어있다.
	 *     (Wrapper 클래스와 Date, File클래스에도 구현되어 있다.)
	 */
	/*public int compare(int num1, int num2) {//얘네 둘이 비교함
		return num1.compareTo(num2) * 1;
	}*/

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}