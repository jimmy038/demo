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
		System.out.println("父類別 Animal name: " + anim.getName());
		anim.eat();
		anim.sleep();
		// 因子類別繼承父類別的屬性及方法的關係所以new Bird()出來之後可以使用Animal內的name屬性及get.set方法
		// 建構方法在new子類別時會先跑父類別的建構方法再跑子類別的建構方法
		Bird brid = new Bird();
		brid.setName("小花");
		System.out.println("子類別 Bird name: " + brid.getName());
		brid.eat();
		brid.sleep();
		brid.flying();
	}

	@Test
	public void extendsTest1() {
		A1 a1 = new A1();
		// 透過 A1類別取得類別 C 中的私有屬性City
		a1.getC().getCity(); // get C類別之後再去取得C類別內的getCity方法
		// 執行以上程式會報錯NullPointException
		// 因為類別A1 中的私有屬性 C 也是個類別,類別預設值是null
		// a1.getC()得到的值會是null,null在呼叫方法時就會報錯
	}

	@Test
	public void extendsTest2() {
		A1 a1 = new A1();
		// 透過類別 A1 取得類別 C 中的私有屬性City
		a1.setC(new C());
		C c = a1.getC();
		c.setCity("QQQQ");
		String city = a1.getC().getCity();
		System.out.println(city);
		// 因為類別A1 中的私有屬性 C 也是個類別,類別預設值是null
		// 但類別C中的屬性一樣會是預設值,city是String預設值為null
	}

	@Test
	public void extendsTest3() {
		C c = new C("AAA", "BBB", "CCC"); // 有在類別C中建立了帶有3個屬性的建構方法
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
		Animal anim = new Animal();	//原本自己的類別接的
		anim.eat();
		Bird bird = new Bird();
		bird.eat();
		Cat cat = new Cat();
		cat.eat();
		System.out.println("============================");
		Animal animm = new Animal(); //改成父類別接的
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
