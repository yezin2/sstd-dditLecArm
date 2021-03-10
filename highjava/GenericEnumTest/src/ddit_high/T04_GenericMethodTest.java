package ddit_high;


class Util {
	/*
	 * 제너릭 메서드<T, R> R method(T t)
	 * 파라미터 타입과 리턴타입으로 타입 파라미터를 가지는 메서드
	 * 
	 * 선언방법 : 리턴타입 앞에 <> 기호를 추가하고 타입 문자를 기술 후 사용함.
	 * 
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		//boolean 리턴타입 앞에 제너릭을 선언한다.
		//유효범위 메서드 내에서만 제너릭 타입이 의미가 있다.
		//pair라는 객체를 2개 받는게 제너릭 타입임. 뭔진 모르겟지만 일단 받아서 boolean으로 줄게.
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		
		return keyCompare && valueCompare;
	}
}
class Pair<K,V>{
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	//키와 값을 모두 출력
	public <K, V> void displayAll(K key, V value) {
		//메서드 내에서 사용하는 순간 제너릭 메서드가 됨
		System.out.println(key + " : " + value.toString());
		//안붙여도 생략 가능함
	}
}

public class T04_GenericMethodTest{
	public static void main(String[] args) {
		
		Pair<Integer, String> p1 = new Pair<>(1, "홍길동");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "홍길동");
		
		//구체적 타입을 명시적으로 지정(생략가능)
		boolean result1 = Util.<Integer, String>compare(p1,p2);
		
		if(result1) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("001", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("002", "홍길동");
		
		boolean result2 = Util.compare(p3, p4);
		
		if(result2) {
			System.out.println("논리(의미)적으로 동일한 객체임");
		}else {
			System.out.println("논리(의미)적으로 동일한 객체 아님");
		}
		
		//제너릭 메서드 테스트
		p1.<String, Integer>displayAll("키", 180);
	}
}