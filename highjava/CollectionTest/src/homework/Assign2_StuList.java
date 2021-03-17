package homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Assign2_StuList {

	public static void main(String[] args) {
		List<Student> slist = new ArrayList<Student>();
		
		slist.add(new Student("20170001", "park", (int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)));
		slist.add(new Student("20170005", "lee", (int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)));
		slist.add(new Student("20170004", "seo", (int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)));
		slist.add(new Student("20170002", "kim", (int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)));
		slist.add(new Student("20170003", "choi", (int)(Math.random()*100), (int)(Math.random()*100), (int)(Math.random()*100)));
		
		Collections.sort(slist);
		System.out.println("학번의 오름차순 출력 >>");
		for(Student stu : slist) {
			System.out.println(stu);
		}
		
		System.out.println("총점의 오름차순 출력 >>");
		Collections.sort(slist, new SortSumDesc());
		for(Student stu : slist) {
			System.out.println(stu);
		}
		
		
		
	}
}
class Student implements Comparable<Student>{
	private String id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}

	public Student(String id, String name, int kor, int eng, int math) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
		this.rank = rank;
	}

	public String getId() {return id;}
	public void setId(String id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public int getKor() {return kor;}
	public void setKor(int kor) {this.kor = kor;}

	public int getEng() {return eng;}
	public void setEng(int eng) {this.eng = eng;}

	public int getMath() {return math;}
	public void setMath(int math) {this.math = math;}

	public int getSum() {return sum;}
	public void setSum(int sum) {this.sum = sum;}

	public int getRank() {return rank;}
	public void setRank(int rank) {this.rank = rank;}
	
	public int compareTo(Student stu) {//member o와 비교한다
		// TODO Auto-generated method stub
		return this.getId().compareTo(stu.getId());
	}
}

class SortSumDesc implements Comparator<Student>{

	@Override
	public int compare(Student stu1, Student stu2) {
		/*if(stu1.getSum() > stu2.getSum()) {
			return -1;
		}else if(stu1.getSum() == stu2.getSum()) {
			return 0;
		}else {
			return 1;
		}*/
		//wrapper클래스에서 제공되는 메서드를 이용하는 방법1
		//내림차순인 경우엔 *-1해줌
		return new Integer(stu1.getSum())
					.compareTo(stu2.getSum())*-1;
	}
	
}