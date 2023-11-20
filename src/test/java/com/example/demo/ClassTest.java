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
		Dog yourDog = new Dog(); //宣告Dog前面是class類別,接著dog變數
		System.out.println(yourDog.getName());
		yourDog.setName("cat");
		System.out.println("===============================");
		Dog myDog = new Dog();
		System.out.println(myDog.getName());
		myDog.setName("Monkey");
		System.out.println(yourDog.getName());
		System.out.println(myDog.getName());
//		String name = dog.getName();//接回參數接回dog裡面的name
		System.out.println("===============================");
	}
	
	@Test
	public void classTest1() {
		Dog dog = new Dog();
		dog.setAttributes("Red", "Lily", 2);
		System.out.println("====================");
	}
	
	@Test	//@Test通常拿來驗證寫的方法正確性與否
	public void classTest2() {
		TaipeiBank bank = new TaipeiBank();
		System.out.println(bank.getBalance());
		//↓Assert.isTrue判斷結果是否為真,內需要放兩個參數,第一個參數為判斷式,第二個參數為當前面的判斷式不是你要的結果時你要回傳的資訊給予他
		Assert.isTrue(bank.getBalance() == 1000, "saving error!!"); //驗證寫的方法是否正確:Assert.isTrue(判斷是否正確)
		
		bank.saving(-500);
		Assert.isTrue(bank.getBalance() == 1000, "saving error!!");
		System.out.println(bank.getBalance());
		bank.saving(500);
		Assert.isTrue(bank.getBalance() == 1800, "saving error!!");
		System.out.println(bank.getBalance());
		System.out.println("====================");
	}
	
	@Test
	public void classTest3() { //寫withdarw(提款)
		Scanner scan = new Scanner(System.in);	//Scanner像是掃我們輸入的東西要將輸入的印出需(System.in)
		System.out.println("您好歡迎使用提款機 :");
		String inputInt = scan.next();
		TaipeiBank bank1 = new TaipeiBank();
		bank1.withdarw(0);
		System.out.println(bank1.getBalance());
		//↓Assert.isTrue判斷結果是否為真,內需要放兩個參數,第一個參數為判斷式,第二個參數為當前面的判斷式不是你要的結果時你要回傳的資訊給予他
		Assert.isTrue(bank1.getBalance() ==1000, "還想領阿!!");
		
		bank1.withdarw(500);
		Assert.isTrue(bank1.getBalance() ==500, " 別領了老兄!!");
		System.out.println(bank1.getBalance());
		
		bank1.withdarw(1000);
		Assert.isTrue(bank1.getBalance() == 0, " 沒錢啦寶貝 !!");
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
		Dog dog = new Dog(); //有小括號都是方法
		dog.setName("Lily");
		dog.setColor("blue");
		dog.setAge(2);
		System.out.println("=============================");
		Dog dogg = new Dog("QQQQ","GGG", 3); //等同於上面三行set屬性的簡寫,直接在建構方法內Set屬性
		System.out.println(dogg);
		System.out.println("=============================");
	}
	
	@Test
	public void classTest7() { //使用static方法,static永遠只存在一組記憶體空間
		Dog dog = new Dog();
		dog.setAttributes();  //一般方法的呼叫,必須要先把類別new出來
		
		Dog.setAttributes2(); //static方法的呼叫,直接使用類別名稱點.static 方法,即可不需要new
		System.out.println("=============================");
		Math.random();		 
		Random ran = new Random();
		ran.nextInt();
		System.out.println("=============================");
		final int b =50; //final設定完值後無法再被更改
//		b=100;
	}
}
