package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IoTest {

	
	@Test
	public void fileoutputTest() { //寫資料進檔案內副檔名txt為筆記本,因此demo內多了一個aaa的記事本
		try (FileOutputStream fos = new FileOutputStream("aaa.txt",true)){
			String str = "水喔,今天天氣真好耶!!!!!!\n" ;              //↑預設路徑在專案底下,若要加路徑加完路徑後要再多加一條斜線
			byte[] byteArray = str.getBytes();
			fos.write(byteArray);
			System.out.println("檔案寫入完成~~");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void fileInputStreamTest() { //寫資料進檔案內副檔名txt為筆記本,因此demo內多了一個aaa的記事本
//		try (FileInputStream fos = new FileInputStream("aaa.txt")){
//			String str = "水喔,今天天氣真好耶!!!!!!\n" ;              //↑預設路徑在專案底下,若要加路徑加完路徑後要再多加一條斜線
//			byte[] byteArray = str.getBytes();
//			fos.write(byteArray);
//			System.out.println("檔案寫入完成~~");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	@Test
	public void fileInputTest() { //寫資料進檔案內副檔名txt為筆記本,因此demo內多了一個aaa的記事本
		try (FileInputStream fis = new FileInputStream("aaa.txt")){
//			while (fis.read()!= -1) {
//				System.out.println((char)fis.read());
//			}
			while (fis.available() > 0) {
				System.out.println((char)fis.read(fis.readAllBytes()));
			}
			System.out.println("檔案讀取完成~~");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void fileReaderTest() { 
		try (FileReader fr = new FileReader("aaa.txt") ){
			int i;
			while ((i = fr.read()) != -1) {
				System.out.println((char)i);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}
