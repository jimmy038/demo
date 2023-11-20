package com.example.demo.entity;

			 //Bird繼承Animal(此時Bird為子類別Animal為父類別)
public class Bird extends Animal{ //extends擴充(繼承關鍵字),繼承Animal
	
	//HAS-A 關係 (聚合(包含))(沒關係的繼承),單純為了減少程式碼的重複,把重複的東西抽出產生一個新的類別
	//因需要的屬性被原有的類別(class)所定義了,所以當需要這些屬性時可以直接拿TaipeiBank類別來使用
	private TaipeiBank bank;	//私有屬性TaipeiBank,若有需要TaipeiBank的三個屬性,可以使用TaipeiBank所定義的屬性	
	
//	private String branch;	
	
//	private String user;
	
//	private int balance = 1000;	
	
	
	public Bird() {
		super();
		System.out.println("Bird 建構方法");
	}	
	
// 繼承父類別相同的屬性及方法可以先註解or刪除
// 在繼承內當子類別及父類別有相同名稱方法時,子類別若要複寫重新定義自己的方法時
	
	//當父子類別有相同方法名稱,子類別對此方法重新定義自己的實作內容時{}大括號內的實作內容
	//@Override為:複寫的意思 or 重新定義(習慣寫上@Override)
	@Override 
	public void eat() {
		//super.代表呼叫父類別的方法,去get父類別(Animal)的getName方法
		System.out.println(super.getName() + "邊吃邊玩!!");
	}
	
	@Override
	public void sleep() {
		//super.代表呼叫父類別的方法,去get父類別(Animal)的getName方法
		System.out.println(super.getName() + "邊吃邊睡!!");
	}
	
	public void flying() {
		//super.代表呼叫父類別的方法,去get父類別(Animal)的getName方法
		System.out.println(super.getName() + " 正在飛!!"); 
	}		
	
}
