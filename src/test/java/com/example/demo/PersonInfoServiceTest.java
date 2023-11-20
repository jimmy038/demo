package com.example.demo;	//測試寫方法的地方Test


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

//整個PersonInfo的概念與Menu相同

/*加@SpringBootTest用意為,先從main入口點進入,main為整個專案的入口點,
 一個專案只會有一個入口點,↓DemoApplication裡面的main為整個專案的入口點,DemoApplication為這個專案主要應用的所在*/
@SpringBootTest(classes = DemoApplication.class)
public class PersonInfoServiceTest {

//對Service做測試,因Service有被spring boot託管了,把Service@Autowired(依賴注入)進來
	@Autowired
	public PersonInfoService personInfoService;
	
	@Autowired	//@Autowired,依賴注入(DI)PersonInfoDao
	private PersonInfoDao personInfoDao;
	
							  /*在JPA內save認的是PK(唯一值),若PK相同會去更新後面欄位的值,
	@Test						若PK不同時save會去新增一筆資料,所以save同時可以達到新增,修改一筆資料*/
	public void addPersonInfo() {
		personInfoService.addPersonInfo(new PersonInfo("Hello", "jimmy", 20, "Khh"));
		personInfoService.addPersonInfo(new PersonInfo("S123456789", "jimmy", 23, "Taipei"));
	}
	
	@Test
	public void addInfoTest2() {  //測試(實作)addInfoList
		List<PersonInfo> list = new ArrayList<>();
		list.add(new PersonInfo("G225564789", "KKK", 28, "Kaohsiung"));
		list.add(new PersonInfo("F123456789", "FFF", 30, "Taichung"));
		personInfoService.addInfoList(list);
	}
	
	@Test
	public void deleteAll() { //刪除資料庫的資料方法(但資料庫資料幾乎不刪除)
		personInfoService.deleteAll(); //帶進PersonInfoService內的deleteAll的方法
	}
	
	
	@Test
	public void daoSaveAllTest() { //SaveAll
		List<PersonInfo> list = new ArrayList<>(); //List新增固定格式<>,List <> list = new ArrayList<>();
		list.add(new PersonInfo("A123456787", "DDD", 28, "Kaohsiung"));//將這筆資料加到list裡面
		list.add(new PersonInfo("E123456787", "EEE", 29, "Taipei"));   //將這筆資料加到list裡面	
		personInfoDao.saveAll(list); //SaveAll放多筆資料,save放一筆資料
	} 
	
	@Test
	public void daoFindTest() { //findById指的是在entity這張表內有下id的欄位或是屬性,id指的是有下PK的欄位
		Optional<PersonInfo> infoOp = personInfoDao.findById("A123456787"); //JPA自己寫的Optional,先用一個變數把他接回來移到紅蚯蚓點第一個
		if(infoOp.isEmpty()) { //isEmpty(空),條件判斷內(如果為空),相反為isPresent為有
			System.out.println("Not found!!");//如果為空印出
//			return; 若不寫else就直接在if內印出後return否則會接著印出下面那行
		}else {
			System.out.println(infoOp.get().getName()); //先用.get(),因為他被Optional<>包起來,所以要取出要先用.get()再去.getName
		}
	}
	
	
	@Test
	public void daoFindTest2() { //findAll找全部,使用list變數接回來,一樣報紅蚯蚓點第一個自動產生
		List<PersonInfo> list = personInfoDao.findAll(); //findAll找全部,括號內不帶參數
		for (PersonInfo item : list) { //使用for迴圈,forEach遍歷全部資料
			System.out.println(item.getName());
		}
	}
	
	
	@Test	//existsById跟findByID的差異為:findByID為撈出資料後續需要用到資料時使用,findByID撈回來時就為一個物件,
	public void daoFindTest3() { //若只是單純判斷這筆資料是否存在資料庫時,就使用existsById判斷這筆資料是否存在於資料庫
		boolean result = personInfoDao.existsById("A123456787"); //資料型態布林,詢問這筆資料是否正確true or false
		System.out.println(result);
	}
	
	
	@Test
	public void daoFindTest4() {	
		List<PersonInfo> result = personInfoDao.findByCity("Kaohsiung"); //result變數名稱中文為結果
//		System.out.println(result.size()); //印出2,因資料庫內有兩筆City欄位內為Kaohsiung的資料
		for(PersonInfo item : result) {	//遍歷過一次
			System.out.println(item.getName()); //再印出有Kaohsiung的City欄位內的名稱為DDD&KKK,因getName()
		}
	} 
	
//=============================分隔線=========================================//	
	@Test	//1.新增資料的測試
	public void addInfoText() {	
		//ID 不符合條件 ID不得為空字串
		PersonInfo result = personInfoService.addInfo(new PersonInfo("","GGG",36,"Taipei"));
		Assert.isTrue(result == null,"addMenu error!!");
		//name 不符合條件 name不得為空字串
		result = personInfoService.addInfo(new PersonInfo("A224567890","",32,"Taipei"));
		Assert.isTrue(result == null,"addMenu error!!");
		//age不符合條件 age不得為空
		result = personInfoService.addInfo(new PersonInfo("A224567897","GGG",0,"Taipei"));
		Assert.isTrue(result == null,"addMenu error!!");
		//city不符合條件 city不得為空
		result = personInfoService.addInfo(new PersonInfo("A224567897","GGG",36,"Taipei"));
		Assert.isTrue(result == null,"addMenu error!!");
		//正常新增一筆資料
		result = personInfoService.addInfo(new PersonInfo("A224567898","MMM",24,"Taipei"));
		Assert.isTrue(result != null,"addMenu error!!");
		//新增已存在的資料
		result = personInfoService.addInfo(new PersonInfo("A224567892","ZZZ",28,"Kaohsiung"));
		Assert.isTrue(result == null,"addMenu error!!");
		//刪除資料
		personInfoDao.deleteById("A224567892");
	}

	@Test	//2.取得所有個人資訊
	public void findAllText() {	
		List<PersonInfo> list = personInfoDao.findAll();
		for(PersonInfo item:list){
			System.out.println(item.getId( )+ " " + item.getName()+ " " +item.getAge()+ " " +item.getCity());
		}
	}

	@Test	//3.尋找ID對應的個人資訊
	public void findByIdText() { 
		Optional<PersonInfo> idOP = personInfoDao.findById("A224567892");
		if(idOP.isEmpty()) {
			System.out.println("ID error!!");
		}else {
			System.out.println(idOP.get().getId());
		}
	}
	
	@Test	//4.比較年紀大小
	public void findByAgeGreaterThan() { 
		List<PersonInfo> res = personInfoDao.findByAgeGreaterThan(30);
		for(PersonInfo item : res) {
			System.out.println(item.getAge());
		}
	} 

	@Test	//5.找出年紀小於條件的所有個人資訊
	public void findByAgeLessThanEqualOrderByAge() { 
		List<PersonInfo> res = personInfoDao.findByAgeLessThanEqualOrderByAge(38);
		for(PersonInfo item : res) {
			System.out.println(item.getId()+item.getName()+item.getAge()+item.getCity());
		}
	}
	
	@Test	//6.年齡小於條件1或是大於輸入條件2的資訊
	public void findByAgeLessThanOrAgeGreaterThan() { 
		 List<PersonInfo> res = personInfoDao.findByAgeLessThanOrAgeGreaterThan(26, 32);
		for(PersonInfo item : res) {
			System.out.println(item.getAge());
		}
	}
	
	@Test	//7.找到年紀介於2個數字之間(有包含)的資訊  以年齡由大到小排序	 只取前3筆資料
	public void findTop3ByAgeBetweenOrderByAgeDesc() {
		List<PersonInfo> res = personInfoDao.findTop3ByAgeBetweenOrderByAgeDesc(26, 30);
		for(PersonInfo item : res) {
			System.out.println(item.getId()+item.getName()+item.getAge()+item.getCity());
		}
	}
	
	@Test	//8.取得 city 包含某個特定字的所有個人資訊
	public void findByCityContaining() {
		 List<PersonInfo> res = personInfoDao.findByCityContaining("a");
		for(PersonInfo item : res) {
			System.out.println(item.getId()+item.getName()+item.getAge()+item.getCity());
		}
	}
	
	@Test //9.找出年紀大於輸入條件以及city 包含某個特定字的所有人資訊	▪ 依照年齡由大到小排序
	public void findByAgeGreaterThanAndCityContainingOrderByAgeDesc() {
		 List<PersonInfo> res = personInfoDao.findByAgeGreaterThanAndCityContainingOrderByAgeDesc(26, "Taipei");
		 for(PersonInfo item : res) {
			 System.out.println(item.getId()+item.getName()+item.getAge()+item.getCity());
		 }
	}
	
}
