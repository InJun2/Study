package kr.or.test5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest1 {

	public static void main(String[] args) {
		FileReader fr = null;
		String str = "";
		
		try {
			fr = new FileReader("c:\\khJava\\fileWriter.txt");
			int readChar = -1;
			while((readChar=fr.read())!=-1) {
				str +=(char)readChar;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(str);

	}

}
