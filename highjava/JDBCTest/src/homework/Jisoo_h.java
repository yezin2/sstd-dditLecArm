package homework;

import java.util.Scanner;

public class Jisoo_h {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 입력 > ");
		int input = sc.nextInt();//name개수
		
		String[] name = 
			{"가","나","다","라","마","바","사",
					"아","자","차","카","타","파","하"};
		String[] parr = new String[input];//name 개수 만큼 랜덤이름을 출력할 배열
		for(int i=0; i<input; i++) {//개수만큼 name 인덱스중에 랜덤으로 고르기
			int num = (int)(Math.random()*14);
			parr[i] = name[num];//출력할 배열에 랜덤으로 이름 넣기
			for(int j=0; j<i; j++) {
				if(parr[i] == parr[j]) {//중복 검사 같으면 앞자리 인덱스로 돌아가고 다르면 스킵하고 다음 인덱스 실행
					i--;//다시 돌아감
					break;
				}//if
			}//for2
		}//for1
		for(int i=0; i<input; i++) {
			System.out.println(parr[i]);//랜덤이름 출력
		}//for3
	}
}
