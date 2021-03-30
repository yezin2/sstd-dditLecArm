package kr.or.ddit.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		//InetAddress클래스 >> IP주소를 다루기 위한 클래스
		
		//naver사이트의 ip정보 가져오기
		InetAddress naverIp = InetAddress.getByName("www.naver.com");
		// machine name 또는 텍스트 형식의 ip 주소 반환
		System.out.println("HOST NAME >> " + naverIp.getHostName());
		System.out.println("HOST ADDRESS >> " + naverIp.getHostAddress());
		System.out.println();
		
		//자기자신 컴퓨터의 IP 정보 가져오기
		InetAddress localIp = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 Host Name >>" + localIp.getHostName());
		System.out.println("내 컴퓨터의 Host Address >> " + localIp.getHostAddress());
		
		//ip주소가 여러개인 호스트의 정보 가져오기
		InetAddress[] naverIps = InetAddress.getAllByName("www.naver.com");
		for(InetAddress nIp : naverIps) {
			System.out.println(nIp.toString());
		}
	}
}
