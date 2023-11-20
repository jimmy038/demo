package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest //Test都要先建@SpringBootTest
public class AtmServiceTest {

	@Autowired //把AtmService DI進來
	private AtmService atmService;
	
	@Test
	public void addInfoTest() {
		AtmResponse res = atmService.addInfo("A03", "AA456");
		System.out.println(res.getRtnCode().getCode()); //因被包在AtmResponse底下的Rtncode的底下的code跟message,所以需要層層取出
		System.out.println(res.getRtnCode().getMessage()); //因被包在AtmResponse底下的Rtncode的底下的code跟message,所以需要層層取出
		System.out.println(res.getAtm().getAccount());	   //
		System.out.println(res.getAtm().getPwd().length());//
	}
	
}
