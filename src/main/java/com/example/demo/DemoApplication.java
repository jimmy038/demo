package com.example.demo;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//					   ↓加上這段做排除,排除spring security的預設登入   ↓之後教到controller再回來拿掉
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class DemoApplication { //DemoApplication主要應用的所在
//					   ↓main整個專案的入口點,一個專案只會有一個入口點
	public static void main(String[] args) {
	
		int x = 5;
		System.out.println(x);
		System.out.print(x + "\n");	//"\n"換行符號
		System.out.println("");
		System.out.printf("x = %d",x);
		
		//char字元(字元使用單引號)
		char a = 'a';
		char aa = 97;
		System.out.print("\n"+"a="+a+"\t aa="+aa+"\n");
		int y = 6;
		System.out.print(x<y);
		String str = "This is a String";
		System.out.print(str + x);
		Integer xx = 5;
		
		//整數資料型態 進位表示方法
		int x1;
		long y1;
		x1 = 103;						//設定10進位整數
		System.out.println("列印103 的值 = " + x1);
		x1 = 0b111;						//設定2進位整數
		System.out.println("列印0b111 的值 = " + x1);
		y1 = 022;						//設定8進位整數
		System.out.println("列印022 的值 = " + y1);
		y1 = 0x2B;						//設定16進位整數
		System.out.println("列印0x2B 的值 = " + y1);
		
		//實例操作練習 ▪ 每小時時薪是120元,一天工作8小時,一年工作300天,請計算一年
		//可以賺多少錢,用變數 z 儲存一年所賺的錢
		int x2;
		int z;
		x2 = 120;
		z = x2 * 8 * 300;
		System.out.println("一年可以賺 : " + z);
		
		/* ▪練習: */
		/*延續上面實例,如果每個月花費是9000元,用變數 y 儲存一年所花的錢,*/
		/*用變數 s 儲存一年可以儲存多少錢*/
		int x3 = 120; 			//設定變數x3為時薪
		int z2 = x3 * 8 * 300;	//設定變數z2為一年賺的錢
		int y2 = 9000 * 12; 	//設定變數y2為每年花費
		int s = z2 - y2;
		System.out.println("一年可以儲存的錢 : " + s);
		
		/* 基本運算符號 */
		/* 二元運算子Binary(最常使用到) 需要有2個運算子才可以運算的符號(下列有=及+符號)即稱為二元運算子*/
		int x6 = 5 + 7;
		System.out.println("x6:" + x6);
		int y5 = 5 - 7;
		System.out.println("y5:" + y5 );
		int z1 = 5 * 7;
		System.out.println("z1:" + z1);
		int k = 5 / 7;
		System.out.println("整數除法 k: " + k);
		double k2 = 5 / 7.0;
		System.out.println("浮點數除法 k2: " + k2);
		
		/*二元運算子Binary(包含上面加減乘除)*/
		if (k == k2) {
			System.out.println("k = k2");
		}else {
			System.out.println("k != k2");
		}
		
		/* 一元運算子Unary */
		x++;
		System.out.println(x);
		y--;
		System.out.println(y);
		boolean bool = true;
		System.out.println(!bool); /*反向運算子,符號是!(驚嘆號) (true變false,false變true)*/
		
		/* 三元運算子Unary */
		//(條件)?(條件為true印出):(條件為false印出)
		System.out.println(x > y ? x:y);

		/*遞增運算子的(前置運算,後置運算) */
		int i,j,value;
		i = j = 10;
		value = ++i * 10;	/*前置運算(遞增放前面)*/
		System.out.println("前置運算 value =" + value);
		value = j++ * 10;	/*後置運算(遞增放後面)*/
		System.out.println("後置運算 value =" + value);
		
		System.out.println("value i =" + i);
		System.out.println("value j = " + j);
		
		/*Scanner輸入*/
		Scanner scan = new Scanner(System.in);
		int x5,y6;
		String str2 = null;
		x5 = scan.nextInt();
		y6 = scan.nextInt();
		str = scan.next();
		System.out.println(x5 + "\t" + y6 + "\t" + str2 );
		
		a = 5;	 //主要作用對象為a這個變數
		y = ++a; //++a的意思為先做++就是先把a加1再加a再把結果賦予給y
		z = a++; //a++意思為先把a賦予值給z再做加一 a = a+1
		
	}
}
