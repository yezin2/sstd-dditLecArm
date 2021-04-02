package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * JSON : JavaScript Object Notation
 * 
 * - JSON에서 value값으로 가능한 데이터 타입
 * 1. String
 * 2. Number
 * 3. Object(JSON Object)
 * 4. array
 * 5. boolean
 * 6.null
 */
public class JSONSimpleWriterTest {
	public static void main(String[] args) throws IOException {
		//JSON 데이터 설정
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "류준열");
		jsonObj.put("job", "배우");
		jsonObj.put("age", 36);
		jsonObj.put("addr", "대전시 서구 탄방동 85-3");
		
		//JSONArray 데이터 설정
		JSONArray singerList = new JSONArray();
		JSONObject singer = new JSONObject();
		singer.put("name", "이승기");
		singer.put("age", 35);
		singer.put("gender", "male");
		singerList.add(singer);
		
		jsonObj.put("singerList", singerList);
		
		FileWriter fw = new FileWriter("d:/D_Other/myJsonfile.txt");
		fw.write(jsonObj.toString());
		fw.flush();
		fw.close();
		
		System.out.println("JSON객체 내용 출력 : " + jsonObj);
		
	}
}
