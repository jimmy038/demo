package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import ch.qos.logback.core.net.SyslogOutputStream;

public class ArrayTest {

	@Test
	public void arrayTest() {	//�}�C�ŧi���Ŷ�(����)�T�w�C
		int[] a = new int[5];	//new�إߤ@�����O,�����@�ӰO����Ŷ������o�����O�C
		System.out.println(a);
		System.out.println(a.length);
		a[0] = 1; 	//��1�ᤩ��������o�Ӱ}�Ca����0�ӯ��ަ�m(index)�C
		a[1] = 5; 	//��1�ᤩ��������o�Ӱ}�Ca����0�ӯ��ަ�m(index)�C
		System.out.println(a);
		System.out.println("=====================");
		//�ŧi���P�ɵ�����l��
		int[] b = {1, 3, 5, 7, 9}; 
		System.out.println(b[2]);  //�L�X�}�C���ަ�m�ĤG�Ӭ�5,���ޭȳ��q0�}�l
		for(int item: b) {
			System.out.println(item);
		}
	}
	
	@Test
	public void listTest() {
		/*    ������								   				             ���i�ٲ�
		List<��ƫ��A> �ܼƦW�� = new ArrayList<>(); �ثe���O�o�ӥu��ϥ�new ArrayList<���ƫ��A>( );*/
		List<String> strList = new ArrayList<>(); 
		strList.add("A");  //List���Ŷ����׬��ʺA�� add���̧ǧ��ƥ[�J�C
		strList.add("C");  
		strList.add("D");
		strList.add("B");
		//List是有順序的 是依照加入的先後順序
		System.out.println(strList);
		System.out.println("========================");
		System.out.println(strList.size()); //算陣列的長度.size()，陣列算長度length
		System.out.println("========================");
		//陣列跟List都是用for迴圈取資料 index從0開始宣告為0
		for(int i = 0; i < strList.size(); i++) {
			System.out.println(strList.get(i)); //
		}
		System.out.println("========================");
		//直接給值List.of()括號內給值 ， List.of產生空間長度固定
		List<String> strList1 = List.of("A", "S", "D", "F");
		// 						import
		List<String> strList2 = Arrays.asList("A1", "S1", "D1", "F1");//
		//執行下一行程式會報錯 因為用List.of產生空間長度固定，無法再增刪
//		strList1.add("G");
		//執行下一行程式會報錯 因為用List.of產生空間長度固定，無法再增刪
//		strList2.add("G1");
		System.out.println("========================");
		List<String> strList3 = new ArrayList<>(List.of("A", "S", "D", "F")); //�e�Ǫ��Ŷ��אּnew ArrayList�אּ�e�ǪŶ��ʺA���i�H���W�R
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "S1", "D1", "F1"));//�e�Ǫ��Ŷ��אּnew ArrayList�אּ�e�ǪŶ��ʺA���i�H���W�R
		//new ArrayList<>();�N�O���ͤ@�ӰʺA���Ŷ��i�H���W�R
	}
	
	@Test
	public void forEachTest() {
		List<String> strList = new ArrayList<>(List.of("A", "S", "D", "F"));//���i���,�T�w�j�p
		for(int i = 0;i < strList.size(); i++) {
			System.out.println(strList.get(i)); 
		}
		System.out.println("========================");
		//foreach(�M��):�N��O���NList�̪��C�Ӷ��رq�Y����@�Ӥ@�Ө��X
		for(String item : strList ){	  //for(��ƫ��A �ܼ�:��֧@��)
			System.out.println(item);
		}
		System.out.println("========================");	
		strList.forEach(item ->{ 	//strList�̪�forEach(�M��)
			System.out.println(item);
		});
	}
	
	@Test
	public void listTest1() {
		int a = 5;
		int[] b = new int[5];
		System.out.println(a);
		System.out.println(b);
		//List<>�A���������O���A�񪺤@�w���j�g�����O���A
		System.out.println("==================");
		//�i�H�����ϥε��������ȥu��8�ذ򥻸�ƫ��A�j�p�g&�r��
				
	}
	
 
	@Test
	public void listTest2() {
		int a = 5;
		int[] b = new int[5];
		System.out.println(a);
		System.out.println(b);
		//List<>�A���������O���A�񪺤@�w���j�g�����O���A
		System.out.println("==================");
		//�i�H�����ϥε��������ȥu��8�ذ򥻸�ƫ��A�j�p�g&�r��
				
	}
	
	@Test
	public void listTest3() {
		int a = 5;
		int[] b = new int[5];
		System.out.println(a);
		System.out.println(b);
		//List<>�A���������O���A�񪺤@�w���j�g�����O���A
		System.out.println("==================");
		//�i�H�����ϥε��������ȥu��8�ذ򥻸�ƫ��A�j�p�g&�r��
				
	}
}

