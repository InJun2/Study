package kr.or.test5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputTest1 {

	public static void main(String[] args) {
		FileInputStream fin = null;
		String str ="";
		
		try {
			fin = new FileInputStream("C:\\khJava\\fileoutput.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		int var_read = -1;
		
		try {
			while((var_read = fin.read()) != -1) {
				str+=(char)var_read;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(str);
	}

}
