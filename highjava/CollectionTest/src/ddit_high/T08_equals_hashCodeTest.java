package ddit_high;

import java.util.HashSet;
import java.util.Set;

public class T08_equals_hashCodeTest {
	/*
	 * 해시함수(hash function)는 임의의 데이터를 고전된 길이의 데이터로 매핑하는 함수이다.
	 * 해시함수에 의해 얻어지는 값은 해시 값, 해시코드, 해시 체크섬 또는 간단하게 해시라고 한다.
	 * (암호학적 해시함수 및 비암호학적 해시함수)
	 * 
	 * HashSet, HashMap, HashTable과 같은 객체들을 사용할 경우
	 * 객체가 서로 같은 지를 비교하기 위해 equals()메서드와 hashCode()메서드를 호출한다.
	 * 그래서 객체가 서로 같은지 여부를 결정하려면 두 메서드를 재정의 해야한다.
	 * HashSet, HashMap, HashTable에서는 객체가 같은지 여부는 데이터를 추가할 때마다 검사함
	 * 
	 * -equals()메서드는 두 객체의 내용(값)이 같은지 비교하는 메서드 이고,
	 * -hashCode()메서드는 두객체가 같은 객체인지 비교하는 메서드 이다.
	 * 
	 * -equals()메서드와 hashCode()메서드에 관한 규칙
	 * 1. 두 객체가 같으면 반드시 같은 hashCode()를 가져야 함
	 * 2. 두 객체가 같으면 equals()메서드를 호출했을때 true를 반환해야함
	 *       즉, 객체 a,b가 같다면 a.equals(b)와 b.equals(a) 둘다 true여야함
	 * 3. 두 객체의 hashCode()가 같다고 해서 두 객체가 반드시 같은 객체는 아니다
	 *       하지만, 두 객체가 같으면 반드시 hashCode()가 같아야함
	 * 4. equals()메서드를 override하면 반드시 hashCode()메서드도 override해야함
	 * 5. hashCode()는 기본적으로 heap에 있는 각 객체에 대한 메모리 주소 매핑 정보를 기반으로 한 정수값을 반환 한다.
	 *       그러므로 클래스에서 hashCode()메서드를 override하지 않으면 절대로 두 객체가 같은 것으로 간주될 수 없다.
	 * 
	 * 
	 * - hashCode()메서드에서 사용하는 '해싱알고리즘'에서 서로 다른 객체에 대하여 같은 
	 * 		hashCode값을 만들어 낼 수 있다. 그래서 객체가 같지 않더라고 hashCode가 같을 수 있다.
	 */
	
	public static void main(String[] args) {
		Person p1 = new Person(1,"홍길동");
		Person p2 = new Person(1,"홍길동");
		Person p3 = new Person(1,"이순신");
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 == p2));
		
		Set<Person> set = new HashSet<Person>();
		
		set.add(p1);
		set.add(p2);
		
		System.out.println("p1, p2 등록 후 데이터");
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		System.out.println("add(p3) 성공여부 : " + set.add(p3));
		
		System.out.println("add(p3) 후 데이터" );
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		System.out.println("remove(p2) 성공여부 : " + set.remove(p2));
		
		System.out.println("remove(p2) 후 데이터");
		for(Person p : set) {
			System.out.println(p.getId() + " : " + p.getName());
		}
	}
}

class Person {
	private int id;
	private String name;
	
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}