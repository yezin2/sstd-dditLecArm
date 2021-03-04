package ddit_high;

import java.util.HashMap;
import java.util.Map;

public class T09_MapTest {
	public static void main(String[] args) {
		/*
		 * Map  >> key값과 value값을 한 쌍으로 관리하는 객체
		 * 		>> key값은 중복을 허용하지 않고 순서 없음(set특징)
		 * 		>> value값은 중복을 허용
		 */
		Map<String, String> map = new HashMap<String, String>();
		
		//자료추가 >> put(key값, value값);
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1111-1111");
		
		System.out.println("map >> " + map);
		
		//자료 수정 	>> 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장됨
		//			>> put(수정할 key값, 새로운 value값)
		map.put("addr", "서울");
		System.out.println("");
	}
}
