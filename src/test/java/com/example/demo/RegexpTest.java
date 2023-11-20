package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class RegexpTest {
	
	@Test	
	public void regexpTest() { //正規表達式(格式為字串)
		String str = "0912-345-678";
		//單一反斜線\為跳脫符號,是有意義的(但無法單獨存在),\\雙反斜線可以存在,第一個斜線把第二個斜線變成沒意義單純斜線
//		String pattern = "\\d\\d\\d\\d-\\d\\d\\d-\\d\\d\\d"; 一個斜線\\d \\d代表一個數字,d單純代表數字
//		String pattern = "\\d{4}-\\d{3}-\\d{3}"; //使用大括號 {} 處理重複出現字串部分,{}內代表重複出現次數
		String pattern = "\\d{4}(-\\d{3}){2}";   //使用大括號{}處理重複出現字串,()小括號分組重複出現的\\d跟-號,{2}為重複2次
		System.out.println(str.matches(pattern)); //str.matches(pattern);意思為這個str字串是否有符合這格式,pattern
	} 
	
	@Test	
	public void regexpTest2() { //正規表達式(格式為字串)
//		String pattern = "(\\d{2})\\d{8}"; //格式:(2碼) 8碼,不包含小括號;小括號只是做分組用
		String pattern = "\\(\\d{2}\\)\\d{8}"; //格式:(2碼) 8碼,包含小括號
	}
	
	@Test	
	public void regexpTest3() { //正規表達式(格式為字串)
//		String pattern = "(\\d{2})\\d{8}"; //格式:(2碼) 8碼,不包含小括號;小括號只是做分組用		
//		String pattern0 = "\\(\\d{2}\\)\\d{7}"; //格式:(2碼) 7碼,包含小括號
//		String pattern1 = "\\(\\d{2}\\)\\d{8}"; //格式:(2碼) 8碼,包含小括號
		//patternA&B為↑0跟1的整合一起寫法,兩個效果相同,擇一使用
//		String patternA = "\\(\\d{2}\\)\\d{7}||\\(\\d{2}\\)\\d{8}";//(02)1234567 or (02)12345678
//		String patternB = "\\(\\d{2}\\)(\\d{7}||\\d{8})";//PDF內的寫法
//		patternC為最簡潔的寫法 格式:(2碼) 7,8碼,包含小括號	
//		String patternC = "\\(\\d{2}\\)\\d{7,8}";//{}內的7,8為7或是8碼,7逗點8為範圍		
		
//		String pattern2 = "\\d{2}-\\d{7}";//格式:2碼 7碼
//		String pattern3 = "\\d{2}-\\d{8}";//格式:2碼 8碼
//		patternD為上面2.3整合	
//		String patternD = "\\d{2}-\\d{7,8}";//{}內的7,8為7或是8碼,7逗點8為範圍		
//		patternC和D整合,整合為patternE
		String patternE = "(\\(\\d{2}\\)||\\d{2}-)\\d{7,8}";		
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入電話號碼 :");
		System.out.println("電話號碼格式為 :(區碼兩碼)電話號碼7碼或8碼");
		System.out.println("電話號碼格式為 :區碼兩碼-電話號碼7碼或8碼");
		String input = scan.next();
		if (input.matches(patternE) || input.matches(patternE)) {
			System.out.println(input + "符合格式!!");
		}else {
			System.out.println(input + "不符合格式!!");
		}
	}
	
	@Test	
	public void regexpTest4() {
		String str = "a";
		String str1 = "AB";
		String pattern = "\\w";	  // \\w占用一個字元,但範圍限縮再[A-Za-z0-9_]包含底線
		String pattern1 = "\\w."; //代表兩個字元,一個點.代表一個萬用字元(除了換行符號(\n)之外其他所有字元),但只佔一個字元
		// \\w占用一個字元,但範圍限縮再[A-Za-z0-9_]包含底線
		// .*表示0~多個字元,所以後面的字元可有(1~多個)或是可無
		String pattern2 = "\\w.*";//.*代表0~多個字元
		System.out.println(str.matches(pattern)); //true
		System.out.println(str1.matches(pattern));//false
		System.out.println("========================");
		System.out.println(str.matches(pattern1));//false //str.matches字串比對
		System.out.println(str1.matches(pattern1));//true
		System.out.println("========================");
		System.out.println(str.matches(pattern2));//true
		System.out.println(str1.matches(pattern2));//true
		} 
	
	@Test 
	/*
	▪ 身份證字號檢查
	▪ 10碼
	▪ 第一個字為英文字母(大小寫皆可)
	▪ 英文字母後面接著的第一個數字只會是 1 或 2
	▪ 請用正規表達式完成
	▪ 完成後請排除六都的英文字母(A,B,D,E,F,H)(請使用特殊字元)*/
	public void regexpTest5() {
		String pattern = "[A-Za-z&&[^ABDEFHabdefh]][1,2]\\d{8}"; //[]內排除了^ABDEFHabdefh	
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入身分證字號(共10碼)首個英文字大小寫皆可 :");
		String input = scan.next();
		if (input.matches(pattern)) {
			System.out.println(input + "符合格式!!");
		}else {
			System.out.println(input + "不符合格式!!");
		}
		System.out.println(input.matches(pattern)); //輸入的比對pattern變數格式
	}
}

	
