package kr.or.ddit.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpFileClient {
/*
   클라이언트는 서버에 접속하여 서버가 보내주는 파일을 
  d:/C_Lib폴더에 저장한다. 
*/
	private Socket socket;
	private InputStream is;
	private FileOutputStream fos;
	
	
	public void startClient() {
		File file = new File("d:/C_LIb/download.jpg");
		try {
			socket = new Socket("192.168.43.132", 7777);
			System.out.println("파일 다운로드 시작!");
			
			fos = new FileOutputStream(file);
			is = socket.getInputStream();
			
			byte[] tmp = new byte[1024];
			int length = 0;
			while((length = is.read(tmp)) != -1) {
				fos.write(tmp, 0, length);
			}
			fos.flush();
			System.out.println("파일 다운로드 완료....");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			if(is != null) {
				try {is.close();}catch(IOException ex) {}
			}
			if(fos != null) {
				try {fos.close();}catch(IOException ex) {}
			}
			if(socket != null) {
				try {socket.close();}catch(IOException ex) {}
			}
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
}
