package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.service.ifs.AtmService;
import com.example.demo.vo.AtmResponse;

@SpringBootTest //Test���n����@SpringBootTest
public class AtmServiceTest {

	@Autowired //��AtmService DI�i��
	private AtmService atmService;
	
	@Test
	public void addInfoTest() {
		AtmResponse res = atmService.addInfo("A03", "AA456");
		System.out.println(res.getRtnCode().getCode()); //�]�Q�]�bAtmResponse���U��Rtncode�����U��code��message,�ҥH�ݭn�h�h���X
		System.out.println(res.getRtnCode().getMessage()); //�]�Q�]�bAtmResponse���U��Rtncode�����U��code��message,�ҥH�ݭn�h�h���X
		System.out.println(res.getAtm().getAccount());	   //
		System.out.println(res.getAtm().getPwd().length());//
	}
	
}
