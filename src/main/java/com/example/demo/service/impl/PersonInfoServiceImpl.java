package com.example.demo.service.impl; //做實作寫邏輯及方法的地方impl

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo.entity.PersonInfo;
import com.example.demo.repository.PersonInfoDao;
import com.example.demo.service.ifs.PersonInfoService;

//↓請spring boot託管又稱控制反轉(IOC) 
@Service	/*PersonInfoServiceImpl  ↓去實作    PersonInfoService*/
public class PersonInfoServiceImpl implements PersonInfoService{
	
	@Autowired //把託管給spring boot,PersonInfoDao依賴注入(DI)通常又稱DI實現IOC,(DI)關鍵字:@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public void addPersonInfo(PersonInfo personInfo) {
		//使用if else及正規表達式判斷id格式是否正確,使用pattern變數接正規表達式的格式
		String id = personInfo.getId(); //取出id,getid的方法
		//pattern為id所需求的條件,設定在大寫小A到Z,排除ABDEFHabdefh,後面兩碼1或2,後面8碼
		String pattern = "[A-Za-z][1,2]\\d{8}"; 
		if (id.matches(pattern)) {	//id比對pattern的格式是否正確,(物件)點(方法)
			System.out.println("符合格式!!");
			personInfoDao.save(personInfo); //存資料進到資料庫內,jpa內的save認得是PK,save存取資料,存取資料時認得是ID
		}else {								//若PK(唯一值)存在時會修改一筆資料,不存在時新增一筆資料,PK同時可以做到增修兩樣
			System.out.println( "不符合格式!!");
		}
	}
	
//=================================分隔線====================================//	
	@Override // 重新定義新增方法
	public PersonInfo addInfo(PersonInfo personInfo) {
		if (!StringUtils.hasText(personInfo.getId()) || !StringUtils.hasText(personInfo.getName())
				|| personInfo.getAge() <= 0 || !StringUtils.hasText(personInfo.getCity())) {
			return null;
		}
		if (personInfoDao.existsById(personInfo.getId())) {
			return null;
		}
		return personInfoDao.save(personInfo);
	}
	
	
	@Override //重新定義findAll方法
	public List<PersonInfo> findAll() {
		return personInfoDao.findAll();
	}
	
	@Override //重新定義findById方法
	public PersonInfo findById(String name) {
		Optional<PersonInfo> op = personInfoDao.findById(name);
		if(op.isEmpty()) {
			return null;
		}
		return op.get();
	}
	
//========================分隔線====================================//
	@Override
	public void deleteAll() {	//重新定義刪除資料的方法
		personInfoDao.deleteAll();
	}

	@Override	//這部分為save跟saveAll,對於資料檢查單筆跟多筆
	public void addInfoList(List<PersonInfo> infoList) { //假設infoList有10筆資料
		String pattern = "[a-zA-Z][1,2]\\d{8}";	
		for (PersonInfo item : infoList ) { //使用foreach遍歷逐筆檢查
			String id = item.getId();
			//StringUtils.hasText(id)檢查是否為空不是空為true,否則false
			//以下寫法為:↓如果ID為null 且 ID不符合pattern時的結果是相反時(!),整個條件判斷完結果相反
//			if(!(StringUtils.hasText(id) && id.matches(pattern))) { //此寫法為原本判斷的整個正向結果做反向變更
//				System.out.println("id error!!");
//				return; //return跳出方法對應到void
//			}
			//↓如果判斷完為false的話或者 ID比對pattern結果不符合時,就印出"id error!!"最後跳出
			if(!StringUtils.hasText(id) || !id.matches(pattern)) { /*hasText判斷完為false時或pattern比對結果為false時
				System.out.println("id error!!");					當兩樣條件滿足其中一個時告訴他id錯誤*/
				return; //return跳出方法對應到void
			}
		}	//for迴圈做檢查判斷完後再存入資料
		personInfoDao.saveAll(infoList); //從save變成saveAll減少與資料庫操作的次數,一次存多筆資料
	}



}
