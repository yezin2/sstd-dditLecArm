package ddit_high;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class T01 {
	public static void main(String[] args) {
		/*
		 *  ArrayList는 기본적인 사용법이 Vector와 같다.
		 *  DEFAULT_CAPACITY = 10
		 *  특징 : 순서존재, 중복가능
		 */
		
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
		
		//get() >> 데이터 꺼내오기
		System.out.println("1번째 자료 >> " + list1.get(1));
		
		//데이터 끼워넣기도 add()를 사용함
		list1.add(0,"zzz");
		System.out.println("list1 >> " + list1);
		
		//데이터 변경하기 >> set()메서드 사용
		String temp = (String) list1.set(0, "yyy");
		System.out.println("temp >> " + temp);
		System.out.println("list1 >> " + list1);
		
		//삭제 >> remove()메서드 사용
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
		System.out.println("=============================");
	}
}



























