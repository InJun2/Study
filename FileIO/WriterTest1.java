package kr.or.test5;

import java.io.FileWriter;
import java.io.IOException;

public class WriterTest1 {

	public static void main(String[] args) {
		FileWriter fw = null;
		
		String msg = "FileWriterTest \r \n";
		
		try {
			fw = new FileWriter("C:\\khJava\\fileWriter.txt",true);
			fw.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
