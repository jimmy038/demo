package com.example.demo.entity;

import com.example.demo.service.ifs.RunService;

			//Dog類別,實作(implements)介面(RunService)
public class Dog implements RunService{ // public(被使用的權限最大)方法內的變數不能加權限

	private String name = "Apple"; // private私有(被使用的權限最小),屬性後給等號給預設值,在類別底下的變數稱為屬性

	private String color; // 屬性之間分開較好辨別

	private int age; // 屬性寫完會對屬性產生get set,屬性設為私有寫完需提供方法供別人使用
	
//	public Dog() {	//預設建構方法 權限(public) 類別名稱(Dog)
//	
//	}
	
					//方法名稱同類別名稱Dog,沒有任何的回傳值型態
	public Dog() {	//使用Source產生預設建構方法,點倒數第二個Generate
		super();	//super()用在繼承 子類別呼叫父類別使用super
	}
				
	//只要生成帶有屬性(參數)的建構方法上面的預設建構方法一定要產生
	public Dog(String name, String color, int age) { //帶有屬性(參數)的建構方法
	super();
	this.name = name;
	this.color = color;
	this.age = age;
	}

	public String getName() {	//以下方法為公開
		return name;
	}

	public void setName(String name) {	//方法內為void不需要return,(為參數)
		this.name = name; //this.指的是這個class類別Dog
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAttributes(String name,String color,int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}
	
	public void setAttributes() {
		System.out.println("===========================");
	}
	
	public  static void setAttributes2() {
		System.out.println("===========================");
	}

	@Override	//對紅蚯蚓Dog類別點add產生的一個可以重新定義的方法
	public void run() {
		System.out.println("狗兒在奔跑");
	}
}
