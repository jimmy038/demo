package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ch.qos.logback.core.util.SystemInfo;

public class LoopTest {

	@Test
	public void LoopTest() { // 巢狀迴圈99乘法
		System.out.println("========");
		for (int i = 1; i < 5; i++) { // 迭代最後才做
			System.out.println("i = " + i);
		}
		System.out.println("========");
		for (int i = 1; i < 5; ++i) { // 迭代最後才做
			System.out.println("i = " + i);
		}
	}

	@Test
	public void LoopTest2() {
		a: for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d * %d = %2d;", i, j, i * j);
			}
			System.out.println();
		}
	}

	@Test
	public void randomTest() { // random類別
		// 公式:(區間上限值-區間下限值+1) + 區間下限值
		// 產生1~99亂數:區間上限值=99 - 區間下限值 = 1 +1
		double random = Math.random() * (99 - 1 + 1) + 1;
		// 產生20~50亂數:區間上限值=50 - 區間下限值 = 20 +1
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("==========================");
		Random ran = new Random();

		// Random 類別裡的 nextInt(整數):會產生 0~小於輸入整數i的值
		// 產生1~99
		int a = ran.nextInt(99) + 1;
		
	}

	@Test
	public void guessTest() {	//猜數字
		Scanner num = new Scanner(System.in); //num變數放進輸入的值右邊為固定格式
		Random ran = new Random(); 
		int bingo = ran.nextInt(98)+2;
		System.out.println(bingo);
		int max = 98;
		int min = 2;
		int x = 0;
		while (true) {
			System.out.printf("請輸入一個%d~%d內的正整數:", min, max);
			x = num.nextInt();
			if (x > max || x < min) {
				System.out.println("請輸入範圍內的數字");
			} else if (x < bingo) {
				min = x;
				System.out.println("請猜大一點");
			} else if (x > bingo) {
				max = x;
				System.out.println("請猜小一點");
			} else {
				System.out.println("答對了");
				break;
			}
		}
	}
	
	@Test
	public void guessTest1() {		//猜數字 上課練習
		Scanner scanner = new Scanner(System.in);
		int max = 99;
		int min = 1;
		System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
		int input  = scanner.nextInt();
		int ans = (int)(Math.random()*(99-1+1))+1;
		for(;;) {
			if(input < min || input > max) {
				System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
			}else if (input == ans) {
				System.out.printf("猜對了");
				break;
			}else if (input > ans) {
				max = input;
				System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
			}else if (input < ans) {
				System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
				min = input;
				System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
			}
		}
	}
	
	@Test
	public void guessTest2() {		//猜數字,上課練習
		Scanner scanner = new Scanner(System.in);
		int max = 99;
		int min = 1;
		int ans = (int)(Math.random()*(99-1+1))+1;
		for(;;) {
			System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
			int input  = scanner.nextInt();
			if(input < min || input > max) {
				continue;
			}else if (input == ans) {
				System.out.printf("猜對了");
				break;
			}else if (input > ans) {
				max = input;
			}else if (input < ans) {
				min = input;
			}
		}
	}
	
//	@Test
//	public void guessTest3() {		//猜數字,上課練習,老師寫法
//		Scanner scanner = new Scanner(System.in);
//		int max = 99;
//		int min = 1;
//		int ans = (int)(Math.random()*(99-1+1))+1;
//		for(;;) {
//			System.out.printf("請在 %d ~ %d 之間猜一個數字",min,max);
//			int input  = scanner.nextInt();
//			if(input < min || input > max) {
//				continue;		//continue為執行到這區塊就不會往下執行了
//			}
//			if (input == ans) {
//				System.out.printf("猜對了");
//				break;
//			}
//			if (input > ans) {
//				max = input;
//			}else(input < ans) {
//				min = input;
//			}
//		}
//	}
}
