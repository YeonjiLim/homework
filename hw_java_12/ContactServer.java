package com.ssafy.server;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.ssafy.java.Customer;

public class ContactServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=new ServerSocket(3000);
		Socket s=null;
		ObjectInputStream ois=null;
		Customer cu=null;
		
		while(true){
			s=ss.accept();//클라이언트가 접속될 때까지 대기
			ois=new ObjectInputStream(s.getInputStream());
			try{
				while(true){
					cu=(Customer)ois.readObject();
					if(cu==null) break;
					System.out.println(cu);
				}
			}catch(EOFException e){
				System.out.println("전송 종료");
			}catch(Exception e){
				System.out.println(e);
			}finally{
				ois.close();
				s.close();
			}
		}
	}

}
