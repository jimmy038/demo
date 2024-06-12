package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class DemoApplicationTest {

	@Test
	public void firstTest() {
		int a = 5 ;
		long b = 7896666666L;
		String string = new String();
		System.out.println(a);
		System.out.println(b);
		//�r��q�`���|�ŧi���ܼƪ�������(�r��걵�����ϥ�+�Ÿ��Y�i)
		String str1 = "123";
		String str = new String("ABC");
		System.out.println("str :" + str + str1);	
	}
}
