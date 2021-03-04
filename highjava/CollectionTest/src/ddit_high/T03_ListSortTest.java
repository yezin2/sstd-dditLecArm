package ddit_high;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class T03_ListSortTest {
/*
 * 정력과 관련된 inteface에는 Comparable과 Comparator 이렇게 2가지가 있다
 * 보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable을 구현하고,
 * 정렬 기준을 별도로 구현하고 싶은 경우에는 Comparator를 구현하여 사용
 * 
 * 	- comparable은 compareTo()메서드 구현
 * 	- comparator에서는 compare()메서드를 구현
 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("류준열");
		list.add("김선호");
		list.add("주지훈");
		list.add("김원중");
		list.add("김태평");
		
		System.out.println("정렬 전 : " + list);
		
		//정렬은 Collection.sort() 메서드를 이용해 정렬한다.
		// 정렬은 기본적으로 '오름차순 정렬'을 수행한다.
		// 정렬방식을 변경하려면 정렬방식을 결정하는 객체를 만들어서
		// Collections.sort()메서드에 인수로 넘겨주면 된다.
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		

		Collections.shuffle(list);
		System.out.println("자료섞기 후 : " + list);
		
		// 정렬방식을 결정하는 객체를 이용하여 정렬하기
		Collections.sort(list, new Desc());
		
		System.out.println("정렬 후 : " + list );
	}
}

//정렬방식을 결정하는 class는 Comparator라는 인터페이스를 구현해야함
// 이 Comparator 인터페이스의 compare()라는 메서드를 재정의 하여 구현한다
class Desc implements Comparator<String>{
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
	@Override
	public int compare(String str1, String str2) {//얘네 둘이 비교함
		return str1.compareTo(str2) * 1;
	}
}
