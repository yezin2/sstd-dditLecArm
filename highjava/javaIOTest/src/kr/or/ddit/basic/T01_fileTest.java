package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;

public class T01_fileTest {
	
	
	public static void main(String[] args) throws IOException {
		/**
		 * 파일 객체 만들기 연습
		 * 1. new File(String파일  또는 경로)
		 * 	>> 디렉토리와 디렉토이 사이 또는 디렉토리와 파일명 상이의 구분문자는'/'나'\'를 사용할 수 있다.
		 */
//		File file = new File("d:/D_Other/test.txt");
		File file = new File("d:\\D_Other\\test.txt");
		System.out.println("파일명 : " + file.getName());
		System.out.println("파일여부 : " + file.isFile());
		System.out.println("디렉토리(폴더) 여부 : " + file.isDirectory());
		System.out.println("------------------------------------------");
		
		File file2 = new File("d:/D_Other");
//		File file2 = new File("d:/D_Other/test.txt");
		System.out.print(file2.getName() + "은 ");
		if(file2.isFile()) {
			System.out.println("파일");
		} else if (file2.isDirectory()) {
			System.out.println("디렉토리(폴더)");
		}
		System.out.println("------------------------------------------");
		
		//2. new File(File parent, String child)
		//	>> 'parent'디렉토리 안에 있는 'child'파일 또는 디렉토리를 말한다.
		File file3 = new File(file2, "test.txt");
		System.out.println(file3.getName() + "의 용량 크기 : "
					+ file.length() + "bytes");
		//3. new File(File parent, String child)
		File file4 = new File("d:/D_Other", "test.txt");
		System.out.println("절대경로 : " + file4.getAbsolutePath());
		System.out.println("경로 : " + file4.getPath());
		System.out.println("표준경로 : " + file4.getCanonicalPath());
		System.out.println("현재 클래스의 URL : " + T01_fileTest.class.getResource("T01_fileTest.class"));
		System.out.println("------------------------------------------");
		
		//현재클래스의 URL에서 경로부분을 가져오기
		System.out.println(T01_fileTest.class.getResource("").getPath());
		
		/**
		 * 디렉토리(폴더) 만들기
		 * 
		 * 1. mkdir() >> File객체의 경로  중 마지막 위치의 디렉토리를 만듬
		 * 			  >> 중간의 경로가 모두 미리 만들어져  있어야 함.
		 * 
		 * 2. mkdirs() >> 중간의 경로가 없으면 중간의 경로도 새롭게 만든 후 마지막 위치의 디렉토리를 만들어줌
		 * 
		 * >> 위 두 메서드 모두 만들기를 성공하면 true, 실패하면 false 반환
		 */
		
		File file5 = new File("d:/D_Other/연습용");
		if(file5.mkdir()) {
			System.out.println(file5.getName() + " 만들기 성공");
		} else {
			System.out.println(file5.getName() + " 만들기 실패");
		}
		System.out.println();
		
		File file6 = new File("d:/D_Other/test/java/src");
		if(file6.mkdir()) {
			System.out.println(file6.getName() + " 만들기 성공");
		} else {
			System.out.println(file6.getName() + " 만들기 실패");
		}
	}
}
