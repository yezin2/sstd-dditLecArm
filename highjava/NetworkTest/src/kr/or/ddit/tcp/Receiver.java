package kr.or.ddit.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receiver extends Thread{
	private DataInputStream dis;
	
	public Receiver(Socket socket) {
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (dis != null) {
			try {
				System.out.println(dis.readUTF());
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
	}
}
