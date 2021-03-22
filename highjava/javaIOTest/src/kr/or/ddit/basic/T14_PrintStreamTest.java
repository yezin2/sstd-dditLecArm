package kr.or.ddit.basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 프린터 기능 제공 보조 스트림
 */
public class T14_PrintStreamTest {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
		
		//PrintStream은 모든 자료형을 출력할 수 있는 기능을 제공하는 OutputStream의 서브 클래스임
		//PrintStreamdms IOException을 발생시키지 않는다.
		//println및 print등 메서드 호출시 마다 autoflush기능 제공
		PrintStream out = new PrintStream(fos);
		out.print("hi, im PrintStream.\n");
		out.println("hi, im PrintStream.2");
		out.println("hi, im PrintStream.3");
		out.println(out); //객체 출력
		out.println(3.14);
		
	/**
	 * PrintStream은 데이터를 문자로 출력하는 기능을 수행함.(System.out)
	 * 향상된 기능의 PrintWriter가 추가되었지만 계속 사용됨.
	 * 
	 * Printwrite가 PrintStream보다 다양한 언어의 문자를 처리하는데 적합함.
	 * 둘 다 기본적으로 autoflush 기능이 꺼져있음.	
	 */
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(fos2, "UTF-8"));
		
		pw.print("hi, im PrintWriter.\r\n");
		pw.println("hi, im PrintWriter.2");
		pw.println("hi, im PrintWriter.3");
		
		pw.close();
	}
}
