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
	public void arrayTest() {	//陣列宣告的空間(長度)固定。
		int[] a = new int[5];	//new建立一個類別,劃分一個記憶體空間給予這個類別。
		System.out.println(a);
		System.out.println(a.length);
		a[0] = 1; 	//把1賦予等號左邊這個陣列a的第0個索引位置(index)。
		a[1] = 5; 	//把1賦予等號左邊這個陣列a的第0個索引位置(index)。
		System.out.println(a);
		System.out.println("=====================");
		//宣告的同時給予初始值
		int[] b = {1, 3, 5, 7, 9}; 
		System.out.println(b[2]);  //印出陣列索引位置第二個為5,索引值都從0開始
		for(int item: b) {
			System.out.println(item);
		}
	}
	
	@Test
	public void listTest() {
		/*    ↓必填								   				             ↓可省略
		List<資料型態> 變數名稱 = new ArrayList<>(); 目前先記這個只能使用new ArrayList<放資料型態>( );*/
		List<String> strList = new ArrayList<>(); 
		strList.add("A");  //List的空間長度為動態的 add為依序把資料加入。
		strList.add("C");  
		strList.add("D");
		strList.add("B");
		//List是有順序(有序)的,依照加入的先後順序印出。
		System.out.println(strList);
		System.out.println("========================");
		System.out.println(strList.size()); //計算List長度使用size
		System.out.println("========================");
		//取出陣列或是List都是使用for迴圈取出
		for(int i = 0;i < strList.size(); i++) {
			System.out.println(strList.get(i)); //印出並取出使用get(i)
		}
		System.out.println("========================");
		List<String> strList1 = List.of("A", "S", "D", "F");//不可更改,固定大小
		// 						↓要import第二個
		List<String> strList2 = Arrays.asList("A1", "S1", "D1", "F1");//不可更改,固定大小
		//↓執行下一行程式會報錯,因為用List.of()產生的List其大小固定,無法再增刪
//		strList.add("G");
		//↓執行下一行程式會報錯,因為用Arrays.asList()產生的List其大小固定,無法再增刪
//		strList2.add("G1");
		System.out.println("========================");
		List<String> strList3 = new ArrayList<>(List.of("A", "S", "D", "F")); //容納的空間改為new ArrayList改為容納空間動態的可以做增刪
		List<String> strList4 = new ArrayList<>(Arrays.asList("A1", "S1", "D1", "F1"));//容納的空間改為new ArrayList改為容納空間動態的可以做增刪
		//new ArrayList<>();就是產生一個動態的空間可以做增刪
	}
	
	@Test
	public void foreachTest() {
		List<String> strList = new ArrayList<>(List.of("A", "S", "D", "F"));//不可更改,固定大小
		for(int i = 0;i < strList.size(); i++) {
			System.out.println(strList.get(i)); 
		}
		System.out.println("========================");
		//foreach(遍歷):意思是指將List裡的每個項目從頭到尾一個一個取出
		for(String item :strList ){	  //for(資料型態 變數:對誰作用)
			System.out.println(item);
		}
		System.out.println("========================");	
		strList.forEach(item ->{ 	//strList裡的forEach(遍歷)
			System.out.println(item);
		});
	}
	
	@Test
	public void listTest1() {
		int a = 5;
		int[] b = new int[5];
		System.out.println(a);
		System.out.println(b);
		//List<>括號內的類別型態放的一定為大寫的類別型態
		System.out.println("==================");
		//可以直接使用等號給予值只有8種基本資料型態大小寫&字串
				
	}
}

