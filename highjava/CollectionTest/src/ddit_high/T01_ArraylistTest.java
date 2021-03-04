package ddit_high;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class T01_ArraylistTest {
	public static void main(String[] args) {
		 // ArrayList는 기본적인 사용법이 Vector와 같다
		 // DEFAULT_CAPACITY = 10
		// 특징1. 순서 존재
		// 특징2. 중복 가능
		
		List list1 = new Vector();
		
		//add()메서드를 사용해서 데이터를 추가
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		//size() >> 데이터의 개수
		System.out.println("size >> " + list1.size());
		System.out.println("list1 >> " + list1);
		
		//get으로 데이터 꺼내오기
		System.out.println("1번째자료  >> " + list1.get(1));
		
		//데이터 끼워넣기도 같다
		list1.add(0, "zzz");
		System.out.println("list1 >> " + list1);
		
		//데이터 변경하기 (set메서드)
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp >> " + temp);
		System.out.println("list1 >> " + list1);
		
		//삭제
		list1.remove(0);
		System.out.println("삭제 후 >> " + list1);
		
		list1.remove("bbb");
		System.out.println("bbb 삭제 후 >> " + list1);
		System.out.println("==========================");
		
		//제너릭을 지정하여 선언 가능
		List<String> list2 = new ArrayList<String>();
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
		
		for(int i=0; i<list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}
		System.out.println("-------------------------------");
		
		//list2.remove(4);
		//contains(비교객체); >> 리스트에 '비교객체'가 있으면 true
		//				   >>없으면 false 리턴
		System.out.println(list2.contains("DDD")); //true
		System.out.println(list2.contains("EEE")); //false
		System.out.println("-------------------------------");
		
		//toArray() >> 리스트 안의 데이터 들을 배열로 변환하여 반환
		//			>> 기본적으로 object형 배열로 변환
		Object[] strArr = list2.toArray();
		System.out.println("배열의 갯수 : " + strArr.length);
		
		//리스트의 제너릭 타입에 맞는 자료형의 배열로 변환하는 방법
		//제너릭타입의 0개짜리 배열을 생성해서 매개변수로 넣어줌
		//  >>배열을 크기가 리스트 그기보다 작으면 리스트의 크기에 맞는 배열을 넣어준다
		String[] strArr2 = list2.toArray(new String[0]);
		System.out.println("strArr2의 갯수 : " + strArr2.length);
		
	}
}
