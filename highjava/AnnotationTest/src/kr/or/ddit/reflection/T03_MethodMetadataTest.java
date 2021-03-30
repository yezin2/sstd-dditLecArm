package kr.or.ddit.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class T03_MethodMetadataTest {
	public static void main(String[] args) {
		//Class 객체 생성
		Class<?> clazz = SampleVO.class;
		
		// 클래스에 선언된 모든 메서드의 메타데이터 정보 가져오기
		Method[] methodArr = clazz.getDeclaredMethods();
		
		for(Method method : methodArr) {
			System.out.println("메서드 명 : " + method.getName());
			System.out.println("메서드 리턴타입 : " + method.getReturnType());
			
			//해당메서드의 접근제어자 정보 가져오기
			int modFlag = method.getModifiers();
			System.out.println("메서드 접근제어자 : " + Modifier.toString(modFlag));
			
			// 해당 메서드의 파라미터 값 가져오기
			Class<?>[] paramList = method.getParameterTypes();
			System.out.println("메서드 파라미터 타입 : ");
			for(Class<?> klass : paramList) {
				System.out.println(klass.getName() + " | ");
			}
			System.out.println();
			
			//해당 메서드에서 던지는 예외타입 가져오기
			Class<?>[] exTypeArr = method.getExceptionTypes();
			System.out.println("메서드에서 던지는 예외타입 목록 : ");
			for(Class<?> klass : exTypeArr) {
				System.out.println(klass.getName() + " | ");
			}
			System.out.println("=========================================");
		}
	}
	
}
