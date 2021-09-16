package kr.or.test5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputTest1 {

	public static void main(String[] args) {
		FileOutputStream fo = null;
		String msg = "FileOutputStreamTest";
		byte[] byteArray = msg.getBytes();
		
				try {
					fo = new FileOutputStream("C:\\khJava\\fileoutput.txt",true);
					fo.write(byteArray);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						fo.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		
	}

}
