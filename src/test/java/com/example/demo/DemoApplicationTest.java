package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoApplicationTest {

	@Test
	//�D�n���c(�ݭI�_��)		   void���|�^�ǥ��󪺭�		  ��k�W�ٳ��@�w�|�a�p�A��()�i�M�w�O�_�a�i�Ѽ�//
	/*�U�謰��k���cpublic(�v��)void(�^�ǭȫ��A)firstTest(��k�W��(�Ѽ�))(��k�W�٦۩w�q)�j�A����{}
	���g�޿跧�����ϰ� */
	public void firstTest() {
		int a = 5 ;
		System.out.println(a);
		//�r��q�`���|�ŧi���ܼƪ�������(�r��걵�����ϥ�+�Ÿ��Y�i)
		String str1 = "123";
		String str = new String("ABC");
		System.out.println(str + str1);
		
	}

}
