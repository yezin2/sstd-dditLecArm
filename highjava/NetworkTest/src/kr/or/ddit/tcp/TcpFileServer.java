package kr.or.ddit.tcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	/*
	 	서버는 클라이언트가 접속하면 서버 컴퓨터의 d:\D_Other\폴더에 있는 Tulips.jpg 파일을 클라이언트로 전송한다.
	 */
	private ServerSocket severSocket;
	private Socket socket;
	private OutputStream out;
	private FileInputStream fis;
	private File file = new File("d:/D_Other/1.jpg");
	
	public void startServer() {
		while (true) {
			try {
				severSocket = new ServerSocket();
				System.out.println("서버 준비 완료...");
				
				socket = severSocket.accept();
				System.out.println("파일 전송 시작...");
				
				fis = new FileInputStream(file);
				out = socket.getOutputStream();
				
				//한꺼번에 읽어와 전송할 데이터 저장 변수 선언
				byte[] tmp = new byte[1024];
				int c = 0;
				while ((c = fis.read(tmp)) != -1) {
					out.write(tmp, 0, c);
				}
				out.flush();
				
				System.out.println("파일 전송 완료...");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(fis != null) {
					try {fis.close();}catch(IOException e) {}
				}
				if(out != null) {
					try {out.close();}catch(IOException e) {}
				}
				if(socket != null) {
					try {socket.close();}catch(IOException e) {}
				}
				if(severSocket != null) {
					try {severSocket.close();}catch(IOException e) {}
				}
			}
		}
	}
}
