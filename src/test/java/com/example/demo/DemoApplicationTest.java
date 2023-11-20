package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoApplicationTest {

	@Test
	//主要結構(需背起來)		   void不會回傳任何的值		  方法名稱都一定會帶小括號()可決定是否帶進參數//
	/*下方為方法結構public(權限)void(回傳值型態)firstTest(方法名稱(參數))(方法名稱自定義)大括號內{}
	為寫邏輯概念的區域 */
	public void firstTest() {
		int a = 5 ;
		System.out.println(a);
		//字串通常都會宣告完變數直接給值(字串串接直接使用+符號即可)
		String str1 = "123";
		String str = new String("ABC");
		System.out.println(str + str1);
		
	}

}
