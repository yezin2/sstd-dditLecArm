package kr.or.ddit.basic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class T02_FileTest {
	public static void main(String[] args) {
		File f1 = new File("d:/D_Other/sample.txt");
		File f2 = new File("d:/D_Other/test.txt");
		
		if(f1.exists()) {
			System.out.println(f1.getAbsolutePath() + "은 존재합니다.");
		}else {
			System.out.println(f1.getAbsolutePath() + "은 없는 파일입니다.");
			
			try {
				if(f1.createNewFile()) {
					System.out.println(f1.getAbsolutePath()
						+ "파일을 새로 만들었습니다.");
				}
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		if(f2.exists()) {
			System.out.println(f2.getAbsolutePath() + "은 존재합니다.");
		}else {
			System.out.println(f2.getAbsolutePath() + "은 없는 파일입니다.");
		}
		System.out.println("--------------------------------------");
		
		File f3 = new File("d:/D_Other");
		File[] files = f3.listFiles();
		for(int i=0; i<files.length; i++) {
			System.out.println(files[i].getName() + " >> ");
			if(files[i].isFile()) {
				System.out.println("file");
			} else if(files[i].isDirectory()) {
				System.out.println("directory");
			}
		}
		System.out.println("=======================================");
		String[] strFiles = f3.list();
		for(String str : strFiles) {
			System.out.println(str);
		}
		System.out.println("--------------------------------------");
		System.out.println();
		
		//================================================================================
		
		//출력할 디렉토리 정보를 갖는 File객체 생성
		File f4 = new File("d:/A_TeachingMaterial");
		
		displayFilelist(f4);
	}

	/**
	 * 지정된 디렉토리(폴더)에 포함된 파일과 디렉토리 목록을 보여주는 메서드
	 * @param dir 목록을 보고자 하는 디렉토리
	 */
	private static void displayFilelist(File dir) {
		System.out.println("[" + dir.getAbsolutePath() + "]"
					+ " 디렉토리 내용");
		//디렉토리 안의 모든 파일 목록을 가져온다.
		File[] files = dir.listFiles();
		
		//하위디렉토리 정보를 저장할 ArrayList생성(File배열의 인덱스 저장)
		List<Integer> subDirList = new ArrayList<Integer>();
		
		//날짜를 출력하기 위한 형식 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd a hh:mm");
		for(int i=0; i<files.length; i++) {
			String attr = "";//파일의 속성정보(읽기, 쓰기, 히든, 디렉토리 등)
			String size = "";//파일 용량
			
			if(files[i].isDirectory()) {
				attr = "<DIR>";
				subDirList.add(i);//인덱스 정보 저장
			} else {
				size = files[i].length() + "";
				attr = files[i].canRead() ? "R" : " ";
				attr += files[i].canWrite() ? "W" : " ";
				attr += files[i].isHidden() ? "H" : " ";
			}
			
			System.out.printf("%s %5s %12s %s\n", sdf.format(new Date(files[i].lastModified())),
					attr, size, files[i].getName());
		}//for 끝...
		
		int dirCount = subDirList.size();//폴더안의 하위폴더 개수 구하기
		int fileCount = files.length - dirCount; //폴더안의 파일 개수
		
		System.out.println(fileCount + "개의 파일, " + dirCount + "개의 디렉토리");
		System.out.println();
		
	}
}
