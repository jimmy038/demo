package com.example.demo;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ConditionTest {

	private int b;
	@Test		//JAVA內的數值的比較只有到等於等於==,下列為if判斷式
	//if()括號內為條件判斷{}大括號內為程式敘述區域 if(條件判斷){程式敘述區域}
	public void ifTest() {
		int a = 5;
		if(a > 5) {
			System.out.println("======");
		}else {
			System.out.println("++++++");
		}
	}
	
	@Test		//JAVA內的數值的比較只有到等於等於== 下列為if else if判斷式
	public void ifTest1() {
		int a = 5;
		if(a > 5) {
			System.out.println("======");
		}else if(a > 6){
			System.out.println("++++++");
		}else {
			System.out.println("123");
		}
	}
	
	public void ifTest2() {
		int a = 5;
		if(a > 5) {
			System.out.println("======");
		}else if(a > 6){
			System.out.println("++++++");
		}else {
			System.out.println("123");
		}
	}
	
	/*練習 – 使用 switch
	▪ 假設麥當勞打工每週領一次薪水,工作基本時薪是 150 元,其他規則
	如下▪ 
	▪ 小於40小時(週),每小時是基本時薪的 0.8 倍
	▪ 等於40小時(週),每小時是基本時薪
	▪ 大於40小時(週)至50(含)小時(週),每小時是基本時薪的 1.2 倍
	▪ 大於50小時(週),每小時是基本時薪的 1.6 倍*/
	
	
	@Test
	/* 練習 switch */
	public void switchTest() {
		int a = 95;
		int b =95/10;
		double c = 95.0/10;		//int b為整數95除以10之後為9,原本為9.5會自動把9.5後面的.5去掉,除非用double去接b這個變數
								//原本預設整數int都是int除以int出來結果為9,若要讓他出來結果為浮點數需讓除數或被除數其中為浮點數EX:95.0/10.0
		System.out.println(b);
		System.out.println(c);
	}
	
	@Test
	//Scanner會去讀取我們所輸入的內容System.out.println為輸出,Scanner(System.in)需要我們的輸入所以使用(System.in)
	public void ScannerTest() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請輸入文字:");
		String a = scan.next();
		System.out.println("輸入的文字是:" + a);

	}
	
	@Test
	public void ScannerTest1() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請輸入文字:");
		String a = scan.next();
		String b = scan.next();
		System.out.println("輸入的文字是:" + a +b ) ;

	}
	
	@Test
	//字串常用next & nextLine
	public void ScannerTest2() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請輸入文字:");
		String a = scan.nextLine();
		System.out.println("輸入的文字是:" + a);

	}
	
	//數字常用nextInt,前面的資料型態需改為int a = scan.nextInt();
	@Test
	public void ScannerTest3() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請輸入數字:");
		int a = scan.nextInt();
		System.out.println("輸入的數字是:" + a);

	}
	
	
	@Test
	public void switchTest1() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請輸入成績:");
		int input = scan.nextInt();
		switch(input/10) {
			case 10:
				System.out.println("A+");
				break;
			case 9:
				System.out.println("A");
				break;
			case 8 :
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
		}
	}
	
	@Test //當兩個不同條件但執行相同內容時,結果相同時可以寫在一起併排case10 & case9
	public void switchTest2() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請輸入成績:");
		int input = scan.nextInt();
		switch(input/10) {
			case 10:
			case 9:
				System.out.println("A");
				break;
			case 8 :
				System.out.println("B");
				break;
			case 7:
				System.out.println("C");
				break;
			default:
				System.out.println("D");
		}
	}
	
	
	/*練習2:假設今天是星期天,請輸入days後,可以回應所輸入的days天後是星期幾
	 * 假設今天是星期X(X為輸入值)*/
//	public void weeksTest() {
//		Scanner days = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
//		System.out.println("請問今天是星期幾 :");
//		int weeksday = days.nextInt();
//		switch(x%7) {
//			case 0:
//				System.out.println(x+"天後是星期日");
//				break;
//			case 1:
//				System.out.println(x+"天後是星期一");
//				break;
//			case 2:
//				System.out.println(x+"天後是星期二");
//				break;
//			case 3:
//				System.out.println(x+"天後是星期三");
//				break;
//			case 4:
//				System.out.println(x+"天後是星期四");
//				break;
//			case 5:
//				System.out.println(x+"天後是星期五");
//				break;
//			case 6:
//				System.out.println(x+"天後是星期六");
//				break;
//			default:
//				System.out.println("")
//		}
//	}
	
	@Test
	public void weeksTest2() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請問今天是星期幾 :");
		String inputStr= scan.next();
		int weekday = 0; 
//		String[] strArray = {} 
		switch(inputStr) {
			case "日":
			case "天":
				weekday = 7;
				break;
			case "六":
				weekday = 6;
				break;
			case "五":
				weekday = 5;
				break;
			case "四":
				weekday = 4;
				break;
			case "三":
				weekday = 3;
				break;
			case "二":
				weekday = 2;
				break;
			case "一":
				weekday = 1;
				break;
		}
		System.out.println("請輸入幾天後的天數 :");
		int days = scan.nextInt();
		switch((weekday+days)%7) {
			case 0 :
				System.out.printf("今天是星期%s,%d天後是星期天",inputStr ,days);// %s為字串型態,%d為數字型態
				break;
			case 1 :
				System.out.printf("今天是星期%s,%d天後是星期一",inputStr, days);
				break;
			case 2 :
				System.out.printf("今天是星期%s,%d天後是星期二",inputStr, days);
				break;
			case 3 :
				System.out.printf("今天是星期%s,%d天後是星期三",inputStr, days);
				break;
			case 4 :
				System.out.printf("今天是星期%s,%d天後是星期四",inputStr, days);
				break;
			case 5 :
				System.out.printf("今天是星期%s,%d天後是星期五",inputStr, days);
				break;
			case 6 :
				System.out.printf("今天是星期%s,%d天後是星期六",inputStr, days);
				break;
		}
	}
	
	@Test
	public void weeksTest3() {
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("請問今天是星期幾 :");
		int inputInt = scan.nextInt();
		String weekdays = switchDay(inputInt);
		
		System.out.println("請輸入幾天後的天數 :");
		int days = scan.nextInt();
		String output = switchDay((inputInt+days)%7);
		
		System.out.printf("今天是星期%s, %d天後是星期%s",weekdays,days,output);
	}
		
	@Test  //↓回傳值型態:要回傳字串所以void須改為String(字串)
	public String switchDay(int inputInt) {	 //在定義方法的參數內要給予他一個資料型態接著為參數名稱
		String weekdays = "";	//需初始化weekdays賦予它一個初始值為空字串
		switch (inputInt) {
		case 0:
			weekdays = "日";
			break;
		case 6:
			weekdays = "六";
			break;
		case 5:
			weekdays = "五";
			break;
		case 4:
			weekdays = "四";
			break;
		case 3:
			weekdays = "三";
			break;
		case 2:
			weekdays = "二";
			break;
		case 1:
			weekdays = "一";
			break;
		}
		return weekdays;	//回傳weekdays變數
	}
}


