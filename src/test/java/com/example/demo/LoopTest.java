package com.example.demo;

import static org.mockito.ArgumentMatchers.intThat;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import ch.qos.logback.core.util.SystemInfo;

public class LoopTest {

	@Test
	public void LoopTest() { // �_���j��99���k
		System.out.println("========");
		for (int i = 1; i < 5; i++) { // ���N�̫�~��
			System.out.println("i = " + i);
		}
		System.out.println("========");
		for (int i = 1; i < 5; ++i) { // ���N�̫�~��
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
	public void randomTest() { // random���O
		// ����:(�϶��W����-�϶��U����+1) + �϶��U����
		// ����1~99�ü�:�϶��W����=99 - �϶��U���� = 1 +1
		double random = Math.random() * (99 - 1 + 1) + 1;
		// ����20~50�ü�:�϶��W����=50 - �϶��U���� = 20 +1
		double random1 = Math.random() * (50 - 20 + 1) + 20;
		System.out.println("==========================");
		Random ran = new Random();

		// Random ���O�̪� nextInt(���):�|���� 0~�p���J���i����
		// ����1~99
		int a = ran.nextInt(99) + 1;
		
	}

	@Test
	public void guessTest() {	//�q�Ʀr
		Scanner num = new Scanner(System.in); //num�ܼƩ�i��J���ȥk�䬰�T�w�榡
		Random ran = new Random(); 
		int bingo = ran.nextInt(98)+2;
		System.out.println(bingo);
		int max = 98;
		int min = 2;
		int x = 0;
		while (true) {
			System.out.printf("�п�J�@��%d~%d���������:", min, max);
			x = num.nextInt();
			if (x > max || x < min) {
				System.out.println("�п�J�d�򤺪��Ʀr");
			} else if (x < bingo) {
				min = x;
				System.out.println("�вq�j�@�I");
			} else if (x > bingo) {
				max = x;
				System.out.println("�вq�p�@�I");
			} else {
				System.out.println("����F");
				break;
			}
		}
	}
	
	@Test
	public void guessTest1() {		//�q�Ʀr �W�ҽm��
		Scanner scanner = new Scanner(System.in);
		int max = 99;
		int min = 1;
		System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
		int input  = scanner.nextInt();
		int ans = (int)(Math.random()*(99-1+1))+1;
		for(;;) {
			if(input < min || input > max) {
				System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
			}else if (input == ans) {
				System.out.printf("�q��F");
				break;
			}else if (input > ans) {
				max = input;
				System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
			}else if (input < ans) {
				System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
				min = input;
				System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
			}
		}
	}
	
	@Test
	public void guessTest2() {		//�q�Ʀr,�W�ҽm��
		Scanner scanner = new Scanner(System.in);
		int max = 99;
		int min = 1;
		int ans = (int)(Math.random()*(99-1+1))+1;
		for(;;) {
			System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
			int input  = scanner.nextInt();
			if(input < min || input > max) {
				continue;
			}else if (input == ans) {
				System.out.printf("�q��F");
				break;
			}else if (input > ans) {
				max = input;
			}else if (input < ans) {
				min = input;
			}
		}
	}
	
//	@Test
//	public void guessTest3() {		//�q�Ʀr,�W�ҽm��,�Ѯv�g�k
//		Scanner scanner = new Scanner(System.in);
//		int max = 99;
//		int min = 1;
//		int ans = (int)(Math.random()*(99-1+1))+1;
//		for(;;) {
//			System.out.printf("�Цb %d ~ %d �����q�@�ӼƦr",min,max);
//			int input  = scanner.nextInt();
//			if(input < min || input > max) {
//				continue;		//continue�������o�϶��N���|���U����F
//			}
//			if (input == ans) {
//				System.out.printf("�q��F");
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
