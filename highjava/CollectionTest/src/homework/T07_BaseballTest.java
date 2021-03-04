package homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class T07_BaseballTest {
	public static void main(String[] args) {

		/*
		 * 135
		 * 123 : 1s,1b,2o
		 * 531 : 1s,2b,0o
		 * 321 : 0s,2b 1o 
		 */
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> baseb = new HashSet<Integer>();
		
		while(baseb.size() < 3) {
			baseb.add((int)(Math.random()*9 +1));
		}
		int[] num = new int[3];
		int i;
		int n3 ,e3;
		int temp, s=0, b=0, o=0;
		boolean a = true;
		boolean c = true;
		
		Iterator it = baseb.iterator();
		
		List<Object> list = new ArrayList<Object>();
		while(it.hasNext()) { // 다음자료가 있는지 검사
			//next()메서드 >> 포인터를 다음 자료 위치로 이동하고, 이동한 위치의 자료를 반환한다.
			num[i++] = ((Integer) it.next()).intValue();
			//list.add(it.hasNext());
		}
			n1 = (int)list.get(0);
			n2 = (int)list.get(1);
			n3 = (int)list.get(2);
			/*if(n1==n2)
				System.out.println("ERROR : RESTART");
			else if(n2==n3)
				System.out.println("ERROR : RESTART");
			else if(n3==n1)
				System.out.println("ERROR : RESTART");*/
		while(a){
			s=0;
			b=0;
			o=0;
			c=true;
		System.out.println("ENTER FIRST NUMBER > ");
		e1 = Integer.parseInt(sc.nextLine());
		System.out.println("ENTER SECOND NUMBER > ");
		e2 = Integer.parseInt(sc.nextLine());
		System.out.println("ENTER THIRD NUMBER > ");
		e3 = Integer.parseInt(sc.nextLine());
		while(c){
		temp = e1;
			if(temp == n1){
				s++;
				temp = e2;
				if(temp == n2){
					s++;
					temp = e3;
					if(temp == n3){
						s++;
						temp = 0;
					}//1.1.1
					else o++;
				}//1.1
				else if(temp == n3){
					b++;
					temp = e3;
					if(temp == n2){
						b++;
						temp = 0;
					}//1.2.1
					else o++;
				}//1.2
				else{
					o++;
					temp = e3;
					if(temp == n1 || temp == n2){
						b++;
						temp = 0;
					}//1.3.1
					else if(temp == n3){
						s++;
						temp = 0;
					}//1.3.2
					else{
						o++;
						temp = 0;
					}//1.3.3
				}//1.3
			}//1
			
			else if(temp == n2 || temp == n3){
				b++;
				temp = e2;
				if(temp == n2){
					s++;
					temp = e3;
					if(temp == n3){
						s++;
						temp = 0;
					}//2.1.1
					else if(temp == n1 || temp == n2){
						b++;
						temp = 0;
					}
					else {
						o++;
						temp = 0;
					}//2.1.3
				}//2.1
				else if(temp == n1 || temp == n3){
					b++;
					temp = e3;
					if(temp == n1 || temp == n2 || temp == n3){
						b++;
						temp = 0;
					}//2.2.1
					else if(temp == n3){
						s++;
						temp = 0;
					}//2.2.2
					else {
						o++;
						temp = 0;
					}
				}//2.2
				else {
					o++;
					temp = e3;
					if(temp == n3){
						s++;
						temp = 0;
					}
					else if(temp == n1 || temp == n2){
						b++;
						temp = 0;
					}
					else {
						o++;
						temp = 0;
					}
				}
			}//2
			else {
				o++;
				temp = e2;
				if(temp == n1 || temp == n3){
					b++;
					temp = e3;
					if(temp == n1 || temp == n2 || temp == n3){
						b++;
						temp = 0;
					}//3.1.1
					else if(temp == n3){
						s++;
						temp = 0;
					}//3.1.2
					else{
						o++;
						temp = 0;
					}//3.1.3
				}//3.1
				else if(temp == n2){
					s++;
					temp = e3;
					if(temp == n1){
						b++;
						temp = 0;
					}//3.2.1
					else if(temp == n3){
						s++;
						temp = 0;
					}//3.2.2
					else{
						o++;
						temp = 0;
					}//3.2.3
				}//3.2
				else {
					o++;
					temp = e3;
					if(temp == n1||temp == n2){
						b++;
						temp = 0;
					}//3.3.1
					else if(temp == n3){
						s++;
						temp = 0;
					}//3.3.2
					else{
						o++;
						temp = 0;
					}//3.3.3
				}//3.3
			}//3
			System.out.println(s+ "s " +b+ "b " +o+ "o");
			c=false;
		}
		
			if(s==3){
				System.out.println("FINISH!");
				a = false;
			}
		}
}
