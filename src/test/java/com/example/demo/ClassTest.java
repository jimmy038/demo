package com.example.demo;


import static org.mockito.ArgumentMatchers.intThat;

import java.util.Random;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.example.demo.entity.Dog;
import com.example.demo.entity.TaipeiBank;

public class ClassTest {

	@Test
	public void classTest() {
		Dog yourDog = new Dog(); 
		System.out.println(yourDog.getName());
		yourDog.setName("cat");
		System.out.println("===============================");
		Dog myDog = new Dog();
		System.out.println(myDog.getName());
		myDog.setName("Monkey");
		System.out.println(yourDog.getName());
		System.out.println(myDog.getName());
//		String name = dog.getName();//���^�ѼƱ��^dog�̭���name
		System.out.println("===============================");
	}
	
	@Test
	public void classTest1() {
		Dog dog = new Dog();
		dog.setAttributes("Red", "Lily", 2);
		System.out.println("====================");
	}
	
	@Test	//@Test�q�`�������Ҽg����k���T�ʻP�_
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		//判斷是否正確Assert.isTrue();
		Assert.isTrue(bank.getBalance() == 1000, "saving error!!"); //���Ҽg����k�O�_���T:Assert.isTrue(�P�_�O�_���T)
		
		bank.saving(-500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error!!");
		System.out.println(bank.getBalance());
		bank.saving(500);
		Assert.isTrue(bank.getBalance() == 1800, "saving error!!");
		System.out.println(bank.getBalance());
		System.out.println("====================");
	}
	
	@Test
	public void classTest3() { //�gwithdarw(����)
		Scanner scan = new Scanner(System.in);	//Scanner���O���ڭ̿�J���F��n�N��J���L�X��(System.in)
		System.out.println("�z�n�w��ϥδ��ھ� :");
		String inputInt = scan.next();
		TaipeiBank bank1 = new TaipeiBank();
		bank1.withdarw(0);
		System.out.println(bank1.getBalance());
		//��Assert.isTrue�P�_���G�O�_���u,���ݭn���ӰѼ�,�Ĥ@�ӰѼƬ��P�_��,�ĤG�ӰѼƬ���e�����P�_�����O�A�n�����G�ɧA�n�^�Ǫ���T�����L
		Assert.isTrue(bank1.getBalance() ==1000, "�ٷQ���!!");
		
		bank1.withdarw(500);
		Assert.isTrue(bank1.getBalance() ==500, " �O��F�ѥS!!");
		System.out.println(bank1.getBalance());
		
		bank1.withdarw(1000);
		Assert.isTrue(bank1.getBalance() == 0, " �S�����_�� !!");
		System.out.println(bank1.getBalance());
		System.out.println("====================");
	}
	
	@Test
	public void classTest4() {
		int a = 5;
		int b = 5;
		System.out.println(a == b);
		System.out.println("=============================");
	}
	
	@Test
	public void classTest6() {
		Dog dog = new Dog(); //���p�A�����O��k
		dog.setName("Lily");
		dog.setColor("blue");
		dog.setAge(2);
		System.out.println("=============================");
		Dog dogg = new Dog("QQQQ","GGG", 3); //���P��W���T��set�ݩʪ�²�g,�����b�غc��k��Set�ݩ�
		System.out.println(dogg);
		System.out.println("=============================");
	}
	
	@Test
	public void classTest7() { //�ϥ�static��k,static�û��u�s�b�@�հO����Ŷ�
		Dog dog = new Dog();
		dog.setAttributes();  //�@���k���I�s,�����n�������Onew�X��
		
		Dog.setAttributes2(); //static��k���I�s,�����ϥ����O�W���I.static ��k,�Y�i���ݭnnew
		System.out.println("=============================");
		Math.random();		 
		Random ran = new Random();
		ran.nextInt();
		System.out.println("=============================");
		final int b =50; //final�]�w���ȫ�L�k�A�Q���
//		b=100;
	}
}
