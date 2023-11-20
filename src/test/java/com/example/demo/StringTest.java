package com.example.demo;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import com.example.demo.entity.Dog;

public class StringTest {

	@Test //String為一個類別class
	public void stringTest() {
		String str ="ABC";      	    //→使用等號給予值只會存在一個記憶體空間,產生一個特殊記憶體空間為字串池(String Pool)
		String str1 = new String("ABC");//→使用new 類別,只要看到new就是給予一個新的記憶體空間
		String str2 ="ABC";				//→後續若用等號給予值就會進到字串池內去找
//		str = "AB";						//會再進到字串池中,但原本的str字串給予的"ABC"不會消失
		System.out.println(str == str1 );
		System.out.println(str == str2 );
		System.out.println("================================");
//		Java內的字串比較使用	equals,System.out.println(str.equals(str1));
		System.out.println(str.equals(str1));
		System.out.println(str.equals(str2));
		System.out.println("================================");
		String str3 = "aBC";
		System.out.println(str.equals(str3));
//		equalsIgnoreCase不看大小寫只要是abc(ABC)都為true		
		System.out.println(str.equalsIgnoreCase(str3));
		System.out.println("================================");
	}
	
	@Test //String為一個類別class
	public void stringTest1() {
		String str = "ABC";
		String str1 = "";
		String str2 = "  ";
		//字串長度.length()
		System.out.println(str.length()); //長度為3
		System.out.println("str1 length: " + str1.length());//長度為0
		System.out.println("str2 length: " + str2.length());//長度為2
		System.out.println("================================");
		//isEmpty():是看字串的長度是否為0,is在前面的為方法
		System.out.println("str1 isEmpty: " + str1.isEmpty());//isEmpty(是否為空)
		System.out.println("str2 isEmpty: " + str2.isEmpty());		
		System.out.println("================================");
		//isBlank():為空白,1.長度為0 ; 2.字串內容由全空白組成:滿足條件1或2則回傳true
		System.out.println("str1 isBlank: " + str1.isBlank());//結果皆為true
		System.out.println("str2 isBlank: " + str2.isBlank());//結果皆為true
		System.out.println("================================");
	}
	
	@Test //String為一個類別class
	public void stringTest2() {
		Dog dog = new Dog();
		String name = dog.getName();
		String color = dog.getColor();
		System.out.println(name);
		System.out.println(color);
		System.out.println("================================");
		System.out.println(name.length());	//印出指向Dog類別內的Apple長度為5
//		System.out.println(color.length()); //沒有給值預設值為null,當物件or類別為null點.(呼叫方法)時會報錯
		System.out.println(color == null);  //判斷比較null 使用等於等於 == 結果為true ;
		if(color == null || color.isBlank()) {	//一定要先去判斷null 或 color是否為空
			System.out.println("color 是空字串!!");
		}else {
			System.out.println("color 不是空字串!!");
		}
		System.out.println("================================");
		System.out.println(StringUtils.hasLength("  ")); 
		System.out.println(StringUtils.hasText("  "));
		System.out.println("================================");
		color = "";
		if(color.isBlank()) {	//hasText判斷是否有內容
			System.out.println("color 沒有內容!!");
		}else {
			System.out.println("color 有內容!!");
		}
		System.out.println("================================");
		
		if(StringUtils.hasText(color)) {	//hasText判斷是否有內容
			System.out.println("color 有內容!!");
		}else {
			System.out.println("color 沒有內容!!");
		}
		System.out.println("================================");
		
		if(!StringUtils.hasText(color)) {	//hasText判斷是否有內容,在前面加一個驚嘆號!使比對的內容整個為相反true變false,false變true
			System.out.println("color 沒有內容!!");
		}else {
			System.out.println("color 有內容!!");
		}
		System.out.println("================================");
	}
	
	/*練習
	▪ 習題實作題4
	▪ 神鵰俠侶是楊過與小龍女的故事,我不喜歡小龍女的甲仙,雖然小龍女在楊過眼中是清新脫俗
	▪ 計算“小龍女”出現的次數
	▪ 使用 indexOf 計算搜尋字段第一次出現的索引位置,
	▪ 下一次搜尋的位置就從前一次索引值+搜尋字串長度開始,(使用while迴圈-無窮迴圈)*/
	@Test
	public void strIndexTest() {
		String str = "神鵰俠侶是楊過與小龍女的故事,我不喜歡小龍女的甲仙,雖然小龍女在楊過眼中是清新脫俗";
		String name = "小龍女";
		int count = 0; //count計算“小龍女”出現的次數
		int index = str.indexOf(name); //設定初始值,index資料型態為int因為要找索引位置,索引位置為整數
 		
		while (index != -1) {
			count++;
			System.out.printf("%s第%d次出現在%d項",name,count,index);
			index = str.indexOf(name,(index+name.length()));
		}
			System.out.println(name +"一共出現" + count + "次" );
	}
	
	@Test
	public void strIndexTest1() {
		String str = "神鵰俠侶是楊過與小龍女的故事,我不喜歡小龍女的甲仙,雖然小龍女在楊過眼中是清新脫俗";
		String ans ="小龍女";
		int count = 0;
		int index = 0;
		//for迴圈的無窮迴圈
		for(; ;) {
			if (str.indexOf(ans,index) == -1) {
				break;
			}
			count++;
			index = str.indexOf(ans,index) + ans.length();
		}
		System.out.println(count);
		System.out.println("================================");
		//while迴圈
		while (str.indexOf(ans,index)!= -1) {
			count++;
			index = str.indexOf(ans,index) + ans.length();
		}
		System.out.println(count);
		System.out.println("================================");
	}
	
	@Test
	public void replaceTest() {		//replace取代
		String str = "神鵰俠侶是楊過與小龍女的故事,我不喜歡小龍女的甲仙,雖然小龍女在楊過眼中是清新脫俗";
		str = str.replace("小龍女", "小籠包"); //replace針對要改的字串全改,取代全部
		System.out.println(str);
		System.out.println("======================================");
		str = str.replaceAll("小籠包", "小籠湯包"); //repalce&replaceAll都是取代全部
		System.out.println(str); 
	}
	
	@Test
	public void splitTest() {	//split切割(切哪個符號或是字就會不見)
		String str = "神鵰俠侶是楊過與小龍女的故事,我不喜歡小龍女的甲仙,雖然小龍女在楊過眼中是清新脫俗";
		String[] array = str.split(","); //切割掉逗點 
		for (String item : array) {
			System.out.println(item);
		}
		System.out.println("======================================");
		
		String str1 = "ABCD";
		String[] array1=str1.split("");	//會把每一個字一個一個切出來
		for(String item : array1) {
			System.out.println(item);
		}
	}
	
	@Test
	public void trimTest() {	//trim:刪除 刪除字串的前後空白
		String str = "ABC DEF";
		String str1 = " ABC DEF";
		System.out.println(str == str1);
		System.out.println(str.equals(str1)); //字串值的比較使用equals
		str = str.trim();
		str1 = str1.trim();
		System.out.println(str);
		System.out.println(str1);
		System.out.println(str == str1);
		System.out.println(str.equals(str1)); //字串值的比較使用equals
		System.out.println("======================================");
		str = str.replace(" ", ""); //用replace取代去掉全部的空白,replace空白會做兩次遇到一個空白取代後面一個空白接著取代
		System.out.println(str);
	}
	
	@Test
	public void substringTest() {	//substring擷取
		String str = "神鵰俠侶是楊過與小龍女的故事";
		String subStr = str.substring(5);
		String subStr1 = str.substring(5, 11);
		System.out.println(subStr);
		System.out.println(subStr1);
	}
	
	@Test
	public void stringBufferTest() { //stringBuffery字串串接(但不是字串)若要做比較要轉為字串使用toString()
		StringBuffer sb = new StringBuffer("ABC"); //new出來同時帶有預設字串
		sb.append("DEF"); //append附加 在原本的字串附加上DEF字串
		sb.append("GGG");
		sb.append("OAOA").append("HIHI");
		System.out.println(sb);
		System.out.println("======================================");
	}
	
	@Test
	public void stringBufferTest1() { //stringBuffery字串串接(但不是字串)若要做比較要轉為字串使用toString()
		StringBuffer sb = new StringBuffer("ABC"); 
		StringBuffer sb1 = new StringBuffer("ABC"); 
		System.out.println(sb.equals(sb1));
		System.out.println("======================================");
		System.out.println(sb.toString().equals(sb1.toString()));
	}
	
	@Test
	public void stringBufferTest2() { 
		String str = "ABACADEF";
		int index = str.lastIndexOf("A"); //index = 4
		String lastString = str.substring(index); //lastString = ABAC
		lastString = lastString.replace("A", "W"); //lastString = WDEF
		str = str.substring(0, index) + lastString;//str.subString =ABACWDEF 
		System.out.println(str);
	}
	
	@Test
	public void reverseStringTest() { 	//reverse為反轉字串,要讓字串反轉就要轉為StringBuffer類
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入文字 : ");
		String str = scan.next();
		StringBuffer sb = new StringBuffer(str);
		if (str.equals(sb.reverse().toString())) { //轉為字串再比較
			System.out.println(str + "是迴文");
		}else {
			System.out.println(str + "不是迴文");
		}
	}
	
	@Test
	public void stringBufferTest3() {
		Scanner scan = new Scanner(System.in);
		for(;;) {
			System.out.println("請輸入至少兩個以上的文字");
			String str = scan.next();
			if (str.length() <=1) {
				System.out.println("try again");
				continue;
			}
			StringBuffer sb = new StringBuffer(str);
			if (str.equals(sb.reverse().toString())) {
				System.out.println(str + "是迴文");
			}else {
				System.out.println(str + "不是迴文");
			}
			break;
		}
	}
	
	@Test
	public void listTest() {
		Scanner scan = new Scanner(System.in);
		System.out.println("請輸入一個數字");
		int inputInt = scan.nextInt();
		inputInt++;
		String str = String.valueOf(inputInt);
		String[] strArray = str.split("");
		System.out.println(new ArrayList<>(Arrays.asList(strArray)));	
	}
}
