package com.example.demo;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.A1;
import com.example.demo.entity.Animal;
import com.example.demo.entity.Bird;
import com.example.demo.entity.C;
import com.example.demo.entity.Car;
import com.example.demo.entity.Cat;
import com.example.demo.entity.Dog;

public class ExtendsTest {

	@Test
	public void extendsTest() {
		Animal anim = new Animal();
		System.out.println("�����O Animal name: " + anim.getName());
		anim.eat();
		anim.sleep();
		// �]�l���O�~�Ӥ����O���ݩʤΤ�k�����Y�ҥHnew Bird()�X�Ӥ���i�H�ϥ�Animal����name�ݩʤ�get.set��k
		// �غc��k�bnew�l���O�ɷ|���]�����O���غc��k�A�]�l���O���غc��k
		Bird brid = new Bird();
		brid.setName("�p��");
		System.out.println("�l���O Bird name: " + brid.getName());
		brid.eat();
		brid.sleep();
		brid.flying();
	}

	@Test
	public void extendsTest1() {
		A1 a1 = new A1();
		// �z�L A1���O���o���O C �����p���ݩ�City
		a1.getC().getCity(); // get C���O����A�h���oC���O����getCity��k
		// ����H�W�{���|����NullPointException
		// �]�����OA1 �����p���ݩ� C �]�O�����O,���O�w�]�ȬOnull
		// a1.getC()�o�쪺�ȷ|�Onull,null�b�I�s��k�ɴN�|����
	}

	@Test
	public void extendsTest2() {
		A1 a1 = new A1();
		// �z�L���O A1 ���o���O C �����p���ݩ�City
		a1.setC(new C());
		C c = a1.getC();
		c.setCity("QQQQ");
		String city = a1.getC().getCity();
		System.out.println(city);
		// �]�����OA1 �����p���ݩ� C �]�O�����O,���O�w�]�ȬOnull
		// �����OC�����ݩʤ@�˷|�O�w�]��,city�OString�w�]�Ȭ�null
	}

	@Test
	public void extendsTest3() {
		C c = new C("AAA", "BBB", "CCC"); // ���b���OC���إߤF�a��3���ݩʪ��غc��k
//		c.setCity("AAA");
//		c.setCounty("BBB");
//		c.setState("CCC");
		A1 a1 = new A1();
		a1.setC(c);
		a1.setAddress("DDD");
		System.out.println("============================");
		System.out.println("city: " + a1.getC().getCity());
		System.out.println("country: " + a1.getC().getCounty());
		System.out.println("state: " + a1.getC().getState());
		System.out.println("address: " + a1.getAddress());
	}

	@Test
	public void extendsTest4() {
		Animal anim = new Animal();	//�쥻�ۤv�����O����
		anim.eat();
		Bird bird = new Bird();
		bird.eat();
		Cat cat = new Cat();
		cat.eat();
		System.out.println("============================");
		Animal animm = new Animal(); //�令�����O����
		animm.eat();
		Animal birdd = new Bird();
		birdd.eat();
		Animal catt = new Cat();
		catt.eat();
	}
	
	@Test
	public void extendsTest5() {
		
	}
	
	@Test
	public void interfaceTest() {
		Car car = new Car();
		car.run();
		Dog dog = new Dog();
		dog.run();
	}
}
