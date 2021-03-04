package ddit_high;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * comparable 및 Comparator 예제
 */
public class T04_ListSortTest {

	public static void main(String[] args) {
		List<Member> memList = new ArrayList<Member>();
		memList.add(new Member(1, "류준열", "010-1111-1111"));
		memList.add(new Member(9, "김태평", "010-2222-2222"));
		memList.add(new Member(5, "김선호", "010-3333-3333"));
		memList.add(new Member(4, "주지훈", "010-4444-4444"));
		memList.add(new Member(6, "김원중", "010-5555-5555"));
		
		System.out.println("정렬 전 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("=========================");
		
		Collections.sort(memList);
		
		System.out.println("이름의 오름차순으로 정렬 후");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("=========================");
		
		//외부 정렬 기준을 이용한 정렬하기
		Collections.sort(memList, new SortNumDesc());
		System.out.println("번호의 내림차순으로 정렬 후 : ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("=========================");
	}
}
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		/*if(mem1.getNum() > mem2.getNum()) {
			return -1;
		}else if(mem1.getNum() == mem2.getNum()) {
			return 0;
		}else {
			return 1;
		}*/
		//wrapper클래스에서 제공되는 메서드를 이용하는 방법1
		//내림차순인 경우엔 *-1해줌
		return new Integer(mem1.getNum())
					.compareTo(mem2.getNum())*-1;
	}
	
}

class Member implements Comparable<Member>{
	
	private int num;		//번호
	private String name;	//이름
	private String tel;		//전화번호
	//위의 객체들을 VO객체라고 부름 (Value Object)
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}
	
	/*
	 * 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	 */
	
	@Override
	public int compareTo(Member mem) {//member o와 비교한다
		// TODO Auto-generated method stub
		return this.getName().compareTo(mem.getName());
	}
	
	

	
	
}