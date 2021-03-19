package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Filewriter(문자 기반 스트림)예제
 * @author PC-17
 *
 */
public class T07_FileWriterTest {
	public static void main(String[] args) {
		//사용자가 입력한 내용을 그대로 파일로 저장하기
		
		//콘솔(표준 입력장치)과 연결된입력용 문자 스트림생성
		//InputStreamReader >> 바이트 기반 스트림을 문자 기반 스트림으로 변환해주는 보조 스트림
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null;//파일 출력용 문자 기반 스트림
		
		try {
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int c;
			
			System.out.println("아무거나 입력");
			
			//콘솔에서 입력할때 입력의 끝표시는 ctrl+z 를 누르면 됨
			while((c = isr.read()) != -1) {
				fw.write(c);//콘솔에서 입력받은 값을 파일에 출력하기
			}
			
			System.out.println("작업 끝....");
			
			isr.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
