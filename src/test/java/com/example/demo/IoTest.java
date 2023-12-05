package com.example.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class IoTest {

	
	@Test
	public void fileoutputTest() { //�g��ƶi�ɮפ����ɦWtxt�����O��,�]��demo���h�F�@��aaa���O�ƥ�
		try (FileOutputStream fos = new FileOutputStream("aaa.txt",true)){
			String str = "����,���ѤѮ�u�n�C!!!!!!\n" ;              //���w�]���|�b�M�ש��U,�Y�n�[���|�[�����|��n�A�h�[�@���׽u
			byte[] byteArray = str.getBytes();
			fos.write(byteArray);
			System.out.println("�ɮ׼g�J����~~");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void fileInputStreamTest() { //�g��ƶi�ɮפ����ɦWtxt�����O��,�]��demo���h�F�@��aaa���O�ƥ�
//		try (FileInputStream fos = new FileInputStream("aaa.txt")){
//			String str = "����,���ѤѮ�u�n�C!!!!!!\n" ;              //���w�]���|�b�M�ש��U,�Y�n�[���|�[�����|��n�A�h�[�@���׽u
//			byte[] byteArray = str.getBytes();
//			fos.write(byteArray);
//			System.out.println("�ɮ׼g�J����~~");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	@Test
	public void fileInputTest() { //�g��ƶi�ɮפ����ɦWtxt�����O��,�]��demo���h�F�@��aaa���O�ƥ�
		try (FileInputStream fis = new FileInputStream("aaa.txt")){
//			while (fis.read()!= -1) {
//				System.out.println((char)fis.read());
//			}
			while (fis.available() > 0) {
				System.out.println((char)fis.read(fis.readAllBytes()));
			}
			System.out.println("�ɮ�Ū������~~");
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
